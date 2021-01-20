# GC 总结

### 不同GC的实验过程
###### 串行GC
```bash
~/Java/JAVA-01/Week_02 (main)$ java -XX:+UseSerialGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
......
执行结束!共生成对象次数:10067
Heap
 def new generation   total 157248K, used 9310K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)
  eden space 139776K,   6% used [0x00000007a0000000, 0x00000007a0917838, 0x00000007a8880000)
  from space 17472K,   0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)
  to   space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)
 tenured generation   total 349568K, used 349329K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)
   the space 349568K,  99% used [0x00000007aaaa0000, 0x00000007bffc4440, 0x00000007bffc4600, 0x00000007c0000000)
 Metaspace       used 2702K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
```

###### 并行GC
```bash
~/Java/JAVA-01/Week_02 (main)$ java -XX:+UseParallelGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
......
执行结束!共生成对象次数:8911
Heap
 PSYoungGen      total 116736K, used 2479K [0x00000007b5580000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 58880K, 4% used [0x00000007b5580000,0x00000007b57ebfa0,0x00000007b8f00000)
  from space 57856K, 0% used [0x00000007b8f00000,0x00000007b8f00000,0x00000007bc780000)
  to   space 57856K, 0% used [0x00000007bc780000,0x00000007bc780000,0x00000007c0000000)
 ParOldGen       total 349696K, used 339218K [0x00000007a0000000, 0x00000007b5580000, 0x00000007b5580000)
  object space 349696K, 97% used [0x00000007a0000000,0x00000007b4b44a28,0x00000007b5580000)
 Metaspace       used 2702K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
```

###### CMS GC
```bash
~/Java/JAVA-01/Week_02 (main)$ java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
......
执行结束!共生成对象次数:11140
Heap
 par new generation   total 157248K, used 9551K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)
  eden space 139776K,   6% used [0x00000007a0000000, 0x00000007a0953d30, 0x00000007a8880000)
  from space 17472K,   0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)
  to   space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)
 concurrent mark-sweep generation total 349568K, used 348957K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 2702K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
```

###### G1 GC
```bash
~/Java/JAVA-01/Week_02 (main)$ java -XX:+UseG1GC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
......
执行结束!共生成对象次数:10735
Heap
 garbage-first heap   total 524288K, used 393329K [0x00000007a0000000, 0x00000007a0101000, 0x00000007c0000000)
  region size 1024K, 5 young (5120K), 4 survivors (4096K)
 Metaspace       used 2702K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
```

##### -Xmx -Xms参数影响
###### 256m
| \    | Young GC | Full GC | 生成次数 |
| ---- | -------- | ------- | ------- |
| 串行 |     13.5ms     |    27ms     |     4670    |
| 并行 |     7ms     |     15ms    |     OOM    |
| CMS  |     12ms     |    26ms     |     4754    |
| G1   |     1ms    |    2ms     |     OOM    |
###### 512m
| \    | Young GC | Full GC | 生成次数 |
| ---- | -------- | ------- | ------- |
| 串行 |     21ms     |     32ms    |     9639    |
| 并行 |     64ms     |     30ms    |     14020    |
| CMS  |     24ms     |    47ms     |     10812    |
| G1   |    1.3ms      |    37ms     |     10415    |
###### 1G
| \    | Young GC | Full GC | 生成次数 |
| ---- | -------- | ------- | ------- |
| 串行 |    15ms      |    51ms     |     12168    |
| 并行 |    60ms      |    40ms    |     13961    |
| CMS  |    39ms      |    58ms     |     15011    |
| G1   |    6.6ms      |    33ms     |     14209    |
###### 4G
| \    | Young GC | Full GC | 生成次数 |
| ---- | -------- | ------- | ------- |
| 串行 |     145ms     |     -    |     10684    |
| 并行 |     80ms     |      -   |     13145    |
| CMS  |    70ms      |     -    |     15417    |
| G1   |    40ms      |    -     |     13897    |
###### 8G
| \    | Young GC | Full GC | 生成次数 |
| ---- | -------- | ------- | ------- |
| 串行 |     -     |     -    |     7827    |
| 并行 |     85ms     |    -     |     7903    |
| CMS  |    81ms      |     -    |     12670    |
| G1   |    34ms      |    -     |     15420    |


### 实验结论
##### Young GC 与 Full GC
* 当新生代Eden区满时触发 Young GC。Young GC之后，Eden区占用量下降，Old gen使用量会上升。
* 当老年代Old gen剩余空间不足时，触发 Full GC，收集整个堆内存。 
* 一般情况下，Full GC之后，年轻代和老年代的占用量都会下降，Young Gen因出现高分配速率场景导致快速占满时，会导致频繁的Full GC。
* Full GC之后，Old Gen空间仍然不足，则会发生OOM异常。
* G1算法还会存在 mixed GC，新生代加部分老年代的GC。

##### 不同GC的特点和使用场景
* Serial GC：单线程执行，应用需要暂停，适合单CPU下的Client模式。
* Parallel GC：多线程并行地执行垃圾回收。适合高吞吐量场景，CPU资源最大程度处理业务请求。
* CMS GC：多线程分阶段并发标记和清除，每次GC时间尽量短，适合多核、低延迟场景。
* G1 GC：通过划分多个内存区域做增量整理和回收，进一步降低延迟。合大内存、服务器端场景，整体GC时间可控。
