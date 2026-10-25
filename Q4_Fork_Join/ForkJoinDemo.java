
import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        SumTask task = new SumTask(1, 100);

        long result = pool.invoke(task);

        System.out.println("Sum of numbers from 1 to 100: " + result);

        pool.shutdown();
    }

}
