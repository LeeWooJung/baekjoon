import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bottomUp {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int n;
        int[] dp;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1]; // fibonacci value memoization

        // 문제 해결
        dp[1] = dp[2] = 1;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n] + " " + (n-2));

        br.close();
    }

}
