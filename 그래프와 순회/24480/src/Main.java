import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Collections;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // 변수 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        nodes = new node[N+1];
        for(int num = 1; num <= N; num++) {
            nodes[num] = new node(num);
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            nodes[s].adjacent.add(e);
            nodes[e].adjacent.add(s);
        }

        for(int num = 1; num <= N; num++) {
            Collections.sort(nodes[num].adjacent, Collections.reverseOrder());
        }

        dfs(R);

        for(int num = 1; num <= N; num++) {
            sb.append(nodes[num].visitSeq + "\n");
        }

        System.out.print(sb.toString());
        br.close();
    }

    static void dfs(int current) {
        if(nodes[current].visited) return;

        nodes[current].visited = true;
        nodes[current].visitSeq = sequence++;
        for(int adj : nodes[current].adjacent) {
            if(!nodes[adj].visited) {
                dfs(adj);
            }
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
