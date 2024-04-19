import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TopDown {

    static int N;
    static int[][] W;
    static int[][] dp;
    final static int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solve(0, 1);
        System.out.println(result);

        br.close();
    }

    static int solve(int current, int visited) {
        // 모든 도시를 방문한 경우, 마지막 도시에서 시작 도시로 돌아가는 비용을 반환
        if (visited == (1 << N) - 1) {
            return W[current][0] != 0 ? W[current][0] : INF;
        }

        // 이미 계산된 경우 메모이제이션된 값을 반환
        if (dp[current][visited] != -1) {
            return dp[current][visited];
        }

        int minCost = INF;
        for (int next = 0; next < N; next++) {
            if ((visited & (1 << next)) == 0 && W[current][next] != 0) { // 다음 도시를 방문하지 않은 경우
                int cost = W[current][next] + solve(next, visited | (1 << next)); // 다음 도시로 이동하여 재귀 호출
                minCost = Math.min(minCost, cost);
            }
        }

        // 계산된 값을 메모이제이션
        dp[current][visited] = minCost;
        return minCost;
    }
}
