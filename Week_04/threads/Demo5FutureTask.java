package Week_04.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo5FutureTask {
    private static Integer result = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return ++result;
            }
        });
        new Thread(task).start();

        Thread.sleep(1000);
        System.out.println("Result: " + task.get());
    }

}