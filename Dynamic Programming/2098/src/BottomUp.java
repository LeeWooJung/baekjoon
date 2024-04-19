import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class BottomUp {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N;
        int[][] W;
        int[][] dp;

        final int INF = Integer.MAX_VALUE / 2;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        /*
         * dp[x][pathCombination]
         * 0번 도시부터 x번 도시까지 pathCombination으로 이동하는 비용의 최솟값
         */
        dp = new int[N][1 << N];

        // initialization
        int nPath = 1 << N;
        for(int[] weight : dp) Arrays.fill(weight, INF);

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
                // 0 -> j 로 바로 갈 수 있는 비용 저장
                if(i == 0 && W[i][j] != 0) dp[j][1 << j] = W[i][j];
            }
        }

        /*
         * Dynamic Programming
         * 0번 도시 부터 출발 했을 때 순회 최소 비용 구하기
         * 0 --> x -> y 를 통해서 0 --> y 비용의 최솟값을 구함
         */
        for(int pathCombination = 1; pathCombination < nPath; pathCombination++) {
            for(int x = 0; x < N; x++) {
                // 0번 도시부터 출발하여 순회하는 길에 x 가 없으면 pass
                if((pathCombination & (1 << x)) == 0) continue;
                for(int y = 0; y < N; y++) {
                    // 0번 도시부터 출발하여 순회하는 길에 y가 없으면 pass
                    if((pathCombination & (1 << y)) == 0) continue;
                    // x번 도시에서 y번 도시로 바로 가는 길이 없으면 pass
                    if(W[x][y] == 0) continue;

                    dp[y][pathCombination] = Math.min(dp[y][pathCombination], dp[x][pathCombination & ~(1 << y)] + W[x][y]);
                }
            }
        }

        System.out.println(dp[0][(1 << N) - 1]);

        br.close();
    }
}
