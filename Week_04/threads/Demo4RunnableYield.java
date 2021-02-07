package Week_04.threads;

public class Demo4RunnableYield {
    private static Integer result = 0;
    private static byte[] lock = new byte[1];

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        new Thread(thread).start();

        Thread.sleep(1000);
        System.out.println("Result: " + result);
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            add();
            Thread.yield();
        }
    }

    public static void add() {
        result++;
    }

}