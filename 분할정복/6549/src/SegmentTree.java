import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

/*
 * Segment Tree
 */

public class SegmentTree {

    static int[] segTree;
    static long[] h;
    public static void main(String[] args) throws Exception, IOException {
        
        int n;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            h = new long[n+1];
            segTree = new int[8*n];

            for(int t = 0; t < n; t++) {
                h[t] = Long.parseLong(st.nextToken());
            }

            init(0, n-1, 1);
            long max = getMaxArea(n, 0, n-1);

            sb.append(max).append("\n");
        }

        System.out.print(sb.toString());
    }

    static void init(int left, int right, int index) {

        if(left == right) {
            segTree[index] = left; // save index
            return;
        }

        int mid = (left + right) / 2;

        init(left, mid, index * 2);
        init(mid+1, right, 2*index + 1);

        // 구간에서 가장 작은 height의 loc갱신
        if(h[segTree[index * 2]] < h[segTree[index * 2 + 1]]) {
            segTree[index] = segTree[index*2];
        } else {
            segTree[index] = segTree[index*2 + 1];
        }

        return;
    }

    static int query(int start, int end, int left, int right, int index) {

        if(right < start || end < left) return -1;

        if(left <= start && end <= right) return segTree[index];

        int mid = (start + end) / 2;

        int leftLoc = query(start, mid, left, right, index*2);
        int rightLoc = query(mid+1, end, left, right, index*2 + 1);

        if(leftLoc == -1) return rightLoc;
        else if(rightLoc == -1) return leftLoc;
        else { // histogram height가 더 낮은 loc return
            if(h[leftLoc] <= h[rightLoc]) return leftLoc;
            else return rightLoc;
        }
    }

    static long getMaxArea(int size, int left, int right) {

        /*
         *    left  ---- min height ----  right
         * 
         * 1) <================================> * min height
         * 2) <============> * left min height
         * 3)                <=================> * right min height
         */
        int lowHeightLoc = query(0, size-1, left, right, 1);

        long max = (long)h[lowHeightLoc] * (long)(right - left + 1);

        if(left < lowHeightLoc) {
            max = Math.max(max, getMaxArea(size, left, lowHeightLoc - 1));
        }

        if(lowHeightLoc < right) {
            max = Math.max(max, getMaxArea(size, lowHeightLoc + 1, right));
        }

        return max;
        
    }
}
