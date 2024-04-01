import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N;
        Matrix[] matrix;
        int[][] dp;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        matrix = new Matrix[N+1];
        dp = new int[N+1][N+1];

        
        for(int idx = 1; idx <= N; idx++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            matrix[idx] = new Matrix(row, col);
        }

        for(int start = N-1; start >= 1; start--) {
            for(int end = start + 1; end <= N; end++) {

                dp[start][end] = Integer.MAX_VALUE;
                for(int mid = start; mid < end; mid++) {
                    /*
                     * dp[start][end] : start 부터 end matrix 곱 연산의 최솟값
                     * dp[start][mid] + dp[mid+1][end]
                     * : (start ~ mid) * (mid + 1 ~ end) 의 곱 연산을 의미
                     * 해당 곱 연산은 start.row * mid.col * end.col과 같음
                     * (start ~ mid) : [start.row, mid.col]
                     * (mid + 1 ~ end) : [mid.col, end.col] 이기 때문
                     */
                    dp[start][end] = Math.min(dp[start][end],
                                              dp[start][mid] + dp[mid+1][end]
                                              + matrix[start].row * matrix[mid].col * matrix[end].col);
                }
            }
        }

        System.out.println(dp[1][N]);
        br.close();
    }
}

class Matrix {
    int row;
    int col;

    Matrix(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
