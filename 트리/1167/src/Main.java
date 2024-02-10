import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.List;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static node[] Graph;
    static int max = 0;
    static int farDistanceNode;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int V;
        int sNode, eNode;
        int distance;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // V 입력
        V = Integer.parseInt(br.readLine());
        Graph = new node[V+1];
        for(int num = 1; num <= V; num++) {
            Graph[num] = new node(num);
        }

        for(int t = 0; t < V; t++) {
            st = new StringTokenizer(br.readLine());
            sNode = Integer.parseInt(st.nextToken());
            while(true) {
                eNode = Integer.parseInt(st.nextToken());
                if(eNode == -1) break;
                distance = Integer.parseInt(st.nextToken());
                Graph[sNode].adjacent.add(new edge(eNode, distance));
            }
        }

        dfs(Graph[1], 0);

        // visited 초기화
        for(int num = 1; num <= V; num++) {
            Graph[num].visited = false;
        }
        dfs(Graph[farDistanceNode], 0);
        System.out.println(max);
    }

    static void dfs(node current, int totalDistance) {
        if(current.visited) return;

        if(totalDistance > max) {
            max = totalDistance;
            farDistanceNode = current.value;
        }

        current.visited = true;
        for(edge connected : current.adjacent) {
            int child = connected.toNode;
            if(Graph[child].visited) continue;
            dfs(Graph[child], connected.distance + totalDistance);
        }
    }

    static class node {
        int value;
        boolean visited;
        List<edge> adjacent;

        node (int value) {
            this.value = value;
            this.visited = false;
            this.adjacent = new LinkedList<>();
        }
    }

    static class edge {
        int toNode;
        int distance;

        edge(int toNode, int distance) {
            this.toNode = toNode;
            this.distance = distance;
        }
    }
}
