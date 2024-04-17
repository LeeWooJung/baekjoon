import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class topDown {
    static int N;
    static int[][] cost;
    static int[][] dp;
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력 및 initialization
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        dp = new int[N][1 << N];
        for (int[] row : dp) Arrays.fill(row, -1); // -1로 초기화하여 미계산 상태를 나타냄

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solve(0, 0);
        System.out.println(result);

        br.close();
    }

    static int solve(int person, int workCombination) {
        if (person == N) {
            if (workCombination == (1 << N) - 1) return 0; // 모든 사람이 일을 마쳤을 때
            else return INF; // 일을 마치지 못한 경우
        }

        if (dp[person][workCombination] != -1) return dp[person][workCombination]; // 이미 계산한 경우 메모이제이션된 값을 반환

        int minCost = INF;
        for (int work = 0; work < N; work++) {
            if ((workCombination & (1 << work)) == 0) { // 아직 해당 일을 수행하지 않은 경우
                int addedWorkCombination = workCombination | (1 << work);
                int nextCost = solve(person + 1, addedWorkCombination) + cost[person][work];
                minCost = Math.min(minCost, nextCost);
            }
        }

        dp[person][workCombination] = minCost; // 계산한 값을 메모이제이션
        return minCost;
    }
}
