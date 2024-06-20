import java.io.*;
import java.util.*;

public class Main {

    static Edge[] edges;
    static int[] parent;
    public static void main(String[] args) throws Exception, IOException {
        
        int V, E;
        int src, dest, cost;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        edges = new Edge[E];

        for(int node = 1; node <= V; node++) {
            parent[node] = -1;
        }

        for(int t = 0; t < E; t++) {
            st = new StringTokenizer(br.readLine());
            
            src = Integer.parseInt(st.nextToken());
            dest = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            edges[t] = new Edge(src, dest, cost);
        }

        Arrays.sort(edges, (edge1, edge2) -> {
            return edge1.cost - edge2.cost;
        });

        int result = 0;
        int numEdge = 0;

        for(Edge e: edges) {
            if(union(e.src, e.dest)) {
                result += e.cost;
                numEdge++;
            }
            if(numEdge == V-1) break;
        }

        System.out.println(result);
    }

    static int find(int node) {
        if(parent[node] < 0) return node;
        parent[node] = find(parent[node]);
        return parent[node];
    }

    static boolean union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if(xParent == yParent) return false;

        int xRank = Math.abs(parent[xParent]);
        int yRank = Math.abs(parent[yParent]);

        if(xRank > yRank) {
            parent[yParent] = xParent;
        } else if(yRank > xRank) {
            parent[xParent] = yParent;
        } else {
            boolean xLarge = xParent > yParent ? true : false;
            if(xLarge) {
                parent[yParent] = xParent;
                parent[xParent]--;
            } else {
                parent[xParent] = yParent;
                parent[yParent]--;
            }
        }

        return true;
    }
}

class Edge {
    int src;
    int dest;
    int cost;

    Edge(int src, int dest, int cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }
}
