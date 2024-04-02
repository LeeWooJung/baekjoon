import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class forloop {

    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int n, k;
        int[] dp;
        int[] values;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        values = new int[n];
        dp = new int[k+1];

        for(int idx = 0; idx < n; idx++) {
            values[idx] = Integer.parseInt(br.readLine());
        }

        /*
         * Dynamic programming
         * 
         * dp[c] : c이하의 값어치의 동전으로 만들 수 있는 경우의 수
         */
        dp[0] = 1;

        for(int idx = 0; idx < n; idx++) {
            int value = 0;
            while(++value <= k) {
                int prev = value - values[idx];
                dp[value] += prev >= 0 ? dp[prev] : 0;
            }
        }

        System.out.println(dp[k]);
        br.close();
    }
}
