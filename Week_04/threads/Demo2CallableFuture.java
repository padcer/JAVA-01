package Week_04.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


public class Demo2CallableFuture {
    private static Integer result = 0;

    public static void main(String[] args) throws Exception{
        MyThread myThread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<>(myThread);
        new Thread(futureTask).start();
        System.out.println("Result: " + futureTask.get());
    }

    static class MyThread implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            try {
                Thread.sleep(1000);
                add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    private static Integer add() {
        return result++;
    }

}