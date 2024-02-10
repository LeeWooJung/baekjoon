import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static node[] nodes;
    public static void main(String[] args) throws Exception, IOException {

        int N;
        int node1, node2;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // N입력
        N = Integer.parseInt(br.readLine());
        // Graph에 입력될 nodes 배열 선언
        nodes = new node[N+1];
        // Graph에 입력될 node 초기화
        for(int num = 1; num <= N; num++) {
            nodes[num] = new node(num);
        }

        // Edge 입력
        for(int t = 1; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());

            nodes[node1].connected.add(node2);
            nodes[node2].connected.add(node1);
        }

        //dfs(1, -1);
        bfs();

        for(int current = 2; current <= N; current++) {
            sb.append(nodes[current].parent + "\n");
        }

        System.out.print(sb.toString());
    }

    public static void bfs() {
        
        int root = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            nodes[current].visited = true;

            for(int next : nodes[current].connected) {
                if(!nodes[next].visited) {
                    nodes[next].parent = current;
                    queue.offer(next);
                }
            }
        }
    }

    public static void dfs(int current, int parent) {
        if(nodes[current].visited) return;

        nodes[current].visited = true;
        nodes[current].parent = parent;
        for(int next : nodes[current].connected) {
            dfs(next, current);
        }
    }

    public static class node {
        int value;
        int parent;
        boolean visited;
        List<Integer> connected;

        node(int value) {
            this.value = value;
            this.parent = -1;
            this.visited = false;
            this.connected = new LinkedList<>();
        }
    }
}

