import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int caseNum = 1;

        while (true) {
            int L = sc.nextInt();
            int P = sc.nextInt();
            int V = sc.nextInt();

            if (L == 0 && P == 0 && V == 0) break;

            int result = (V / P) * L + Math.min(V % P, L);
            System.out.println("Case " + caseNum + ": " + result);
            caseNum++;
        }

        sc.close();
    }
}