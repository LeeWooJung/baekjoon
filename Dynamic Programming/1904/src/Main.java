import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N;
        int[] dp;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 변수 입력
        N = Integer.parseInt(br.readLine());
        dp = new int[1000001];

        // initialize dp
        dp[1] = 1;
        dp[2] = 2;

        for(int n = 3; n <= N; n++) {
            dp[n] = (dp[n-1] + dp[n-2]) % 15746;
        }

        System.out.println(dp[N]);

        br.close();
    }
}
