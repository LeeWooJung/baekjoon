import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception, IOException {
        
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backtracking(N, M, 0, new ArrayList<>());

        System.out.print(sb.toString());
    }

    public static void backtracking(int N, int M, int lastElem, ArrayList<Integer> comb) {

        if(comb.size() == M) {
            
            for(int val: comb) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for(int v = 1; v <= N; v++) {

            if(v < lastElem) continue;
            comb.add(v);
            backtracking(N, M, v, comb);
            comb.remove(comb.size() - 1);

        }
    }
}
