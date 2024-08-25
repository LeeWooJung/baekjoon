import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {

    static long[] arr;
    static long[] tree;
    static int mod = 1000000007;
    public static void main(String[] args) throws Exception, IOException {
        
        int N, M, K;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        tree = new long[N*4];

        for(int index = 1; index <= N; index++) {
            arr[index] = Long.parseLong(br.readLine());
        }

        for(int index = 0; index < N*4; index++) tree[index] = 1;

        segment(1, N, 1);

        for(int t = 0; t < M+K; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1) {
                arr[b] = c;
                update(1, N, 1, b, c);
            } else { // a == 2
                sb.append(intervalMultiply(1, N, b, c, 1)).append('\n');
            }
        }

        System.out.print(sb.toString());

    }

    static void update(int start, int end, int index, int loc, int value) {

        if(loc < start || loc > end) return;
        if(start == end) {
            tree[index] = value;
            return;
        }

        int mid = (start + end) / 2;

        update(start, mid, index*2, loc, value);
        update(mid+1, end, index*2+1, loc, value);

        tree[index] = (tree[index*2] * tree[index*2 + 1]) % mod;
        return;
    }

    static long intervalMultiply(int start, int end, int left, int right, int index) {

        long result = 1;

        if(start > right || end < left) return result;
        if(left <= start && end <= right) return tree[index];

        int mid = (start + end) / 2;

        long l = intervalMultiply(start, mid, left, right, index*2) % mod;
        long r = intervalMultiply(mid+1, end, left, right, index*2+1) % mod;

        result = (l*r) % mod;

        return result;
    }

    static long segment(int start, int end, int index) {

        if(start == end) {
            tree[index] = arr[start];
            return tree[index];
        }

        int mid = (start + end) / 2;

        long left = segment(start, mid, index*2) % mod;
        long right = segment(mid+1, end, index*2+1) % mod;

        tree[index] = (left * right) % mod;
        return tree[index];
    }
}
