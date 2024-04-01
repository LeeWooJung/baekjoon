import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int T, K;
        int[] files;
        int[] cumumlatedSum;
        int[][] dp;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // 변수 입력
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            K = Integer.parseInt(br.readLine());

            files = new int[K+1];
            cumumlatedSum = new int[K+1];
            dp = new int[K+1][K+1]; // dp[i][j] : i번째 file부터 j번째 file까지 합칠 때 최소 비용 저장

            st = new StringTokenizer(br.readLine());
            for(int number = 1; number <= K; number++) {
                files[number] = Integer.parseInt(st.nextToken());

                // 누적 합 구하기
                cumumlatedSum[number] = cumumlatedSum[number-1] + files[number];
            }

            /*
             * Dynamic Programming
             * [K-1][K]
             * [K-2][K-1] [K-2][K]
             * [K-3][K-2] [K-3][K-1] [K-3][K]
             * ...
             * [1][2] [1][3] [1][4] ... [1][K] 순으로 구함.
             * 
             * ex) [1][K] 를 구하기 위해서 [1][5] + [6][K]의 값이 필요.
             *     이 때 [6][K]를 미리 구해놓지 않으면 위 값을 구할 수 없음.
             * 따라서 가장 마지막 file 부터 역순으로 구해야 함.
             */
            for(int start = K-1; start >= 1; start--) {
                for(int end = start+1; end <= K; end++) {

                    dp[start][end] = Integer.MAX_VALUE;
                    /*
                     * dp[start][end] 구하기.
                     * dp[start][end]
                     * = [start] ~ [mid] + [mid+1] ~ [end] 중에서 가장 작은 값
                     *   + start file 부터 end file 까지의 합
                     */
                    for(int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end],
                                                  dp[start][mid] + dp[mid+1][end]);
                    }
                    dp[start][end] += (cumumlatedSum[end] - cumumlatedSum[start-1]);
                }
            }

            // 첫 번째 파일부터 마지막 파일까지의 최소 합 출력
            sb.append(dp[1][K] + "\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
