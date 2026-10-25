import java.util.concurrent.ForkJoinPool;

public class SumTaskTest {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        try {
            long result1 = pool.invoke(new SumTask(1, 10));
            long result2 = pool.invoke(new SumTask(1, 100));
            long result3 = pool.invoke(new SumTask(5, 15));

            System.out.println("Sum from 1 to 10: " + result1);
            System.out.println("Sum from 1 to 100: " + result2);
            System.out.println("Sum from 5 to 15: " + result3);

            boolean passed = result1 == 55
                    && result2 == 5050
                    && result3 == 110;

            System.out.println("Valid range tests passed: " + passed);

            try {
                new SumTask(10, 1);
                System.out.println("Invalid range test passed: false");
                passed = false;

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid range test passed: true");
            }

        } finally {
            pool.shutdown();
        }

    }

}
