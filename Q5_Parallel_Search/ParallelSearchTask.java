import java.util.concurrent.RecursiveTask;

public class ParallelSearchTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 10;

    private int[] array;
    private int target;
    private int start;
    private int end;

    public ParallelSearchTask(
            int[] array, int target, int start, int end) {

        if (array == null) {
            throw new IllegalArgumentException(
                    "Array must not be null.");
        }

        if (start < 0 || end > array.length || start > end) {
            throw new IllegalArgumentException(
                    "Invalid search range.");
        }

        this.array = array;
        this.target = target;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        // Search directly when the range is small.
        if (end - start <= THRESHOLD) {

            for (int i = start; i < end; i++) {

                if (array[i] == target) {
                    return i;
                }
            }

            return -1;
        }

        // Divide the search range into two parts.
        int middle = (start + end) / 2;

        ParallelSearchTask leftTask =
                new ParallelSearchTask(
                        array, target, start, middle);

        ParallelSearchTask rightTask =
                new ParallelSearchTask(
                        array, target, middle, end);

        // Execute the left task asynchronously.
        leftTask.fork();

        // Compute the right task and wait for the left task.
        int rightResult = rightTask.compute();
        int leftResult = leftTask.join();

        // Prefer a match in the left half.
        if (leftResult != -1) {
            return leftResult;
        }

        return rightResult;
    }
}