
public class ConcurrencyBenchmark {

    private static final int TASK_COUNT = 4;
    private static final int WORK_PER_TASK = 5_000_000;
    private static final int TRIALS = 5;

    private static long performWork(int iterations) {
        long result = 0;

        for (int i = 0; i < iterations; i++) {
            result += i % 100;
        }

        return result;
    }

    private static long runSequentially() {
        long total = 0;

        for (int i = 0; i < TASK_COUNT; i++) {
            total += performWork(WORK_PER_TASK);
        }

        return total;
    }

    private static long runConcurrently()
            throws InterruptedException {

        Thread[] threads = new Thread[TASK_COUNT];
        long[] results = new long[TASK_COUNT];

        for (int i = 0; i < TASK_COUNT; i++) {
            final int index = i;

            threads[i] = new Thread(() ->
                    results[index] = performWork(WORK_PER_TASK));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long total = 0;

        for (long result : results) {
            total += result;
        }

        return total;
    }

    public static void main(String[] args)
            throws InterruptedException {

        double sequentialTotalMs = 0;
        double concurrentTotalMs = 0;

        long expectedResult = runSequentially();

        System.out.println("Expected result: " + expectedResult);
        System.out.println("Benchmark trials: " + TRIALS);
        System.out.println();

        for (int trial = 1; trial <= TRIALS; trial++) {

            long startSequential = System.nanoTime();
            long sequentialResult = runSequentially();
            long endSequential = System.nanoTime();

            long startConcurrent = System.nanoTime();
            long concurrentResult = runConcurrently();
            long endConcurrent = System.nanoTime();

            double sequentialMs =
                    (endSequential - startSequential) / 1_000_000.0;

            double concurrentMs =
                    (endConcurrent - startConcurrent) / 1_000_000.0;

            sequentialTotalMs += sequentialMs;
            concurrentTotalMs += concurrentMs;

            boolean correct =
                    sequentialResult == expectedResult
                    && concurrentResult == expectedResult;

            System.out.printf(
                    "Trial %d: Sequential = %.2f ms, "
                    + "Concurrent = %.2f ms, Correct = %s%n",
                    trial, sequentialMs, concurrentMs, correct);
        }

        double averageSequential =
                sequentialTotalMs / TRIALS;

        double averageConcurrent =
                concurrentTotalMs / TRIALS;

        System.out.println("\n--- Average Results ---");

        System.out.printf(
                "Average sequential time: %.2f ms%n",
                averageSequential);

        System.out.printf(
                "Average concurrent time: %.2f ms%n",
                averageConcurrent);

        if (averageConcurrent < averageSequential) {
            System.out.println("Concurrent execution was faster on average.");
        } else {
            System.out.println(
                    "Sequential execution was faster or tied on average.");
        }
    }
}
