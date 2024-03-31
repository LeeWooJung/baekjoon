import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N, K;
        long[] dp;
        int[] weight;
        int[] value;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weight = new int[N+1];
        value = new int[N+1];
        dp = new long[K+1];

        for(int t = 1; t <= N; t++) {
            st = new StringTokenizer(br.readLine());
            weight[t] = Integer.parseInt(st.nextToken()); // 무게
            value[t] = Integer.parseInt(st.nextToken()); // 가치
        }

        // Dynamic Programming
        for(int i = 1; i <= N; i++) { // i : stuff index
            for(int j = K; j >= 1; j--) { // j : weight
                if(weight[i] <= j) dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        System.out.println(dp[K]);
    }
}
