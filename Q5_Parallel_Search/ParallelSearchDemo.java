
import java.util.concurrent.ForkJoinPool;

public class ParallelSearchDemo {

    public static void main(String[] args) {

        int[] numbers = {
            12, 45, 7, 89, 23, 56, 34, 91, 18, 62,
            73, 5, 41, 28, 67, 99, 14, 38, 81, 50
        };

        int target = 67;

        ForkJoinPool pool = new ForkJoinPool();

        try {
            ParallelSearchTask task =
                    new ParallelSearchTask(
                            numbers, target, 0, numbers.length);

            int result = pool.invoke(task);

            if (result != -1) {
                System.out.println("Target found: " + target);
                System.out.println("Array index: " + result);
            } else {
                System.out.println("Target not found: " + target);
            }

        } finally {
            pool.shutdown();
        }
    }
}
