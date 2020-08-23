## Kafka:
### 消费者组到
#### __consumer_offsets： 如果你曾经惊讶于 Kafka 日志路径下冒出很多 __consumer_offsets-xxx 这样的目录，那么现在应该明白了吧，这就是 Kafka 自动帮你创建的位移主题啊。
#### 位移主题分区  offsets.topic.num.partitions 它的默认值是 50
#### 位移主题的 Key 中应该保存 3 部分内容：<Group ID, 主题名，分区号> [groupId,topicName,partitionNumber]
#### 副本数或备份因子 offsets.topic.replication.factor  它的默认值是 3
#### enable.auto.commit：如果值是 true，则 Consumer 在后台默默地为你定期提交位移
        auto.commit.interval.ms：提交间隔
####  Log Compaction 策略来删除位移主题中的过期消息: The idea behind log compaction is selectively remove records where we have most recent update with the same primary key. 

### 生产者压缩算法面面观
1. Producer
props.put("compression.type", "gzip");

2. Broker
情况一 Broker 端指定了和 Producer 端不同的压缩算法。
情况二 Broker 端发生了消息格式转换

3. Consumer
Kafka 会将启用了哪种压缩算法封装进消息集合中，这样当 Consumer 读取到消息集合时，它自然就知道了这些消息使用的是哪种压缩算法

Producer 端压缩、Broker 端保持、Consumer 端解压缩。

在实际使用中，GZIP、Snappy、LZ4 甚至是 zstd 的表现各有千秋。但对于 Kafka 而言，它们的性能测试结果却出奇得一致，即在吞吐量方面：LZ4 > Snappy > zstd 和 GZIP；而在压缩比方面，zstd > LZ4 > GZIP > Snappy。


### 生产者消息分区机制原理剖析
1. org.apache.kafka.clients.producer.Partitioner
int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster);
这里的topic、key、keyBytes、value和valueBytes都属于消息数据，cluster则是集群信息

#### 分区策略
1. Round-robin
2. Randomness
3. Key-ordering
List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
return Math.abs(key.hashCode()) % partitions.size();
        
### 无消息丢失配置

##### 案例 1：生产者程序丢失数据

1. producer.send(msg, callback)
2. 设置 acks = all。acks 是 Producer 的一个参数，代表了你对“已提交”消息的定义。如果设置成 all，则表明所有副本 Broker 都要接收到消息，该消息才算是“已提交”。这是最高等级的“已提交”定义。
3. 设置 retries 为一个较大的值。这里的 retries 同样是 Producer 的参数，对应前面提到的 Producer 自动重试
##### 案例 2：生产者程序丢失数据
1. 设置 replication.factor >= 3。这也是 Broker 端的参数。其实这里想表述的是，最好将消息多保存几份，毕竟目前防止消息丢失的主要机制就是冗余
2. 设置 min.insync.replicas > 1。这依然是 Broker 端参数，控制的是消息至少要被写入到多少个副本才算是“已提交”。设置成大于 1 可以提升消息持久性。在实际环境中千万不要使用默认值 1
3. 确保 replication.factor > min.insync.replicas。如果两者相等，那么只要有一个副本挂机，整个分区就无法正常工作了。我们不仅要改善消息的持久性，防止数据丢失，还要在不降低可用性的基础上完成。推荐设置成 replication.factor = min.insync.replicas + 1。

#### 案例 3：消费者程序丢失数据
1. 确保消息消费完成再提交。Consumer 端有个参数 enable.auto.commit，最好把它设置成 false，并采用手动提交位移的方式。就像前面说的，这对于单 Consumer 多线程处理的场景而言是至关重要的。
维持先消费消息（阅读），再更新位移（书签）的顺序

### Kafka 拦截器
```
public interface ProducerInterceptor<K, V> extends Configurable {
ProducerRecord<K, V> onSend(ProducerRecord<K, V> var1);
    //该方法会在消息发送之前被调用。如果你想在发送之前对消息“美美容”，这个方法是你唯一的机会。
    void onAcknowledgement(RecordMetadata var1, Exception var2);
    //该方法会在消息成功提交或发送失败之后被调用. onAcknowledgement 的调用要早于 callback 的调用
    void close();
}
```

```
public interface ConsumerInterceptor<K, V> extends Configurable {
    ConsumerRecords<K, V> onConsume(ConsumerRecords<K, V> var1);
    //该方法在消息返回给 Consumer 程序之前调用
    void onCommit(Map<TopicPartition, OffsetAndMetadata> var1);
    //Consumer 在提交位移之后调用该方法
    void close();
}
```

