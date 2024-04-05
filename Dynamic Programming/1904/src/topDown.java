import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class topDown {

    static final int MOD = 15746;
    static int[] dp;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 변수 입력
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        // initialize dp(memoization)
        for(int index = 0; index <= N; index++) {
            dp[index] = -1; 
        }

        System.out.println(TopDown(N));

        br.close();
    }

    static int TopDown(int n) {
        // 기저 조건: n이 1 또는 2인 경우
        if (n == 1) return 1;
        if (n == 2) return 2;

        // 이미 계산한 값이라면 그 값을 반환
        if (dp[n] != -1) return dp[n];

        // 아직 계산하지 않은 값이라면 재귀적으로 계산하여 반환
        dp[n] = (TopDown(n - 1) + TopDown(n - 2)) % MOD;
        return dp[n];
    }
}
