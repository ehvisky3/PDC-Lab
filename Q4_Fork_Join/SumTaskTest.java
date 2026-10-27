
import java.util.concurrent.ForkJoinPool;

public class SumTaskTest {

    private static int passed = 0;
    private static int failed = 0;

    private static void checkSum(
            ForkJoinPool pool,
            int start,
            int end,
            long expected) {

        long actual = pool.invoke(new SumTask(start, end));

        if (actual == expected) {
            System.out.println("PASS: Sum from " + start + " to "
                    + end + " = " + actual);
            passed++;
        } else {
            System.out.println("FAIL: Sum from " + start + " to "
                    + end + ", expected " + expected
                    + " but got " + actual);
            failed++;
        }
    }

    private static void checkInvalidRange() {

        try {
            new SumTask(10, 1);
            System.out.println("FAIL: Invalid range was accepted");
            failed++;

        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Invalid range rejected");
            passed++;
        }
    }

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        try {
            checkSum(pool, 1, 10, 55);
            checkSum(pool, 1, 100, 5050);
            checkSum(pool, 5, 15, 110);
            checkSum(pool, 7, 7, 7);
            checkSum(pool, 1, 11, 66);
            checkSum(pool, -3, 3, 0);
            checkSum(pool, -100, 100, 0);
            checkSum(pool, -5, -1, -15);
            checkSum(pool, 1, 1_000_000, 500000500000L);

            // Test a range starting at zero.
            checkSum(pool, 0, 10, 55);

            checkInvalidRange();

            System.out.println("\nTests passed: " + passed);
            System.out.println("Tests failed: " + failed);

        } finally {
            pool.shutdown();
        }
    }
}
//ehtisham