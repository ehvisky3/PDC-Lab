import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo {

    private static final int START = 1;
    private static final int END = 1_000_000;
    private static final int TRIALS = 5;

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        long sequentialTotalTime = 0;
        long parallelTotalTime = 0;

        long sequentialResult = 0;
        long parallelResult = 0;

        for (int i = 1; i <= TRIALS; i++) {

            long sequentialStart = System.nanoTime();
            sequentialResult = SequentialSum.calculateSum(START, END);
            long sequentialEnd = System.nanoTime();

            long parallelStart = System.nanoTime();
            parallelResult = pool.invoke(
                    new SumTask(START, END));
            long parallelEnd = System.nanoTime();

            sequentialTotalTime += sequentialEnd - sequentialStart;
            parallelTotalTime += parallelEnd - parallelStart;
        }

        pool.shutdown();

        System.out.println("Sequential sum: " + sequentialResult);
        System.out.println("Fork/Join sum: " + parallelResult);

        System.out.println("Number of trials: " + TRIALS);

        System.out.println("Average sequential time: "
                + (sequentialTotalTime / TRIALS) / 1_000_000.0
                + " ms");

        System.out.println("Average Fork/Join time: "
                + (parallelTotalTime / TRIALS) / 1_000_000.0
                + " ms");

    }

}
