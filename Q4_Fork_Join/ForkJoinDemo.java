import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo {

    public static void main(String[] args) {

        int start = 1;
        int end = 1_000_000;

        long sequentialStart = System.nanoTime();
        long sequentialResult = SequentialSum.calculateSum(start, end);
        long sequentialEnd = System.nanoTime();

        ForkJoinPool pool = new ForkJoinPool();

        long parallelStart = System.nanoTime();
        long parallelResult = pool.invoke(new SumTask(start, end));
        long parallelEnd = System.nanoTime();

        pool.shutdown();

        System.out.println("Sequential sum: " + sequentialResult);
        System.out.println("Fork/Join sum: " + parallelResult);

        System.out.println("Sequential time: "
                + (sequentialEnd - sequentialStart) / 1_000_000.0
                + " ms");

        System.out.println("Fork/Join time: "
                + (parallelEnd - parallelStart) / 1_000_000.0
                + " ms");

    }

}
