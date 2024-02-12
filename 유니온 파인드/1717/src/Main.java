import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수
        int n, m;
        int order;
        int first, second;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // 변수 값 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        // initialize parent
        for(int value = 0; value < parent.length; value++) {
            parent[value] = -1;
        }

        // 연산 입력(0: 합집합, 1: 합집합인지 아닌지 확인)
        for(int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            order = Integer.parseInt(st.nextToken());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());

            if(order == 0) {
                union(first, second);
            } else {
                if(find(first) == find(second)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.print(sb.toString());
    }

    static int find(int value) {
        if(parent[value] >= 0) {
            parent[value] = find(parent[value]);
            return parent[value];
        }
        return value;
    }

    static void union(int x, int y) {

        int xRep = find(x);
        int yRep = find(y);

        if(xRep == yRep) return;

        int xSize = Math.abs(parent[xRep]);
        int ySize = Math.abs(parent[yRep]);

        boolean yLarge = xRep < yRep ? true : false;

        if(xSize > ySize) { // xRep을 대표 노드로
            parent[yRep] = xRep;
            parent[xRep] -= ySize;
        } else if(xSize < ySize) { // yRep을 대표 노드로
            parent[xRep] = yRep;
            parent[yRep] -= xSize;
        } else {
            if(yLarge) { // xRep 을 대표 노드로
                parent[yRep] = xRep;
                parent[xRep] -= ySize;
            } else { // yRep을 대표 노드로
                parent[xRep] = yRep;
                parent[yRep] -= xSize;
            }
        }

        return;
    }
}
