import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;


public class Main {

    static int[] parent;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int n, m;
        int first, second;
        int chance;
        boolean isCycle = false;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // parent 선언
        parent = new int[n];
        // 초기화
        for(int idx = 0; idx < parent.length; idx++) {
            parent[idx] = -1;
        }
        // union
        for(chance = 1; chance <= m; chance++) {
            st = new StringTokenizer(br.readLine());

            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());

            if(!unionByInRank(first, second)) {
                isCycle = true;
                break;
            }
        }

        if(isCycle) System.out.println(chance);
        else System.out.println(0);
    }

    static boolean unionByInRank(int x, int y) {

        int xRep = find(x);
        int yRep = find(y);

        if(xRep == yRep) return false;

        int xRank = Math.abs(parent[xRep]);
        int yRank = Math.abs(parent[yRep]);

        if(xRank > yRank) { // xRep을 대표 노드로
            parent[yRep] = xRep;
        } else if(xRank < yRank) { // yRep을 대표 노드로
            parent[xRep] = yRep;
        } else {
            if(xRep < yRep) { // xRep을 대표 노드로
                parent[yRep] = xRep;
                parent[xRep]--;
            } else { // yRep을 대표 노드로
                parent[xRep] = yRep;
                parent[yRep]--;
            }
        }

        return true;
    }

    static int find(int value) {
        if(parent[value] < 0) {
            return value;
        }
        parent[value] = find(parent[value]);
        return parent[value];
    }
}
