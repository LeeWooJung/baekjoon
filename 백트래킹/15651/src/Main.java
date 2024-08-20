import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    static int N, M;
    static ArrayList<Integer> comb;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        comb = new ArrayList<>();

        backtracking();

        /*
         * Comb의 size가 M 일 때마다 출력을 요구하면, I/O 떄문에 시간 초과 발생.
         * 따라서, StringBuilder를 전역 변수로 선언하고, 모든 결과를 저장 한 후
         * 마지막에 한 번만 출력하여 해결.
         */
        System.out.print(sb.toString());
    }

    public static void backtracking() {

        if(comb.size() == M) {
            for(int val : comb) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for(int v = 1; v <= N; v++) {

            comb.add(v);
            backtracking();
            comb.remove(comb.size()-1);
        }
    }
}
