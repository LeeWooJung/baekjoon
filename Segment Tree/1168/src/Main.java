import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {

    static int[] tree;

    public static void main(String[] args) throws Exception, IOException {
        
        int N, K;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        sb.append('<');

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        tree = new int[N*4];
        segment(1, N, 1);

        int loc = K;
        for(int t = 1; t <= N; t++) {

            sb.append(getKthElem(1, N, loc, 1));
            if(t == N) continue;
            else sb.append(", ");

            loc = (loc + K -2) % tree[1]  + 1;
        }

        sb.append('>');
        System.out.println(sb.toString());

    }

    static int getKthElem(int start, int end, int loc, int index) {

        tree[index]--;

        if(start == end) {
            return start;
        }

        int mid = (start + end) / 2;
        if(tree[index * 2] < loc) {
            return getKthElem(mid+1, end, loc - tree[index*2], index*2+1);
        }
        return getKthElem(start, mid, loc, index*2);

    }

    static int segment(int start, int end, int index) {

        if(start == end) {
            tree[index] = 1;
            return tree[index];
        }

        int mid = (start + end) / 2;
        int left = segment(start, mid, index*2);
        int right = segment(mid+1, end, index*2 + 1);

        tree[index] = left + right;
        return tree[index];
    }
}