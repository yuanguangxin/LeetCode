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
