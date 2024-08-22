import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] S;
    static boolean[] selected;

    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        selected = new boolean[N];

        for(int row = 0; row < N; row++) {

            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < N; col++) {
                S[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        backtraking(0, 0);
        System.out.println(MIN);

    }

    static void backtraking(int count, int lastElem) {

        if(count == N/2) {

            int sumA = getSum(true);
            int sumB = getSum(false);
            int diff = (int)Math.abs(sumA - sumB);

            MIN = MIN < diff ? MIN : diff;

            return;
        }

        for(int index = 0; index < N; index++) {
            if(selected[index]) continue;
            if(index <= lastElem) continue;

            selected[index] = true;

            backtraking(count + 1, index);

            selected[index] = false;
        }

    }

    static int getSum(boolean bool) {
        int sum = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(selected[i] == bool && selected[j] == bool) {
                    sum += S[i][j] + S[j][i];
                }
            }
        }
        return sum;
    }
}
