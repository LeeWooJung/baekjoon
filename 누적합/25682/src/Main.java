import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N, M, K;
        int result = 0;
        int black = 1;
        int[][] board;
        int[][] cuSum;
        int MIN = Integer.MAX_VALUE;
        int MAX = Integer.MIN_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N+1][M+1];
        cuSum = new int[N+1][M+1];

         /*
          * 완전탐색
          * - O(N*M*K*K)
          * 누적합 사용
          * Row: N [K ~ N]
          * Column: M [K ~ M] ==> O((N-K) * (M-K)) = O(N*M) = 2000*2000
          */

        for(int row = 1; row <= N; row++) {
            String colors = br.readLine();
            for(int col = 1; col <= M; col++) {

                /*
                 * black: odd --> Black
                 * black: even --> White
                 * 
                 * board[row][col] = 1 --> must be colored
                 */

                if(colors.charAt(col-1) == 'B' && black % 2 == 0) {
                    board[row][col] = 1;
                } else if(colors.charAt(col-1) == 'W' && black % 2 == 1) {
                    board[row][col] = 1;
                }

                black = (black + 1) % 2;

                cuSum[row][col] = board[row][col] + cuSum[row-1][col] + cuSum[row][col-1] - cuSum[row-1][col-1];
            }
            if(M % 2 == 0) black++;
        }

        // find min, max cusum
        for(int row = K; row <= N; row++) {
            for(int col = K; col <= M; col++) {

                int val = cuSum[row][col] - cuSum[row][col-K] - cuSum[row-K][col] + cuSum[row-K][col-K];
                MIN = MIN < val ? MIN : val;
                MAX = MAX > val ? MAX : val;
            }
        }

        /*
         * MIN: 시작 칸이 Black이라면 칠해야 하는 최소 횟수.
         * MAX: 시작 칸이 Black이라면 칠해야 하는 최대 횟수.
         * ==> K*K - MAX : 시작 칸이 White라면 칠해야 하는 최소 횟수.
         */

        result = MIN < K*K - MAX ? MIN : K*K - MAX;

        System.out.println(result);

    }
}
