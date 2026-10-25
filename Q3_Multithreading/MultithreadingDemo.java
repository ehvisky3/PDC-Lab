
public class MultithreadingDemo {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new TaskWorker("Task 1"));
        Thread thread2 = new Thread(new TaskWorker("Task 2"));
        Thread thread3 = new Thread(new TaskWorker("Task 3"));

        thread1.start();
        thread2.start();
        thread3.start();

    }

}
