import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N;
        long M, left = 0, right = 0;
        long[] trees;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        trees = new long[N];
        st = new StringTokenizer(br.readLine());

        for(int t = 0; t < N; t++) {
            trees[t] = Integer.parseInt(st.nextToken());
            right = right > trees[t] ? right : trees[t];
        }

        while(left <= right) {

            long take = 0;
            long H = (left + right) / 2;

            for(int t = 0; t < N; t++) {
                take += trees[t] - H > 0 ? trees[t] - H : 0;
            }

            if(take >= M) {
                left = H + 1;
            } else {
                right = H - 1;
            }
        }

        System.out.println(right);

    }
}
