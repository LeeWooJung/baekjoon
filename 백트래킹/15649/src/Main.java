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
        backtracking(N, M, new ArrayList<Integer>());

    }

    public static void backtracking(int N, int M, ArrayList<Integer> comb) {

        if(comb.size() == M) {
            StringBuilder sb = new StringBuilder();
            for(int val : comb) {
                sb.append(val + " ");
            }
            System.out.println(sb.toString());
            return;
        }

        for(int v = 1; v <= N; v++) {

            if(visited[v]) continue;
            
            comb.add(v);
            visited[v] = true;

            backtracking(N, M, comb);
            
            comb.remove(comb.size() - 1);
            visited[v] = false;
        }
    }
}
