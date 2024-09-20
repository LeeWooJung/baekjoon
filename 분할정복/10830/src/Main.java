import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N;
        long B;
        int[][] A;
        int[][] result;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        A = new int[N][N];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                A[r][c] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        result = divide(A, B, N);

        StringBuilder sb = new StringBuilder();

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                sb.append(result[r][c]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());

    }

    static int[][] divide(int[][] A, long exp, int size) {

        if(exp == 1) {
            return A;
        }

        int[][] res = divide(A, exp / 2, size);
        res = multiply(res, res, size);
        if(exp % 2 == 1) res = multiply(res, A, size);

        return res;
    }


    static int[][] multiply(int[][] first, int[][] second, int size) {

        int[][] result = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                for(int k = 0; k < size; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                    result[i][j] %= 1000;
                }
            }
        }

        return result;
    }
}
