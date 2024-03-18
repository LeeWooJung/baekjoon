import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class Main {

    static node[] graph;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N, M, V;
        int s, e;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new node[N+1];
        for(int number = 1; number <= N; number++) {
            graph[number] = new node(number);
        }
        
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph[s].adj.add(e);
            graph[e].adj.add(s);
        }

        for(int number = 1; number <= N; number++) {
            Collections.sort(graph[number].adj);
        }

        dfs(V);
        // 방문 초기화
        for(int number = 1; number <= N; number++) {
            graph[number].visited = false;
        }
        result.append("\n");
        bfs(V);

        System.out.print(result.toString());
    }

    static void dfs(int current) {
        if(graph[current].visited) return;

        graph[current].visited = true;
        result.append(current + " ");

        for(int next : graph[current].adj) {
            if(graph[next].visited) continue;
            dfs(next);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            if(graph[current].visited) continue;

            graph[current].visited = true;
            result.append(current + " ");

            for(int next : graph[current].adj) {
                if(graph[next].visited) continue;
                queue.offer(next);
            }
        }
    }
}

class node {
    int number;
    boolean visited;
    ArrayList<Integer> adj;

    node(int number) {
        this.number = number;
        this.visited = false;
        this.adj = new ArrayList<>();
    }
}
