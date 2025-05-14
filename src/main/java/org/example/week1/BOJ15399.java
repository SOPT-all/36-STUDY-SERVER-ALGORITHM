import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }

        Arrays.sort(P);

        int sum = 0;
        int prefix = 0;

        for (int i = 0; i < N; i++) {
            prefix += P[i];
            sum += prefix;
        }

        System.out.println(sum);
    }
}