import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int n, m;
        int src, dest, cost;
        final int INF = 1000000000;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n+1][n+1];
        for(int[] row: dist) {
            Arrays.fill(row, INF);
        }
        for(int node = 1; node <= n; node++) dist[node][node] = 0;

        for(int e = 0; e < m; e++) {
            st = new StringTokenizer(br.readLine());

            src = Integer.parseInt(st.nextToken());
            dest = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            dist[src][dest] = Math.min(dist[src][dest], cost);
        }

        for(int mid = 1; mid <= n; mid++) {
            for(int from = 1; from <= n; from++) {
                for(int to = 1; to <= n; to++) {
                    dist[from][to] = Math.min(dist[from][to], dist[from][mid] + dist[mid][to]);
                }
            }
        }

        for(int from = 1; from <= n; from++) {
            for(int to = 1; to <= n; to++) {
                if(dist[from][to] >= INF) sb.append(0).append(" ");
                else sb.append(dist[from][to]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
