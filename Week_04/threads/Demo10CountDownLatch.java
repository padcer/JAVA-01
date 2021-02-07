package Week_04.threads;

import java.util.concurrent.CountDownLatch;

public class Demo10CountDownLatch {

    private static Integer result = 0;
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                Thread.sleep(1000);
                result++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        };
        new Thread(task).start();

        countDownLatch.await();
        System.out.println("Result: " + result);
    }
}