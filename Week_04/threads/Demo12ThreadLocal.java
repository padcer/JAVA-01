package Week_04.threads;

public class Demo12ThreadLocal {

    private static Integer param = 0;
    static ThreadLocal<Integer> result = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        result.set(0);
        Runnable task = () -> {
            try {
                Thread.sleep(1000);
                param++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(task).start();

        while (result.get() == 0) {
            Thread.sleep(10);
            result.set(param);
        }
        System.out.println("Result: " + result.get());
    }
}