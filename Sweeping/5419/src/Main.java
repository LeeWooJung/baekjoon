import java.io.*;
import java.util.*;

/*
 * 1. y 좌표 압축
 * 2. x 오름차순, y 내림차순으로 정렬
 * 3. 순서대로 읽으면서(Sweeping) Segment Tree 적용
 * 4. Segment Tree
 *  - 최대 구간: [1 ~ 압축된 좌표 개수] ==> leaf node: 압축된 y 좌표를 뜻함.
 *                                    ==> leaf node value: 순차적으로 읽은 압축된 y좌표의 개수
 *  - 순차적으로 읽으면서 1 ~ 해당 y좌표 구간의 값을 더함(해당 좌표로 이동할 수 있는 섬의 개수)
 */

public class Main {

    static long[] tree;
    public static void main(String[] args) throws Exception {
        
        int T, n;
        long count = 0;
        int curX, curY;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            count = 0;
            n = Integer.parseInt(br.readLine());
            ArrayList<point> islands = new ArrayList<>();

            for(int t = 0; t < n; t++) {
                st = new StringTokenizer(br.readLine());
                curX = Integer.parseInt(st.nextToken());
                curY = Integer.parseInt(st.nextToken());

                islands.add(new point(curX, curY));
            }

            // y좌표 내림차순으로 정렬.
            Collections.sort(islands, new Comparator<point>() {
                @Override
                public int compare(point i1, point i2) {
                    return i2.y - i1.y;
                }
            });

            // y좌표 압축
            int numberOfy = compressY(islands);

            // x좌표 오름차순, y좌표 오름차순(Y compression 때문)으로 정렬.
            Collections.sort(islands, new Comparator<point>() {
                @Override
                public int compare(point i1, point i2) {
                    if(i1.x != i2.x) return i1.x - i2.x;
                    else return i1.y - i2.y;
                }
            });

            // Segment tree 생성
            tree = new long[n*4];

            for(point island: islands) {
                int cy = island.y;
                count += getNumberOfYs(1, numberOfy, 1, cy, 1);
                update(1, numberOfy, 1, cy);
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb.toString());
        br.close();
    }

    static long update(int start, int end, int index, int loc) {

        if(loc < start || end < loc) return tree[index];

        if(start == end) {
            tree[index]++;
            return tree[index];
        }

        int mid = (start + end) / 2;
        return tree[index] = update(start, mid, index*2, loc) + update(mid+1, end, index*2+1, loc);
    }

    static long getNumberOfYs(int start, int end, int left, int right, int index) {

        if(right < start || end < left) return 0;

        if(left <= start && end <= right) return tree[index];

        int mid = (start + end) / 2;
        return getNumberOfYs(start, mid, left, right, index*2) + getNumberOfYs(mid+1, end, left, right, index*2+1);
    }

    static int compressY(ArrayList<point> islands) {

        int numberOfy = 1;
        int prevY = islands.get(0).y;

        for(point island: islands) {
            if(prevY == island.y) {
                island.y = numberOfy;
                continue;
            }

            numberOfy++;
            prevY = island.y;
            island.y = numberOfy;
        }

        return numberOfy;
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
