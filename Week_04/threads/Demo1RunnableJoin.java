package Week_04.threads;


public class Demo1RunnableJoin {
    private static Integer result = 0;

    public static void main(String[] args) throws InterruptedException{
        Runnable task = () -> {
            try {
                Thread.sleep(1000);
                add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.join();
        System.out.println("Result: " + result);
    }

    private static void add() {
        result++;
    }
}
