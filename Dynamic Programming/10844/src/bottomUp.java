import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bottomUp {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N;
        long sum = 0;
        long[][] dp = new long[101][11];

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        N = Integer.parseInt(br.readLine());

        // Dynamic Programming
        // initialize
        for(int number = 1; number <= 9; number++) {
            dp[1][number] = 1;
        }

        for(int digit = 2; digit <= N; digit++) {
            dp[digit][0] = dp[digit-1][1] % 1000000000;
            for(int number = 1; number <= 9; number++) {
                dp[digit][number] = (dp[digit-1][number-1] + dp[digit-1][number+1]) % 1000000000;
            }
        }

        // result
        for(int number = 0; number <= 9; number++) {
            sum = (sum + dp[N][number]) % 1000000000;
        }

        System.out.println(sum);

        br.close();
    }
}
