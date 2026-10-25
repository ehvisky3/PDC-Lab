
import java.util.concurrent.RecursiveTask;

public class ParallelSearchTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 10;

    private int[] array;
    private int target;
    private int start;
    private int end;

    public ParallelSearchTask(
            int[] array, int target, int start, int end) {

        this.array = array;
        this.target = target;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if (end - start <= THRESHOLD) {
            for (int i = start; i < end; i++) {
                if (array[i] == target) {
                    return i;
                }
            }

            return -1;
        }

        int middle = (start + end) / 2;

        ParallelSearchTask leftTask =
                new ParallelSearchTask(array, target, start, middle);

        ParallelSearchTask rightTask =
                new ParallelSearchTask(array, target, middle, end);

        leftTask.fork();

        int rightResult = rightTask.compute();
        int leftResult = leftTask.join();

        if (leftResult != -1) {
            return leftResult;
        }

        return rightResult;
    }
}
