import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static node[] Graph;
    static int max = 0;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int n;
        int parent, child, weight;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // n 입력
        n = Integer.parseInt(br.readLine());
        // Graph 초기화
        Graph = new node[n+1];
        for(int num = 1; num <= n; num++) {
            Graph[num] = new node(num);
        }
        // 간선 정보 입력
        for(int t = 0; t < n-1; t++) {
            st = new StringTokenizer(br.readLine());

            parent = Integer.parseInt(st.nextToken());
            child = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            Graph[parent].adjacent.add(new edge(child, weight));
            Graph[child].adjacent.add(new edge(parent, weight));
        }
        // 임의의 노드에서 가장 먼 노드 찾기
        int farNode = BFS(1);
        // node 초기화
        for(int num = 1; num <= n; num++) {
            Graph[num].visited = false;
            Graph[num].totalWeight = 0;
        }
        BFS(farNode);

        System.out.println(max);
    }

    static int BFS(int start) {

        int farNode = start;

        Queue<node> queue = new LinkedList<>();

        Graph[start].visited = true;
        queue.offer(Graph[start]);

        while(!queue.isEmpty()) {
            node current = queue.poll();
            for(edge child: current.adjacent) {
                if(Graph[child.toNode].visited) continue;

                Graph[child.toNode].visited = true;
                queue.offer(Graph[child.toNode]);
                Graph[child.toNode].totalWeight = current.totalWeight + child.weight;
                if(Graph[child.toNode].totalWeight > max) {
                    max = Graph[child.toNode].totalWeight;
                    farNode = child.toNode;
                }
            }
        }
        
        return farNode;
    }

    static class node {
        int value;
        boolean visited;
        int totalWeight;
        List<edge> adjacent;

        node(int value) {
            this.value = value;
            this.visited = false;
            this.totalWeight = 0;
            this.adjacent = new LinkedList<>();
        }
    }

    static class edge {
        int toNode;
        int weight;

        edge(int toNode, int weight) {
            this.toNode = toNode;
            this.weight = weight;
        }
    }
}
