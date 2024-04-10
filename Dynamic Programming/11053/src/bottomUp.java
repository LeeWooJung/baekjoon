import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class bottomUp {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N;
        int maximum = 0;
        int[] array;
        int[] dp;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        array = new int[N+1];
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int idx = 1; idx <= N; idx++) {
            array[idx] = Integer.parseInt(st.nextToken());
            dp[idx] = 1;
        }

        // dynamic programming
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j < i; j++) {
                if(array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maximum = Math.max(maximum, dp[i]);
        }
        System.out.println(maximum);

        br.close();
    }
}
