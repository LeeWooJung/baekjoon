import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class bottomUp {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N;
        int nComb;
        int[][] cost;
        int[][] dp;

        boolean didWork = false;
        final int INF = Integer.MAX_VALUE/2;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        nComb = 1 << N;
        cost = new int[N][N];
        dp = new int[N][1 << N];
        for(int[] row : dp) Arrays.fill(row, INF);

        // initialization
        for(int person = 0; person < N; person++) {
            st = new StringTokenizer(br.readLine());
            for(int work = 0; work < N; work++) {
                cost[person][work] = Integer.parseInt(st.nextToken());
                if(person == 0) dp[person][1 << work] = cost[person][work];
            }
        }

        // Dynamic Programming
        for(int person = 1; person < N; person++) {
            for(int workCombination = 0; workCombination < nComb; workCombination++) {

                /*
                 * 이전 사람이 해당 조합의 일을 하지 못하는 경우
                 * (이전 사람이 했던 일로 조합하여도 해당 workCombination이 나올 수 없는 경우)
                 */
                if(dp[person-1][workCombination] == INF) continue;
                for(int work = 0; work < N; work++) {
                    /*
                     * workCombination에 work가 존재할 경우: didWork = true
                     */
                    didWork = (workCombination & (1 << work)) != 0 ? true : false;
                    if(didWork) continue;
                    int addedWorkCombination = workCombination | (1 << work);
                    dp[person][addedWorkCombination] = Math.min(dp[person][addedWorkCombination], dp[person-1][workCombination] + cost[person][work]);
                }

            }
        }

        System.out.println(dp[N-1][(1 << N) -1]);

        br.close();
    }
}