package Week_04.threads;

import java.util.concurrent.Semaphore;

public class Demo9Semaphore {

    private static Integer result = 0;
    static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                semaphore.acquire();
                Thread.sleep(1000);
                result++;
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(task).start();

        Thread.sleep(10);
        while (!semaphore.tryAcquire()) {
            Thread.sleep(10);
        }
        System.out.println("Result: " + result);
    }
}