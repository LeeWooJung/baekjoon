import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class topDown2 {
    static int N;
    static int[][] cost;
    static int[] dp;
    static int INF;

    public static void main(String[] args) throws IOException {

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력 및 초기화
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        dp = new int[1 << N];
        Arrays.fill(dp, -1); // -1 : 처리되지 않은 것을 뜻 함. Memoization
        INF = Integer.MAX_VALUE / 2;

        // 비용 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solve((1 << N) - 1);
        System.out.println(result);

        br.close();
    }

    static int solve(int workCombination) {
        // 이미 계산된 경우 메모이제이션된 값을 반환
        if (dp[workCombination] != -1) {
            return dp[workCombination];
        }

        // 모든 일을 처리한 경우
        if (workCombination == 0) {
            return 0;
        }

        // 현재 일을 수행하는 사람의 인덱스
        int person = countBit(workCombination);

        int minCost = INF;
        for (int work = 0; work < N; work++) {
            if ((workCombination & (1 << work)) != 0) { // 해당 일을 수행하는 경우
                int nextWorkCombination = workCombination & ~(1 << work); // 해당 일을 제외한 다음 상태
                int nextCost = solve(nextWorkCombination) + cost[person][work];
                minCost = Math.min(minCost, nextCost);
            }
        }

        dp[workCombination] = minCost; // 계산된 값을 메모이제이션
        return minCost;
    }

    // Brian Kernighan Algorithm (O(logN))
    static int countBit(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count - 1; // 인덱스는 0부터 시작하므로 1을 뺌
    }
}
