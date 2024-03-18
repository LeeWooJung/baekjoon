import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static computer[] network;
    static int yVirus = -1;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N, M;
        int s, e;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        network = new computer[N+1];

        for(int number = 1; number <= N; number++) {
            network[number] = new computer(number);
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            network[s].adj.add(e);
            network[e].adj.add(s);
        }

        //bfs(1);
        dfs(1);


        System.out.println(yVirus);
    }

    static void dfs(int current) {
        if(network[current].visited) return;
        yVirus++;
        network[current].visited = true;

        for(int next : network[current].adj) {
            if(network[next].visited) continue;
            dfs(next);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {

            int cNum = queue.poll();
            if(network[cNum].visited) continue;

            yVirus++;
            network[cNum].visited = true;

            for(int next : network[cNum].adj) {
                if(network[next].visited) continue;
                queue.offer(next);
            }
        }

    }
}

class computer {
    int number;
    boolean visited;
    ArrayList<Integer> adj;

    computer(int number) {
        this.number = number;
        this.visited = false;
        this.adj = new ArrayList<>();
    }
}
