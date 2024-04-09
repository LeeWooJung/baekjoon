import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bottomUp {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int n;
        int[] wine;
        long[] dp;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        n = Integer.parseInt(br.readLine());
        wine = new int[n+1];
        dp = new long[n+1];

        for(int step = 1; step <= n; step++) {
            wine[step] = Integer.parseInt(br.readLine());
        }

        // Dynamic Programming
        for(int step = 1; step <= n; step++) {
            if(step >= 3) {
                dp[step] = Math.max(Math.max(wine[step] + dp[step-2], dp[step-1]), wine[step] + wine[step-1] + dp[step-3]);
            } else {
                dp[step] = dp[step-1] + wine[step];
            }
        }

        System.out.println(dp[n]);
    }
}
