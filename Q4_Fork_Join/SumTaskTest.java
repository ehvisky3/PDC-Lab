import java.util.concurrent.ForkJoinPool;

public class SumTaskTest {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        try {
            long result1 = pool.invoke(new SumTask(1, 10));
            long result2 = pool.invoke(new SumTask(1, 100));
            long result3 = pool.invoke(new SumTask(5, 15));
            long result4 = pool.invoke(new SumTask(7, 7));
            long result5 = pool.invoke(new SumTask(1, 11));
            long result6 = pool.invoke(new SumTask(-3, 3));
            long result7 = pool.invoke(new SumTask(-100, 100));

            System.out.println("Sum from 1 to 10: " + result1);
            System.out.println("Sum from 1 to 100: " + result2);
            System.out.println("Sum from 5 to 15: " + result3);
            System.out.println("Sum from 7 to 7: " + result4);
            System.out.println("Sum from 1 to 11: " + result5);
            System.out.println("Sum from -3 to 3: " + result6);
            System.out.println("Sum from -100 to 100: " + result7);

            boolean validTestsPassed = result1 == 55
                    && result2 == 5050
                    && result3 == 110
                    && result4 == 7
                    && result5 == 66
                    && result6 == 0
                    && result7 == 0;

            System.out.println(
                    "Valid range tests passed: " + validTestsPassed);

            boolean invalidTestPassed = false;

            try {
                new SumTask(10, 1);
            } catch (IllegalArgumentException e) {
                invalidTestPassed = true;
            }

            System.out.println(
                    "Invalid range test passed: " + invalidTestPassed);

        } finally {
            pool.shutdown();
        }

    }

}
