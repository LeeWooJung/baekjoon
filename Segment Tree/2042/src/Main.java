import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {

    static long[] arr;
    static long[] tree;
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

        segment(1, N, 1);

        for(int t = 0; t < M + K; t++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            

            if(a == 1) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                recursiveEdit(1, N, 1, b, c);
            } else { // a == 2
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(recursiveSum(1, N, 1, b, c)).append('\n');
            }
        }

        System.out.print(sb.toString());
    }

    static void recursiveEdit(int start, int end, int index, int editLoc, long value) {

        if(editLoc < start || end < editLoc) return;
        if(start == end) {
            arr[editLoc] = value;
            tree[index] = value;
            return;
        }

        int mid = (start + end)/2;

        recursiveEdit(start, mid, index*2, editLoc, value);
        recursiveEdit(mid+1, end, index*2 + 1, editLoc, value);

        tree[index] = tree[index * 2] + tree[index *2 + 1];
    }

    static long recursiveSum(int start, int end, int index, int left, int right) {

        if(end < left || right < start) return 0;

        if(left <= start && end <= right) return tree[index];

        int mid = (start + end)/2;

        return recursiveSum(start, mid, index*2, left, right) + recursiveSum(mid+1, end, index*2+1, left, right);
    }

    static long segment(int start, int end, int index) {

        if(start == end) {
            tree[index] = arr[start];
            return tree[index];
        }

        int mid = (int)((start + end) / 2);

        tree[index] = segment(start, mid, index*2) + segment(mid + 1, end, index*2 + 1);
        return tree[index];
    }
}
