
public class TaskWorker implements Runnable {

    private String taskName;

    public TaskWorker(String taskName) {
        this.taskName = taskName;
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

    }

}
