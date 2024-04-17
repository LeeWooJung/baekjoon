import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class bottomUp2 {
    public static void main(String[] args) throws IOException {
        
        // 변수 설정
        int N;
        int nComb;
        int[][] cost;
        int[] dp;
        int INF = Integer.MAX_VALUE / 2;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        

        // initialization
        nComb = 1 << N;
        cost = new int[N][N];
        dp = new int[nComb];
        Arrays.fill(dp, INF);
        dp[0] = 0; // 아무일도 하지 않은 상태
        

        for(int person = 0; person < N; person++) {
            st = new StringTokenizer(br.readLine());
            for(int work = 0; work < N; work++) {
                cost[person][work] = Integer.parseInt(st.nextToken());
            }
        }

        // Dynamic Programming
        for(int workCombination = 0; workCombination < nComb - 1; workCombination++) {
            int person = countBit(workCombination);
            for(int work = 0; work < N; work++) {
                if((workCombination & (1 << work)) == 0) { // 현재 일이 포함되지 않았을 경우
                    int addedWorkCombination = workCombination | (1 << work);
                    dp[addedWorkCombination] = Math.min(dp[addedWorkCombination], dp[workCombination] + cost[person][work]);
                }
            }
        }

        System.out.println(dp[nComb - 1]);
        br.close();
    }

    // Brian Kernighan Algorithm (O(logN))
    static int countBit(int n) {
        int count = 0;
        while(n > 0) {
            n &= (n-1);
            count++;
        }
        return count;
    }
}
