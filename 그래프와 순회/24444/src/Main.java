import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static node[] nodes;
    static int sequence = 1;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N, M, R;
        int s, e;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());
        // StringBuilder
        StringBuilder sb = new StringBuilder();


        // 변수 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        nodes = new node[N+1];
        for(int number = 1; number <= N; number++) {
            nodes[number] = new node(number);
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            nodes[s].adjacent.add(e);
            nodes[e].adjacent.add(s);
        }

        for(int number = 1; number <= N; number++) {
            Collections.sort(nodes[number].adjacent);
        }

        bfs(R);

        for(int number = 1; number <= N; number++) {
            sb.append(nodes[number].visitSeq + "\n");
        }

        System.out.print(sb.toString());
    }

    static void bfs(int start) {
        int current;
        Queue<Integer> queue = new LinkedList<>();
    
        queue.offer(start);
    
        while(!queue.isEmpty()) {
            current = queue.poll();
            if(nodes[current].visited) continue;

            for(int next : nodes[current].adjacent) {
                if(!nodes[next].visited) queue.offer(next);
            }

            nodes[current].visited = true;
            nodes[current].visitSeq = sequence++;
        }
    }
}

class node {
    int number;
    int visitSeq;
    boolean visited;
    ArrayList<Integer> adjacent;

    node(int number) {
        this.number = number;
        this.visitSeq = 0;
        this.visited = false;
        this.adjacent = new ArrayList<>();
    }
}