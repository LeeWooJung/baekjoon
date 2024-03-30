import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N;
        long[][] dp = new long[3][1001];

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력 및 정답 출력
        N = Integer.parseInt(br.readLine());
        for(int house = 1; house <= N; house++) {
            st = new StringTokenizer(br.readLine());

            dp[0][house] = Integer.parseInt(st.nextToken());
            dp[1][house] = Integer.parseInt(st.nextToken());
            dp[2][house] = Integer.parseInt(st.nextToken());

            if(house == 1) continue;

            dp[0][house] = Math.min(dp[1][house-1], dp[2][house-1]) + dp[0][house];
            dp[1][house] = Math.min(dp[0][house-1], dp[2][house-1]) + dp[1][house];
            dp[2][house] = Math.min(dp[0][house-1], dp[1][house-1]) + dp[2][house];
        }

        long minimum = Math.min(Math.min(dp[0][N], dp[1][N]), dp[2][N]);

        System.out.println(minimum);
        br.close();
    }
}
