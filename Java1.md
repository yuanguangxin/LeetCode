### 类的加载时机
1. 当虚拟机启动时，初始化用户指定的主类，就是启动执行的 main 方法所在的类;
2. 当遇到用以新建目标类实例的 new 指令时，初始化 new 指令的目标类，就是 new 一个类的时候要初始化;
3. 当遇到调用静态方法的指令时，初始化该静态方法所在的类;
4. 当遇到访问静态字段的指令时，初始化该静态字段所在的类;
5. 子类的初始化会触发父类的初始化;
6. 如果一个接口定义了 default 方法，那么直接实现或者间接实现该接口的类的初始化， 会触发该接口的初始化;
7. 使用反射 API 对某个类进行反射调用时，初始化这个类，其实跟前面一样，反射调用 要么是已经有实例了，要么是静态方法，都需要初始化;
8. 当初次调用 MethodHandle 实例时，初始化该 MethodHandle 指向的方法所在的 类。

### 不会初始化

1. 通过子类引用父类的静态字段，只会触发父类的初始化，而不会触发子类的初始化。
2. 定义对象数组，不会触发该类的初始化。
3. 常量在编译期间会存入调用类的常量池中，本质上并没有直接引用定义常量的类，不 会触发定义常量所在的类。
4. 通过类名获取 Class 对象，不会触发类的初始化，Hello.class 不会让 Hello 类初始 化。
5. 通过 Class.forName 加载指定类时，如果指定参数 initialize 为 false 时，也不会触 发类初始化，其实这个参数是告诉虚拟机，是否要对类进行初始化。Class.forName (“jvm.Hello”)默认会加载 Hello 类。
6. 通过 ClassLoader 默认的 loadClass 方法，也不会触发初始化动作(加载了，但是 不初始化)。
### JVM 命令行工具
1. jps/jinfo 查看 java 进程
  jps/jps -lmv
2. jstat 查看 JVM 内部 gc 相关信息   
   stat -gc 1763 1000 100 
   每隔1000 ms，1000次  
   stat -gcutil 1763 1000 1000（使用率）  
3. jmap 查看 heap 或类占用空间统计 
  jmap -histo 1763   
  jmap -heap 1763  
4. jstack 查看线程信息  
  jstack -l 1763  
5. jcmd 执行 JVM 相关分析命令(整合命令)  
  jcmd pid VM.version  
  jcmd pid VM.flags  
  jcmd pid VM.command_line  
  jcmd pid VM.system_properties   
  jcmd pid Thread.print  
  jcmd pid GC.class_histogram  
  jcmd pid GC.heap_info     
6. jrunscript/jjs 执行 js 命令  
  当curl命令用:   
  jrunscript -e "cat('http://www.baidu.com')" 执行js脚本片段  
  jrunscript -e "print('hello,kk.jvm'+1)" 执行js文件  
  jrunscript -l js -f /XXX/XXX/test.js  
7. JVM 图形化工具--jconsole  
   JVM 图形化工具--jvisualvm  
   JVM 图形化工具--jmc  
   
### JVM
Eden so s1 8:1:1  
由如下参数控制提升阈值 -XX:+MaxTenuringThreshold=15  
mark-and-sweep algorithm.  
   The algorithm traverses all object references, starting with the GC roots, and marks every object found as alive.    
   All of the heap memory that is not occupied by marked objects is reclaimed. It is simply marked as free, essentially swept free of unused objects.  
可以作为 GC Roots 的对象  
1. 当前正在执行的方法里的局部变量和输入参数  
2. 活动线程(Active threads)  
3. 所有类的静态字段(static field) 
4. JNI 引用

停止-复制(mark-copy)  
标记-清除(Mark-Sweep)  
标记-整理(Mark-Compact)  
分代收集算法(Generational Collection)  
效率：复制算法>标记/整理算法>标记/清除算法（此处的效率只是简单的对比时间复杂度，实际情况不一定如此  
内存整齐度：复制算法=标记/整理算法>标记/清除算法。  
内存利用率：标记/整理算法=标记/清除算法>复制算法。 

1. Parallel GC  
-XX:+UseParallelGC
2. Mostly Concurrent Mark and Sweep Garbage Collector  
-XX:+UseConcMarkSweepGC
3. G1 GC

### NIO
端口：进程  
ip：计算机  

## 阻塞式 IO

一般通过在 while(true) 循环中服务 端会调用 accept() 方法等待接收客户 端的连接的方式监听请求，请求一旦 接收到一个连接请求，就可以建立通 信套接字在这个通信套接字上进行读 写操作，此时不能再接收其他客户端 连接请求，只能等待同当前连接的客 户端的操作执行完成， 不过可以通过 多线程来支持多个客户端的连接


