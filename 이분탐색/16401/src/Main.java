import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int M, N;
        long left = 1, right = 1000000000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        long[] cookies = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int index = 0; index < N; index++) {
            cookies[index] = Long.parseLong(st.nextToken());
        }

        while(left < right) {
            long mid = (left + right) / 2;
            int count = 0;

            for(int index = 0; index < N; index++) {
                count += cookies[index] / mid;
            }

            if(count < M) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        System.out.println(left - 1);


    }
}
