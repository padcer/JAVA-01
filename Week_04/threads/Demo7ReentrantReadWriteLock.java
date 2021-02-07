package Week_04.threads;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo7ReentrantReadWriteLock {
    private static Integer result = 0;
    final static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                lock.writeLock().lock();
                Thread.sleep(1000);
                add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        };
        new Thread(task).start();

        Thread.sleep(10);
        while (lock.isWriteLocked()) {
            Thread.sleep(10);
        }
        System.out.println("Result: " + result);
    }

    private static void add() {
        result++;
    }

}