import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class topDown {
    static long[][] dp = new long[101][11];

    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sum = 0;

        // initialization
        for (int number = 0; number <= 9; number++) {
            dp[1][number] = 1;
        }

        for (int number = 1; number <= 9; number++) {
            sum = (sum + recursive(N, number)) % 1000000000;
        }

        System.out.println(sum);
        br.close();
    }

    // 재귀 함수를 통해 top-down 방식으로 DP를 구현
    static long recursive(int digit, int lastNumber) {
        if (digit == 1) {
            return dp[digit][lastNumber];
        }

        if (dp[digit][lastNumber] == 0) {
            if (lastNumber == 0) {
                dp[digit][lastNumber] = recursive(digit - 1, 1);
            } else if (lastNumber == 9) {
                dp[digit][lastNumber] = recursive(digit - 1, 8);
            } else {
                dp[digit][lastNumber] = (recursive(digit - 1, lastNumber - 1) + recursive(digit - 1, lastNumber + 1)) % 1000000000;
            }
        }
        return dp[digit][lastNumber];
    }
}
