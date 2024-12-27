import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N, X;
        long max = 0;
        int periods = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] joins = new int[N+1];
        long[] cumSum = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int t = 1; t <= N; t++) {
            joins[t] = Integer.parseInt(st.nextToken());
            cumSum[t] = joins[t] + cumSum[t-1];
        }

        for(int day = 1; day + X <= N+1; day++) {
            long members = cumSum[day + X - 1] - cumSum[day - 1];

            if(members > max) {
                max = members;
                periods = 1;
            } else if(members == max) {
                periods++;
            }
        }

        if(max == 0) {
            System.out.println("SAD");
        } else {
            sb.append(max).append("\n");
            sb.append(periods);
            System.out.println(sb.toString());
        }
    }
}
