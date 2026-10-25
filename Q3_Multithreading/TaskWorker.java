
public class TaskWorker implements Runnable {

    private String taskName;
    private TaskCounter counter;

    public TaskWorker(String taskName, TaskCounter counter) {
        this.taskName = taskName;
        this.counter = counter;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName
                    + " - iteration " + i
                    + " - thread: "
                    + Thread.currentThread().getName());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(taskName + " was interrupted.");
                return;
            }
        }

        counter.increment();
        System.out.println(taskName + " completed.");

    }

}
