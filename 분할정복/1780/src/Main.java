import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {

    static int numMinusOne = 0;
    static int numOne = 0;
    static int numZero = 0;
    public static void main(String[] args) throws Exception, IOException {
        
        int N;
        int[][] paper;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        divide(paper, 0, 0, N);

        System.out.println(numMinusOne);
        System.out.println(numZero);
        System.out.println(numOne);

    }

    static void divide(int[][] paper, int row, int col, int length) {

        if(check(paper, row, col, length)) {
            if(paper[row][col] == 1) {
                numOne++;
            } else if(paper[row][col] == 0) {
                numZero++;
            } else {
                numMinusOne++;
            }

            return;
        }

        int divLen = length / 3;

        for(int m1 = 0; m1 < 3; m1++) {
            for(int m2 = 0; m2 < 3; m2++) {
                divide(paper, row + divLen * m1, col + divLen * m2, divLen);
            }
        }
    }

    static boolean check(int[][] paper, int row, int col, int length) {

        int val = paper[row][col];

        for(int r = row; r < row + length; r++) {
            for(int c = col; c < col + length; c++) {
                if(val != paper[r][c]) return false;
            }
        }

        return true;
    }
}
