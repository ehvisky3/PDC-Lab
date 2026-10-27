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
            int result1 = pool.invoke(
                    new ParallelSearchTask(
                            numbers, 67, 0, numbers.length));

            boolean test1Passed =
                    result1 != -1 && numbers[result1] == 67;

            System.out.println(
                    "Search for 67 passed: " + test1Passed);

            // Test 2: Search for a missing value.
            int result2 = pool.invoke(
                    new ParallelSearchTask(
                            numbers, 100, 0, numbers.length));

            boolean test2Passed = result2 == -1;

            System.out.println(
                    "Search for 100 passed: " + test2Passed);

            // Test 3: Search for the first element.
            int result3 = pool.invoke(
                    new ParallelSearchTask(
                            numbers, 12, 0, numbers.length));

            boolean test3Passed = result3 == 0;

            System.out.println(
                    "Search for first element passed: "
                            + test3Passed);

            // Test 4: Search an empty range.
            int result4 = pool.invoke(
                    new ParallelSearchTask(numbers, 12, 0, 0));

            boolean test4Passed = result4 == -1;

            System.out.println(
                    "Empty range test passed: " + test4Passed);

            // Test 5: Reject a null array.
            boolean test5Passed = false;

            try {
                new ParallelSearchTask(null, 10, 0, 0);
            } catch (IllegalArgumentException e) {
                test5Passed = true;
            }

            System.out.println(
                    "Null array validation passed: " + test5Passed);

            // Test 6: Reject an invalid range.
            boolean test6Passed = false;

            try {
                new ParallelSearchTask(
                        numbers, 10, 0, numbers.length + 1);
            } catch (IllegalArgumentException e) {
                test6Passed = true;
            }

            System.out.println(
                    "Invalid range validation passed: " + test6Passed);

            boolean allPassed =
                    test1Passed && test2Passed && test3Passed
                    && test4Passed && test5Passed && test6Passed;

            System.out.println("All tests passed: " + allPassed);

        } finally {
            pool.shutdown();
        }
    }
}