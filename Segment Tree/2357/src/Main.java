import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static pair[] tree;
    public static void main(String[] args) throws Exception, IOException {
        
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        tree = new pair[N*4];

        for(int index = 1; index <= N; index++) {
            arr[index] = Integer.parseInt(br.readLine());
        }

        for(int index = 1; index < N*4; index++) {
            tree[index] = new pair();
        }

        segment(1, N, 1);

        for(int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pair result = getInterval(1, N, 1, a, b);
            sb.append(result.min).append(" ").append(result.max).append('\n');
        }

        System.out.print(sb.toString());
    }

    static pair getInterval(int start, int end, int index, int left, int right) {

        if(start > right || end < left) return new pair();

        if(left <= start && end <= right) return tree[index];

        int mid = (start + end) / 2;

        pair l = getInterval(start, mid, index*2, left, right);
        pair r = getInterval(mid+1, end, index*2+1, left, right);

        int min = l.min > r.min ? r.min : l.min;
        int max = l.max > r.max ? l.max : r.max;

        return new pair(min, max);
    }

    static pair segment(int start, int end, int index) {

        if(start == end) {
            return tree[index] = new pair(arr[start], arr[start]);
        }

        int mid = (start + end) / 2;

        pair left = segment(start, mid, index*2);
        pair right = segment(mid+1, end, index*2+1);

        tree[index].min = left.min > right.min ? right.min : left.min;
        tree[index].max = left.max > right.max ? left.max : right.max;

        return tree[index];
    }

    static class pair {

        int min;
        int max;

        pair() {
            this(1000000000, 1);
        }

        pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
