import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class topDown {

    static long[] dp;
    static long maximum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 변수 설정
        int n;
        
        // StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 변수 입력 및 정답 출력
        n = Integer.parseInt(br.readLine());
        dp = new long[n+1];

        for (int index = 1; index <= n; index++) {
            dp[index] = Integer.parseInt(st.nextToken());
        }

        maximum = dp[1];
        TopDown(n);
        System.out.println(maximum);
        
        br.close();
    }

    static long TopDown(int index) {
        if (index == 1) {
            return dp[index];
        }
        
        long current = dp[index];
        long previous = TopDown(index - 1);
        
        dp[index] = Math.max(current, current + previous);
        maximum = Math.max(maximum, dp[index]); // 최대값 갱신
        
        return dp[index];
    }
}
