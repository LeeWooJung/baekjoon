import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    public static void main(String[] args) throws Exception, IOException {
        
        int N, M;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        backtracking(N, M, 0, new ArrayList<Integer>());
    }

    public static void backtracking(int N, int M, int lastElem, ArrayList<Integer> comb) {

        // M size
        if(comb.size() == M) {
            StringBuilder sb = new StringBuilder();
            for(int val: comb) {
                sb.append(val + " ");
            }
            System.out.println(sb.toString());
            return;
        }

        // else
        for(int v = 1; v <= N; v++) {
            if(visited[v]) continue;
            if(v <= lastElem) continue;

            visited[v] = true;
            comb.add(v);
            backtracking(N, M, v, comb);
            comb.remove(comb.size()-1);
            visited[v] = false;
        }
    }
}
