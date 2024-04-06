import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class bottomUp {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int n;
        long maximum = 0;
        long[][] dp = new long[500][500];

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        n = Integer.parseInt(br.readLine());

        for(int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < row + 1 && col < n; col++) {
                dp[row][col] = Integer.parseInt(st.nextToken());

                if(row == 0) {
                    maximum = dp[row][col];
                    continue;
                }

                // getBefore
                int bCol = col - 1;
                long beforeSum = bCol >= 0 ? dp[row-1][bCol] + dp[row][col]: 0;

                // get Maximum
                dp[row][col] = Math.max(beforeSum, dp[row-1][col] + dp[row][col]);
                maximum = Math.max(maximum, dp[row][col]);
            }
        }
        System.out.println(maximum);
        br.close();
    }
}
