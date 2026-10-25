import java.util.concurrent.atomic.AtomicInteger;

public class TaskCounter {

    private AtomicInteger completedTasks = new AtomicInteger(0);

    public void increment() {
        completedTasks.incrementAndGet();
    }

    public int getCompletedTasks() {
        return completedTasks.get();
    }

}
