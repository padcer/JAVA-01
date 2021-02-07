package Week_04.threads;

public class Demo3RunnableWait {
    private static Integer result = 0;
    private static byte[] lock = new byte[1];

    public static void main(String[] args) throws Exception{
        MyThread thread = new MyThread();
        new Thread(thread).start();
        synchronized (lock) {
            lock.wait();
        }

        System.out.println("Result: " + result);
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                synchronized (lock) {
                    add();
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void add() {
        result++;
    }

}