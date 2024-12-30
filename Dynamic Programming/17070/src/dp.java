import java.io.*;
import java.util.*;

public class dp {

    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N][N];
        // dp : 파이프 우측이 해당 위치에 존재하는 경우의 수수
        int[][][] dp = new int[N][N][3]; // [][][0]: 가로, [][][1]: 세로, [][][2]: 대각선


        for(int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < N; col++) {
                house[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][0] = 1; // initialization

        /*
         * pipe의 우측 끝은 column index 1부터 시작.
         * 따라서, y의 값은 2부터 시작하여 이전 pipe의 우측을 확인해야 함.
         */
        for(int x = 0; x < N; x++) {
            for(int y = 2; y < N; y++) {

                if(house[x][y] != 1 && y - 1 >= 0) dp[x][y][0] = dp[x][y-1][0] + dp[x][y-1][2]; // 가로 + 대각선에서 가로로 변경
                if(house[x][y] != 1 && x - 1 >= 0) dp[x][y][1] = dp[x-1][y][1] + dp[x-1][y][2]; // 세로 + 대각선에서 세로로 변경
                if(x-1 >= 0 && y-1 >= 0 && house[x][y] != 1 && house[x-1][y] != 1 && house[x][y-1] != 1) {
                    dp[x][y][2] = dp[x-1][y-1][0] + dp[x-1][y-1][1] + dp[x-1][y-1][2]; // 가로 + 세로 + 대각선에서 대각선으로 변경
                }
            }
        }

        System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);

    }
}
