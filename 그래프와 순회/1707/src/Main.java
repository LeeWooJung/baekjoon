import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static node[] Graph;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int K, V, E;
        int sNode, eNode;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // 변수 입력
        K = Integer.parseInt(br.readLine());
        while(K-- > 0) {

            boolean result = true;

            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            Graph = new node[V+1];
            for(int numNode = 1; numNode <= V; numNode++) {
                Graph[numNode] = new node(numNode);
            }

            for(int numEdge = 0; numEdge < E; numEdge++) {
                st = new StringTokenizer(br.readLine());
                sNode = Integer.parseInt(st.nextToken());
                eNode = Integer.parseInt(st.nextToken());

                Graph[sNode].edge.add(eNode);
                Graph[eNode].edge.add(sNode);
            }

            for(int numNode = 1; numNode <= V; numNode++) {
                if(!Graph[numNode].visited) {
                    //result = result && bfs(numNode);
                    result = result && dfs(numNode, 1);
                }
            }

            if(result) sb.append("YES\n");
            else sb.append("NO\n");
            // bfs
            // dfs

        }
        System.out.print(sb.toString());
    }

    static boolean dfs(int current, int setNum) {

        boolean result = true;

        Graph[current].set = setNum;
        Graph[current].visited = true;

        for(int adj : Graph[current].edge) {
            if(Graph[adj].visited) {
                if(Graph[adj].set == Graph[current].set) return false;
                else continue;
            }
            result = result && dfs(Graph[adj].value, Graph[current].set * -1);
        }

        return result;
    }

    static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Graph[start].visited = true;
        Graph[start].set = 1; // start set : 1, adj set : -1

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int adj : Graph[current].edge) {
                if(Graph[adj].visited) {
                    if(Graph[adj].set == Graph[current].set) return false;
                    continue;
                }
                Graph[adj].visited = true;
                Graph[adj].set = Graph[current].set * -1; // inversion
                queue.offer(adj);
            }
        }

        return true;
    }
}

class node {
    int value;
    int set;
    boolean visited;
    ArrayList<Integer> edge;

    node(int value){
        this.value = value;
        this.visited = false;
        this.edge = new ArrayList<>();
    }
}
