import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {

    static int[] dvd;
    static pair[] tree;
    public static void main(String[] args) throws Exception, IOException {
        
        int T, N, K; // K : number of case
        int Q, A, B; // Q = 0 : A <-> B, Q = 1 : get A ~ B

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            dvd = new int[N+1];
            for(int index = 1; index <= N; index++) {
                dvd[index] = index;
            }
            tree = new pair[N*4];

            segment(1, N, 1);

            for(int t = 0; t < K; t++) {
                st = new StringTokenizer(br.readLine());
                Q = Integer.parseInt(st.nextToken());
                A = Integer.parseInt(st.nextToken()) + 1;
                B = Integer.parseInt(st.nextToken()) + 1;

                if(Q == 0) {
                    int temp = dvd[A];

                    update(1, N, 1, A, dvd[B]);
                    update(1, N, 1, B, temp);
                } else { // Q == 1
                    boolean result = intervalMinMax(1, N, 1, A, B);

                    if(result) sb.append("YES").append('\n');
                    else sb.append("NO").append('\n');
                }
            }
        }

        System.out.print(sb.toString());
    }

    static pair segment(int start, int end, int index) {

        if(start == end) {
            return tree[index] = new pair(dvd[start], dvd[start]);
        }

        int mid = (start + end) / 2;
        pair left = segment(start, mid, index*2);
        pair right = segment(mid+1, end, index*2+1);

        int min = left.min > right.min ? right.min : left.min;
        int max = left.max > right.max ? left.max : right.max;

        tree[index] = new pair(min, max);
        return tree[index];
    }

    static pair update(int start, int end, int index, int loc, int value) {

        if(loc < start || end < loc) return tree[index];

        if(start == end) {
            dvd[loc] = value;
            tree[index] = new pair(value, value);
            return tree[index];
        }

        int mid = (start + end) / 2;

        pair left = update(start, mid, index*2, loc, value);
        pair right = update(mid+1, end, index*2 + 1, loc, value);

        int min = left.min > right.min ? right.min : left.min;
        int max = left.max > right.max ? left.max : right.max;

        tree[index] = new pair(min, max);
        return tree[index];
    }

    static boolean intervalMinMax(int start, int end, int index, int left, int right) {

        if(right < start || end < left) return true;

        if(left <= start && end <= right) return left <= tree[index].min && tree[index].max <= right;

        int mid = (start + end) / 2;

        return intervalMinMax(start, mid, index*2, left, right) && intervalMinMax(mid+1, end, index*2+1, left, right);
    }

    static class pair {
        int min;
        int max;

        pair() {
            this(100001, 0);
        }

        pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
