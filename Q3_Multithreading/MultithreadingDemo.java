
public class MultithreadingDemo {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new TaskWorker("Task 1"));
        Thread thread2 = new Thread(new TaskWorker("Task 2"));
        Thread thread3 = new Thread(new TaskWorker("Task 3"));

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Starting worker threads...");
        System.out.println("Task 1 priority: " + thread1.getPriority());
        System.out.println("Task 2 priority: " + thread2.getPriority());
        System.out.println("Task 3 priority: " + thread3.getPriority());

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();

            System.out.println("All tasks have completed.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted.");
        }

    }

}
