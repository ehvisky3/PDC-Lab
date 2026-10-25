import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 10;

    private int start;
    private int end;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        if (end - start <= THRESHOLD) {
            long sum = 0;

            for (int i = start; i <= end; i++) {
                sum += i;
            }

            return sum;
        }

        int middle = (start + end) / 2;

        SumTask leftTask = new SumTask(start, middle);
        SumTask rightTask = new SumTask(middle + 1, end);

        leftTask.fork();

        long rightResult = rightTask.compute();
        long leftResult = leftTask.join();

        return leftResult + rightResult;
    }

}
