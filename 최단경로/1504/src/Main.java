import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Edge>> Graph;
    static int[] distance;
    static boolean[] visited;
    static final int INF = 200000000;
    public static void main(String[] args) throws Exception, IOException {
        
        int N, E;
        int a,b,c,u,v;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        Graph = new ArrayList<>();
        distance = new int[N+1];
        visited = new boolean[N+1];

        Arrays.fill(distance, INF);

        for(int n = 0; n <= N; n++) {
            Graph.add(new ArrayList<>());
        }

        for(int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            Graph.get(a).add(new Edge(b, c));
            Graph.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        int res1 = 0;
        int res2 = 0;

        res1 += dijkstra(1, u);
        res1 += dijkstra(u, v);
        res1 += dijkstra(v, N);

        res2 += dijkstra(1, v);
        res2 += dijkstra(v, u);
        res2 += dijkstra(u, N);

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

        System.out.println(ans);
    }

    static int dijkstra(int source, int dest) {

        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);

        distance[source] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(source, 0));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int curNode = current.destination;

            if(visited[curNode]) continue;
            visited[curNode] = true;

            for(Edge edge: Graph.get(curNode)) {
                if(visited[edge.destination]) continue;

                int dist = distance[curNode] + edge.cost;
                if(dist < distance[edge.destination]) {
                    distance[edge.destination] = dist;
                    pq.add(new Edge(edge.destination, distance[edge.destination]));
                }
            }
        }
        return distance[dest];
    }

}

class Edge implements Comparable<Edge>{
    int destination;
    int cost;

    Edge(int id, int cost) {
        this.destination = id;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge another) {
        return this.cost - another.cost;
    }
}