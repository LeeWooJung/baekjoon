import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bottomUp {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int T, N;
        long[] dp = new long[101];

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // initialize dp
        dp[1] = dp[2] = dp[3] = 1;

        // get dp
        for(int n = 4; n <= 100 ; n++) {
            dp[n] = dp[n-2] + dp[n-3];
        }

        // 변수 입력 및 정답 출력
        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N] + "\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
