
public class TaskWorker implements Runnable {

    private String taskName;

    public TaskWorker(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName + " is running on thread: "
                + Thread.currentThread().getName());
    }

}
