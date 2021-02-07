package Week_04.threads;

import java.util.concurrent.locks.ReentrantLock;

public class Demo6ReentrantLock {
    private static Integer result = 0;
    final static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                lock.lock();
                Thread.sleep(1000);
                add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };
        new Thread(task).start();

        Thread.sleep(10);
        while (lock.isLocked()) {
            Thread.sleep(10);
        }
        System.out.println("Result: " + result);
    }

    private static void add() {
        result++;
    }
}