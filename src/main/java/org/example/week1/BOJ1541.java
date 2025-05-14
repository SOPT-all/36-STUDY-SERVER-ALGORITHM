import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();

        String[] minusSplit = expression.split("-");

        int result = 0;

        result += sumOfGroup(minusSplit[0]);

        for (int i = 1; i < minusSplit.length; i++) {
            result -= sumOfGroup(minusSplit[i]);
        }

        System.out.println(result);
    }

    private static int sumOfGroup(String group) {
        String[] nums = group.split("\\+");
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}