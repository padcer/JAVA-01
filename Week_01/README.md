## 学习笔记

#### 堆内存设置参数 
* -Xmx, 指定最大堆内存。推荐配置为可用内存的0.6~0.8。 如 -Xmx4g. 这只是限制了 Heap 部分的最大值为4g。这个内存不包括栈内存，也不包括堆外使用的内存。默认是物理内存的1/4。默认空余的堆内存小于40%时，就会增大堆内存，直到达到-Xmx设置的内存。具体比例可以由 -XX:MinHeapFreeRatio 指定。动态增加内存失败时抛出 OutOfMemoryError 异常。
* -Xms, 指定初始堆内存=。 如 -Xms4g。 而且指定的内存大小，并不是操作系统实际分配的初始值，而是GC先规划好，用到才分配。 专用服务器上需要保持 –Xms 和 –Xmx 一致，否则应用刚启动可能就有好几个 FullGC。 当两者配置不一致时，堆内存扩容可能会导致性能抖动。默认是物理内存的1/64。空余的内存大于70%时，就会减少堆内存，直到达到-Xms设置的大小。具体比例由-XX:MaxHeapFreeRatio指定。
* -Xmn, Young区新生代内存大小，等价于 -XX:NewSize。对应老年代的内存大小：-Xmx减去-Xmn。当使用 G1 垃圾收集器不应该设置该选项，在其他的某些业务场景下可以设置。官方建议设置为 -Xmx 的 1/2 ~ 1/4.
* -Xss, 指定每个线程栈的大小，影响栈的深度。 例如 -Xss1m 指定线程栈为 1MB，与-XX:ThreadStackSize=1m 等价。在相同物理内存下，减小这个值能生成更多的线程。如果设置过小，可能会出现栈溢出，特别是在该线程内有递归、大的循环时出现溢出的可能性更大。
* -XX:MaxPermSize=size, 这是 JDK1.7 之前使用的。Java8 默认允许的 Meta空间无限大，此参数无效。
* -XX:MaxMetaspaceSize=size, Java8 默认不限制 Meta 空间, 一般不允许设置该选项。
* -XX:MaxDirectMemorySize=size，最大堆外内存，这个参数跟 -Dsun.nio.MaxDirectMemorySize 效果相同。

#### GC 设置参数
* -XX:+UseG1GC:使用 G1 垃圾回收器 
-XX:+UseConcMarkSweepGC:使用 CMS 垃圾回收器 
* -XX:+UseSerialGC:使用串行垃圾回收器 
* -XX:+UseParallelGC:使用并行垃圾回收器
