import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {

        int N, M, K;
        int[][] A;
        int[][] B;
        int[][] C;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[128][128];
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        B = new int[128][128];

        for(int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < K; c++) {
                B[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int minPadSize = Math.max(Math.max(N, M), K);
        int s = 1;

        while(true) {
            if(s >= minPadSize) {
                break;
            }
            s *= 2;
        }

        C = multiply(A, B, s);

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < K; c++) {
                sb.append(C[r][c] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());

    }

    /*
     * 스트라센 방법
     *
     * M1 = (a11 + a22) * (b11 + b22)
     * M2 = (a21 + a22) * b11
     * M3 = a11 * (b12 - b22)
     * M4 = a22* (b21 - b11)
     * M5 = (a11 + a12) * b22
     * M6 = (a21 - a11) * (b11 + b12)
     * M7 = (a12 - a22) * (b21 + b22)
     * 
     * c11 = M1 + M4 - M5 + M7
     * c12 = M3 + M5
     * c21 = M2 + M4
     * c22 = M1 - M2 + M3 + M6
    */

    static int[][] multiply(int[][] first, int[][] second, int size) {

        int[][] result = new int[size][size];

        if(size <= 128) {
            return result = matrixMultiply(first, second, size);
        }

        size /= 2;

        int[][] a11 = divide(first, 0, 0, size);
        int[][] a12 = divide(first, 0, size, size);
        int[][] a21 = divide(first, size, 0, size);
        int[][] a22 = divide(first, size, size, size);

        int[][] b11 = divide(second, 0, 0, size);
        int[][] b12 = divide(second, 0, size, size);
        int[][] b21 = divide(second, size, 0, size);
        int[][] b22 = divide(second, size, size, size);

        int[][] M1 = multiply(add(a11, a22, size), add(b11, b22, size), size);
        int[][] M2 = multiply(add(a21, a22, size), b11, size);
        int[][] M3 = multiply(a11, sub(b12, b22, size), size);
        int[][] M4 = multiply(a22, sub(b21, b11, size), size);
        int[][] M5 = multiply(add(a11, a12, size), b22, size);
        int[][] M6 = multiply(sub(a21, a11, size), add(b11, b12, size), size);
        int[][] M7 = multiply(sub(a12, a22, size), add(b21, b22, size), size);

        int[][] c11 = sub(add(add(M1, M4, size), M7, size), M5, size);
        int[][] c12 = add(M3, M5, size);
        int[][] c21 = add(M2, M4, size);
        int[][] c22 = sub(add(add(M1, M3, size), M6, size), M2, size);

        conquer(c11, result, 0, 0, size);
        conquer(c12, result, 0, size, size);
        conquer(c21, result, size, 0, size);
        conquer(c22, result, size, size, size);

        return result;
    }

    static int[][] matrixMultiply(int[][] first, int[][] second, int size) {

        int[][] result = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                for(int k = 0; k < size; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }

        return result;

    }

    static void conquer(int[][] toConquer, int[][] result, int row, int col, int size) {

        for(int resR = row, tcR = 0; row < size; resR++, tcR++) {
            for(int resC = col, tcC = 0; resC < size; resC++, tcC++) {
                result[resR][resC] = toConquer[tcR][tcC];
            }
        }

    }

    static int[][] divide(int[][] toDivide, int row, int col, int size) {

        int[][] result;
        result = new int[size][size];

        for(int r = 0, tD_r = row; r < size; r++, tD_r++) {
            for(int c = 0, tD_c = col; c < size; c++, tD_c++) {
                result[r][c] = toDivide[tD_r][tD_c];
            }
        }

        return result;
    }

    static int[][] add(int[][] first, int[][] second, int size) {

        int[][] result = new int[size][size];

        for(int r = 0; r < size; r++) {
            for(int c = 0; c < size; c++) {
                result[r][c] = first[r][c] + second[r][c];
            }
        }

        return result;
    }

    static int[][] sub(int[][] first, int[][] second, int size) {

        int[][] result = new int[size][size];

        for(int r = 0; r < size; r++) {
            for(int c = 0; c < size; c++) {
                result[r][c] = first[r][c] - second[r][c];
            }
        }

        return result;
    }
}
