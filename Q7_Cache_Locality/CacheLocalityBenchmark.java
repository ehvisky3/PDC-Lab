
public class CacheLocalityBenchmark {

    private static final int SIZE = 2000;
    private static final int REPETITIONS = 10;

    private static final double[][] matrix =
        new double[SIZE][SIZE];

    private static volatile double resultSink;

    public static void main(String[] args) {

        initializeMatrix();

        // Warm up the JVM before measuring.
        for (int i = 0; i < 2; i++) {
            traverseRowMajor();
            traverseColumnMajor();
        }

        long rowTotal = 0;
        long columnTotal = 0;

        for (int i = 0; i < REPETITIONS; i++) {

            long start = System.nanoTime();
            resultSink = traverseRowMajor();
            rowTotal += System.nanoTime() - start;

            start = System.nanoTime();
            resultSink = traverseColumnMajor();
            columnTotal += System.nanoTime() - start;
        }

        double rowAverageMs =
            rowTotal / (double) REPETITIONS / 1_000_000.0;

        double columnAverageMs =
            columnTotal / (double) REPETITIONS / 1_000_000.0;

        System.out.println("=== Cache Locality Benchmark ===");
        System.out.println("Matrix size: " + SIZE + " x " + SIZE);
        System.out.println("Measured repetitions: " + REPETITIONS);

        System.out.printf(
            "Row-major average time: %.3f ms%n",
            rowAverageMs
        );

        System.out.printf(
            "Column-major average time: %.3f ms%n",
            columnAverageMs
        );

        if (rowAverageMs > 0) {
            System.out.printf(
                "Row-major speedup ratio (column time / row time): %.2fx%n",
                columnAverageMs / rowAverageMs
            );
        }

        System.out.printf(
            "Verification sum: %.2f%n",
            resultSink
        );

        System.out.println("\nExplanation:");
        System.out.println(
            "Row-major traversal accesses adjacent elements in each row."
        );
        System.out.println(
            "This generally improves spatial locality and cache-line use."
        );
        System.out.println(
            "Column-major traversal jumps between rows, which can increase cache misses."
        );
        System.out.println(
            "Actual timings depend on the JVM, processor, and system load."
        );
    }

    private static void initializeMatrix() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = i + j * 0.5;
            }
        }
    }

    public static double traverseRowMajor() {
        double sum = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

    public static double traverseColumnMajor() {
        double sum = 0;

        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }
}

