import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 입력
        int n, m;
        int first, second;
        int numTrees;
        int testCase = 0;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        while(true) {

            numTrees = 0;

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            parent = new int[n+1];

            // parent 초기화
            for(int node = 1; node <= n; node++) {
                parent[node] = -1;
            }

            // 주어진 간선 정보 입력
            for(int t = 0; t < m; t++) {
                st = new StringTokenizer(br.readLine());
                first = Integer.parseInt(st.nextToken());
                second = Integer.parseInt(st.nextToken());

                union(first, second);
            }

            // Tree구조를 이루는 tree의 개수 확인
            for(int node = 1; node <= n; node++) {
                if(parent[node] < 0) numTrees++;
            }

            // 결과 출력
            sb.append("Case " + ++testCase + ": ");
            switch(numTrees) {
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

    static int find(int node) {
        if(parent[node] > 0) {
            return parent[node] = find(parent[node]);
        }
        return node;
    }

    static void union(int x, int y) {

        int xRep = find(x);
        int yRep = find(y);

        if(xRep == yRep) { // cycle 존재
            parent[xRep] = 0;
            return;
        }

        int xRank = Math.abs(parent[xRep]);
        int yRank = Math.abs(parent[yRep]);

        if(xRank == 0 || yRank == 0) { // 연결하려는 두 집합 중 최소 한 쪽이 cycle이 존재할 경우
            parent[xRep] = 0;
            parent[yRep] = 0;
            return;
        }

        boolean yLarge = xRep < yRep ? true : false;

        if(xRank < yRank) {
            parent[xRep] = yRep;
        } else if(yRank < xRank) {
            parent[yRep] = xRep;
        } else {
            if(yLarge) {
                parent[yRep] = xRep;
                parent[xRep]--;
            } else {
                parent[xRep] = yRep;
                parent[yRep]--;
            }
        }

        return;
    }
}
