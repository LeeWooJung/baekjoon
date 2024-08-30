import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.*;

public class Main {

    /*
     * points
     * - x : x value
     * - lowYindex : low Y location (ys)
     * - highYindex : high Y location (ys)
     * - start : true if start else false
     */
    static ArrayList<point> points = new ArrayList<>();
    /*
     * yRealVal
     * - index: compressed value
     * - value: real value
     */
    static ArrayList<Integer> yRealVal = new ArrayList<>();
    /*
     * ys
     * - index : location
     * - value : compressed value
     */
    static ArrayList<yInfo> ys = new ArrayList<>();

    static long[] totY;
    static int[] count;
    public static void main(String[] args) throws Exception, IOException {
        
        int N;
        int cnt = 0;
        int x1, x2, y1, y2;
        long result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for(int t = 0; t < N; t++) {

            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            yInfo _y1 = new yInfo(y1, cnt++); ys.add(_y1);
            yInfo _y2 = new yInfo(y2, cnt++); ys.add(_y2);

            points.add(new point(x1, _y1.index, _y2.index, true));
            points.add(new point(x2, _y1.index, _y2.index, false));
        }

        // y 좌표 순으로 오름차순 (Compress 용)
        Collections.sort(ys, new Comparator<yInfo>() {
            @Override
            public int compare(yInfo fy, yInfo sy) {
                return fy.value - sy.value;
            }
        });

        compressY(); // ny : number of compressed y values

        // index 순으로 오름차순
        Collections.sort(ys, new Comparator<yInfo>() {
            @Override
            public int compare(yInfo fy, yInfo sy) {
                return fy.index - sy.index;
            }
        });

        // x 좌표 순으로 오름차순
        Collections.sort(points, new Comparator<point>() {
            @Override
            public int compare(point p1, point p2) {
                return p1.x - p2.x;
            }
        });


        totY = new long[N*16];
        count = new int[N*16];

        int prevX = points.get(0).x;

        for(point p: points) {

            boolean isStart = p.start;
            int curX = p.x;

            int lyindex = p.lowYindex;
            int hyindex = p.highYindex;

            int lcValue = ys.get(lyindex).value; // compressed low y value
            int hcValue = ys.get(hyindex).value; // compressed high y value

            if(prevX != curX) {
                result += (curX - prevX) * totY[1];
            }

            int c = isStart ? 1 : -1;
            update(0, 2*N-1, 1, lcValue, hcValue, c);
            
            prevX = p.x;
        }

        System.out.println(result);

    }

    static void update(int start, int end, int index, int left, int right, int c) {

        if(right < start || end < left) return;
        if(start == end) return;
        int mid = (start + end) / 2;


        if(left <= start && end <= right) {
            count[index] += c;
        } else {
            if(left < mid) update(start, mid, index*2, left, right, c);
            if(right > mid) update(mid, end, index*2+1, left, right, c);
        }

        if(count[index] > 0) totY[index] = yRealVal.get(end) - yRealVal.get(start);
        else {
            if(start == end) totY[index] = 0;
            else totY[index] = totY[index*2] + totY[index*2 + 1];
        }
    }

    static void compressY() {

        int ny = 0;
        int prev = ys.get(0).value;
        yRealVal.add(prev);

        for(yInfo yi: ys) {

            if(prev != yi.value) {
                ny++;
                yRealVal.add(yi.value);
            }

            prev = yi.value;
            yi.value = ny;
        }

        return;
    }

    static class point {
        int x;
        int lowYindex;
        int highYindex;

        boolean start; // 시작점 : start = true, 끝점 : start = false

        point(int x, int lowYindex, int highYindex, boolean s) {
            this.x = x;
            this.lowYindex = lowYindex;
            this.highYindex = highYindex;
            this.start = s;
        }
    }

    static class yInfo {

        int value;
        int index;

        yInfo(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
