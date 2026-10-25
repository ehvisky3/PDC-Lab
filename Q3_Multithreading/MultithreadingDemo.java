
public class MultithreadingDemo {

    public static void main(String[] args) {

        TaskCounter counter = new TaskCounter();

        Thread thread1 = new Thread(
                new TaskWorker("Task 1", counter), "Worker-1");
        Thread thread2 = new Thread(
                new TaskWorker("Task 2", counter), "Worker-2");
        Thread thread3 = new Thread(
                new TaskWorker("Task 3", counter), "Worker-3");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();

            System.out.println("Completed tasks: "
                    + counter.getCompletedTasks());
            System.out.println("All tasks have completed.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted.");
        }

    }

}
