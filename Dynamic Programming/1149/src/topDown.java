import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class topDown {
    static int N;
    static long[][] cost;
    static long[][] dp;

    public static void main(String[] args) throws IOException {

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 변수 입력
        N = Integer.parseInt(br.readLine());
        cost = new long[3][N + 1];
        dp = new long[3][N + 1];
        
        // StringTokenizer
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[0][i] = Integer.parseInt(st.nextToken());
            cost[1][i] = Integer.parseInt(st.nextToken());
            cost[2][i] = Integer.parseInt(st.nextToken());
        }

        // 문제 해결
        long minimum = Math.min(Math.min(TopDown(0, N), TopDown(1, N)), TopDown(2, N));
        System.out.println(minimum);
        
        br.close();
    }

    static long TopDown(int color, int house) {
        // 기저 사례: house가 1인 경우
        if (house == 1) {
            return cost[color][1];
        }
        
        // Memoization
        if (dp[color][house] != 0) {
            return dp[color][house];
        }
        
        // Dynamic Programming & Memoization
        if (color == 0) {
            dp[color][house] = Math.min(TopDown(1, house - 1), TopDown(2, house - 1)) + cost[color][house];
        } else if (color == 1) {
            dp[color][house] = Math.min(TopDown(0, house - 1), TopDown(2, house - 1)) + cost[color][house];
        } else {
            dp[color][house] = Math.min(TopDown(0, house - 1), TopDown(1, house - 1)) + cost[color][house];
        }
        
        return dp[color][house];
    }
}
