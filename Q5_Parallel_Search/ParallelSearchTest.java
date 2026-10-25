
import java.util.concurrent.ForkJoinPool;

public class ParallelSearchTest {

    public static void main(String[] args) {

        int[] numbers = {
            12, 45, 7, 89, 23, 56, 34, 91, 18, 62,
            73, 5, 41, 28, 67, 99, 14, 38, 81, 50
        };

        ForkJoinPool pool = new ForkJoinPool();

        try {
            // Test 1: Search for an existing value.
            int target1 = 67;

            int result1 = pool.invoke(
                    new ParallelSearchTask(
                            numbers, target1, 0, numbers.length));

            boolean test1Passed =
                    result1 != -1 && numbers[result1] == target1;

            System.out.println(
                    "Search for 67 passed: " + test1Passed);

            // Test 2: Search for a missing value.
            int target2 = 100;

            int result2 = pool.invoke(
                    new ParallelSearchTask(
                            numbers, target2, 0, numbers.length));

            boolean test2Passed = result2 == -1;

            System.out.println(
                    "Search for 100 passed: " + test2Passed);

            // Test 3: Search for the first array element.
            int target3 = 12;

            int result3 = pool.invoke(
                    new ParallelSearchTask(
                            numbers, target3, 0, numbers.length));

            boolean test3Passed = result3 == 0;

            System.out.println(
                    "Search for first element passed: " + test3Passed);

            // Display the overall result.
            boolean allPassed =
                    test1Passed && test2Passed && test3Passed;

            System.out.println("All tests passed: " + allPassed);

        } finally {
            pool.shutdown();
        }
    }
}
