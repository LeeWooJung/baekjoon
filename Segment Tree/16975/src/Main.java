import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static long[] tree;
    public static void main(String[] args) throws Exception, IOException {
    

        int N, M, k, x, i, j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        tree = new long[N*4];

        st = new StringTokenizer(br.readLine());
        for(int index = 1; index <= N; index++) arr[index] = Integer.parseInt(st.nextToken());
        segment(1, N, 1);

        M = Integer.parseInt(br.readLine());

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());

            if(query == 1) {
                i = Integer.parseInt(st.nextToken());
                j = Integer.parseInt(st.nextToken());
                k = Integer.parseInt(st.nextToken());

                intervalAdd(1, N, i, j, 1, k);
            } else { // query == 2
                x = Integer.parseInt(st.nextToken());

                sb.append(getX(1, N, 1, x)).append('\n');
            }
        }
        System.out.print(sb.toString());
    }

    static long getX(int start, int end, int index, int locX) {

        if(locX < start || end < locX) return 0;

        if(start == end) return tree[index];

        int mid = (start + end)/2;
        return tree[index] + getX(start, mid, index*2, locX) + getX(mid+1, end, index*2+1, locX);
    }

    // i ~ j(left ~ right) 구간에 포함되는 곳에 k(value) 더해주기.
    static void intervalAdd(int start, int end, int left, int right, int index, int value) {

        if(right < start || end < left) return;

        if(left <= start && end <= right) {
            tree[index] += value;
            return;
        }

        int mid = (start + end) / 2;
        intervalAdd(start, mid, left, right, index*2, value);
        intervalAdd(mid+1, end, left, right, index*2+1, value);

        return;
    }

    static void segment(int start, int end, int index) {

        if(start == end) {
            tree[index] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        segment(start, mid, index*2);
        segment(mid+1, end, index*2+1);
    }
}
