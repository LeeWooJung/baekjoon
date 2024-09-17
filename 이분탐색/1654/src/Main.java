import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int K, N;
        long tot = 0, left = 1, right, lanLength;
        int[] lan;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lan = new int[K];

        for(int t = 0; t < K; t++) {
            lan[t] = Integer.parseInt(br.readLine());
            tot += lan[t];
        }
        right = tot / K;


        while(left <= right) {

            int cnt = 0;
            lanLength = (left + right) / 2;

            for(int t = 0; t < K; t++) {
                cnt += lan[t] / lanLength;
            }

            if(cnt < N) {
                right = lanLength - 1;
            } else { // cnt >= N
                left = lanLength + 1;
            }

        }

        System.out.println(right);
    }
}
