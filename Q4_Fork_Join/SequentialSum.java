
public class SequentialSum {

    public static long calculateSum(int start, int end) {

        long sum = 0;

        for (int i = start; i <= end; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {

        long result = calculateSum(1, 100);

        System.out.println("Sequential sum of numbers from 1 to 100: "
                + result);
    }

}
