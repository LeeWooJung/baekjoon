import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.List;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static node[] nodes;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int n, m;
        int first, second;
        int testCase = 1;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();


        while(true) {

            int numTrees = 0;

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            // nodes 정보 초기화
            nodes = new node[n+1];
            for(int numNode = 1; numNode <= n; numNode++) {
                nodes[numNode] = new node(numNode);
            }

            // node 사이 연결
            for(int numEdge = 0; numEdge < m; numEdge++) {
                st = new StringTokenizer(br.readLine());
                first = Integer.parseInt(st.nextToken());
                second = Integer.parseInt(st.nextToken());

                nodes[first].adjacent.add(second);
                nodes[second].adjacent.add(first);
            }

            // tree 개수 확인.
            for(int numNode = 1; numNode <= n; numNode++) {
                if(nodes[numNode].visited) continue;
                if(dfs(0, numNode)) numTrees++;
            }
            sb.append("Case " + testCase++ + ": ");

            switch (numTrees) {
                case 0:
                    sb.append("No trees.\n");
                    break;
                case 1:
                    sb.append("There is one tree.\n");
                    break;
            
                default:
                    sb.append("A forest of " + numTrees + " trees.\n");
                    break;
            }
        }

        System.out.print(sb.toString());
    }

    static boolean dfs(int preVal, int currVal) {
        if(nodes[currVal].visited) {
            return false;
        }
        nodes[currVal].visited = true;
        for(int nextVal : nodes[currVal].adjacent) {
            if(preVal == nextVal) continue; // 이미 확인한 간선은 다시 확인하지 않는다(무방향 그래프이기 때문)
            if(!dfs(currVal, nextVal)) return false;
        }
        return true;
    }

    static class node {
        int value;
        boolean visited;
        List<Integer> adjacent;

        node(int value) {
            this.value = value;
            this.visited = false;
            this.adjacent = new LinkedList<>();
        }
    }
}
