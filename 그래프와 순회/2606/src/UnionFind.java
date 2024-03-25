import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class UnionFind {

    // for union & find
    static int[] parent;
    static int[] size;

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

        parent = new int[N+1];
        size = new int[N+1];

        for(int number = 1; number <= N; number++) {
            parent[number] = number;
            size[number] = 1;
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            union(s, e);
        }

        System.out.println(size[find(1)]-1);
        br.close();

    }

    static int find(int value) {
        if(parent[value] != value) {
            parent[value] = find(parent[value]);
        }
        return parent[value];
    }

    static void union(int x, int y) {
        int xRep = find(x);
        int yRep = find(y);

        int xSize = size[xRep];
        int ySize = size[yRep];

        if(xRep == yRep) return;

        if(xSize < ySize) {
            parent[xRep] = yRep;
            size[yRep] += size[xRep];
        } else if(xSize > ySize) {
            parent[yRep] = xRep;
            size[xRep] += size[yRep];
        } else {
            boolean largeX = xRep > yRep ? true : false;
            if(largeX) {
                parent[xRep] = yRep;
                size[yRep] += size[xRep];
            } else {
                parent[yRep] = xRep;
                size[xRep] += size[yRep];
            }
        }
    }
}