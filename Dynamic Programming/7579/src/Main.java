import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N, M;
        int[] memory;
        int[] cost;
        int[] dp;
        int sumMemory = 0, sumCost = 0;
        int minimum = Integer.MAX_VALUE;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StrinTokenizer
        StringTokenizer st;

        // 변수 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        memory = new int[N];
        cost = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < N; t++) {
            memory[t] = Integer.parseInt(st.nextToken());
            sumMemory += memory[t];
        }
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < N; t++) {
            cost[t] = Integer.parseInt(st.nextToken());
            sumCost += cost[t];
        }

        /*
         * Dynamic Programming
         * dp[c] : c만큼의 비용이 들 때 비울 수 있는 최대 메모리 byte
         */
        dp = new int[sumCost + 1];
        dp[sumCost] = sumMemory;
        
        for(int app = 0; app < N; app++) {
            for(int c = sumCost; c >= 0; c--) {
                if(c - cost[app] >= 0) dp[c] = Math.max(dp[c], dp[c-cost[app]] + memory[app]);
            }
        }

        for(int c = 0; c <= sumCost; c++) {
            if(dp[c] >= M) { // M 이상의 메모리를 비울 수 있는 최소 cost 출력
                minimum = c;
                break;
            }
        }

        System.out.println(minimum);
        br.close();
    }
}
