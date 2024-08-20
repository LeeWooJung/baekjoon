import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

    static int answer = 0;
    static int N;
    static int[] colQueen;
    public static void main(String[] args) throws Exception, IOException {

        /*
         *   1 2 3 4 5
         * 1   x
         * 2       x
         * 3 x
         * 4     x
         * 5          x
         */

        /*
         * 1. 첫 째줄에 Queen1을 추가. 0 ~ N-1
         * 2. 둘 째줄에 공격할 수 있는 위치가 아닌지 확인 후 Queen2를 추가
         * 3. 셋 째줄에 공격할 수 있는 위치가 아닌지 확인 후 Queen3을 추가.
         * ...
         * N. N 째줄에 공격할 수 있는 위치가 아닌지 확인 후 QueenN을 추가.
         * 
         * 모두 추가할 수 있으면 + 1
         * 
         * row를 증가시키면서, Queen을 Col별로 추가시켰을 때 이전 Queen을 공격할 수 없으면 추가.
         * - 같은 row에는 어차피 추가할 수 없으므로 for loop 으로 row를 증가시키면서 확인.
         * - row의 값은 for 문에서만 해결하고, col 값 만으로도 해결할 수 있으므로 col 값만으로 확인.
         */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        colQueen = new int[N+1];

        backtracking(0);

        System.out.println(answer);
    }

    static void backtracking(int row) {

        if(row == N) {
            answer++;
            return;
        }

        for(int col = 0; col < N; col++) {

            if(canAttack(row, col)) continue;

            colQueen[row] = col;
            backtracking(row + 1);
        }
    }

    static boolean canAttack(int row, int col) {

        if(row == 0) return false;

        for(int step = 1; step <= row; step++) {

            int prevCol = colQueen[row-step];

            if(prevCol == col || prevCol == col - step || prevCol == col + step) return true;
        }

        return false;
    }
}

