
public class MultithreadingDemo {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new TaskWorker("Task 1"), "Worker-1");
        Thread thread2 = new Thread(new TaskWorker("Task 2"), "Worker-2");
        Thread thread3 = new Thread(new TaskWorker("Task 3"), "Worker-3");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Thread names and priorities:");
        System.out.println(thread1.getName() + ": " + thread1.getPriority());
        System.out.println(thread2.getName() + ": " + thread2.getPriority());
        System.out.println(thread3.getName() + ": " + thread3.getPriority());

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();

            System.out.println("Worker-1 state: " + thread1.getState());
            System.out.println("Worker-2 state: " + thread2.getState());
            System.out.println("Worker-3 state: " + thread3.getState());

            System.out.println("All tasks have completed.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted.");
        }

    }

}
