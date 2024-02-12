import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수
        int N, M;
        int fromCity = 1;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // parent 초기화
        parent = new int[N+1];

        for(int city = 1; city < parent.length; city++) {
            parent[city] = city;
        }

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            for(int toCity = 1; toCity < parent.length; toCity++) {
                int edge = Integer.parseInt(st.nextToken());
                if(edge == 1) {
                    union(fromCity, toCity);
                }
            }
            fromCity++;
        }

        st = new StringTokenizer(br.readLine());
        int repCity = parent[Integer.parseInt(st.nextToken())];
        for(int t = 1; t < M; t++) {
            if(repCity != find(parent[Integer.parseInt(st.nextToken())])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static boolean allConnected() {
        for(int city = 1; city < parent.length; city++) {
            if(parent[city] != 1) return false;
        }
        return true;
    }

    static int find(int city) {
        if(parent[city] == city) {
            return city;
        }

        parent[city] = find(parent[city]);
        return parent[city];
    }

    static void union(int x, int y) {

        int xRep = find(x);
        int yRep = find(y);

        if(xRep == yRep) return;

        if(xRep < yRep) {
            parent[yRep] = xRep;
        } else {
            parent[xRep] = yRep;
        }
    }
}
