package Week_04.threads;

import java.util.concurrent.atomic.LongAdder;

public class Demo8LongAdder {

    private static Long result = 0L;
    final static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                Thread.sleep(1000);
                longAdder.increment();
                result = longAdder.longValue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(task).start();

        while (longAdder.longValue() == 0) {
            Thread.sleep(10);
        }
        System.out.println("Result: " + result);
    }
}