package Week_04.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Demo11CyclicBarrier {

    private static Integer result = 0;
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                result++;
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }

        Thread.sleep(10);
        while (cyclicBarrier.getNumberWaiting() != 0) {
            Thread.sleep(10);
        }
        System.out.println("Result: " + result);
    }
}