## 线程操作实现方式
1：Runnable task = new Runnable() {
}


2: Callable + Feature

3: 线程类
public class ChildTask implements Runnable {
}

4: 匿名类
Runnable task = () -> {
}

5: FutureTask

6、ReentrantLock

7、ReadWriteLock

8、Atomic

9、Semaphore

10、CountdownLatch

11、CyclicBarrier

12、ThreadLocal


#### Other tips
* sleep()

* join() 线程

* synchronized 变量

* synchronized 线程对象

* wait/notify   notifyAll

* yeild

