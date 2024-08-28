import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.*;

public class Main {

    static int mod = 1000000007;
    static ArrayList<point> stars = new ArrayList<>();
    static Map<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
    static long[] tree;

    public static void main(String[] args) throws Exception, IOException {
        
        int N, x, y;
        long answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for(int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            stars.add(new point(x, y));
        }

        // x 오름차순 정렬
        Collections.sort(stars, new Comparator<point>() {
            @Override
            public int compare(point p1, point p2) {
                return p1.x - p2.x;
            }
        });

        // x좌표 압축(Segment Tree의 구간)
        int nx = compressX();

        // y 내림차순, x 오름차순 정렬
        Collections.sort(stars, new Comparator<point>() {
            @Override
            public int compare(point p1, point p2) {
                
                if(p1.y != p2.y) return p2.y - p1.y;
                return p1.x - p2.x;
            }
        });

        // y좌표 압축(안 해도 무방, 같은 y좌표를 갖는 point를 모으기 위함)
        compressY();
        tree = new long[nx*4];

        for(int curY : map.keySet()) {

            ArrayList<Integer> xList = map.get(curY);
            for(int xVal : xList) { // 같은 y좌표를 갖는 x들

                // 현재 point의 [좌측 위에 있는 point 수 * 우측 위에 있는 point 수]
                answer += (count(1, nx, 1, 1, xVal-1) % mod) * (count(1, nx, 1, xVal+1, nx) % mod);
                answer %= mod;
            }

            for(int xVal : xList) { // 해당 y좌표에 속하는 point들을 x좌표를 구간으로 개수 추가(구간합)
                update(1, nx, 1, xVal);
            }
        }

        System.out.println(answer);
    }

    static long update(int start, int end, int index, int val) {

        if(val < start || end < val) return tree[index];

        if(start == end) {
            tree[index]++;
            return tree[index];
        }

        int mid = (start + end) / 2;

        return tree[index] = update(start, mid, index*2, val) + update(mid+1, end, index*2+1, val);
    }

    static long count(int start, int end, int index, int left, int right) {

        if(right < start || end < left) return 0;
        if(left <= start && end <= right) return tree[index];

        int mid = (start + end) / 2;

        return count(start, mid, index*2, left, right) + count(mid+1, end, index*2+1, left, right);
    }

    

    static void compressY() {

        int ny = 1;
        int prevY = stars.get(0).y;

        for(point cur: stars) {

            if(cur.y != prevY) ny++;

            prevY = cur.y;
            cur.y = ny;

            map.computeIfAbsent(cur.y, k -> new ArrayList<>());
            map.get(cur.y).add(cur.x);
        }
    }

    static int compressX() {

        int nx = 1;
        int prevX = stars.get(0).x;

        for(point cur: stars) {

            if(cur.x != prevX) nx++;

            prevX = cur.x;
            cur.x = nx;
        }
        
        return nx;
    }
}

class point {
    int x;
    int y;

    point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
