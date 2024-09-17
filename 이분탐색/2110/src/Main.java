import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N, C;
        long left = 1, right;
        long[] houses;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new long[N];

        for(int t = 0; t < N; t++) {
            houses[t] = Long.parseLong(br.readLine());
        }

        Arrays.sort(houses);
        right = houses[N-1] - houses[0];

        while(left <= right) {

            int cnt = 1;
            long mid = (left + right) / 2;
            long start = houses[0];

            for(int t = 1; t < N; t++) {

                long current = houses[t];

                if(current - start >= mid) {
                    cnt++;
                    start = current;
                }
            }

            if(cnt >= C) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left - 1);

    }
}
