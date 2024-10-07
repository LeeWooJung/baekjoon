import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N;
        long[] distance;
        long[] cost;
        long min;
        long answer = 0;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = new long[N];
        distance = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < N-1; t++) {
            distance[t] = Long.parseLong(st.nextToken()); // distance[t] : distance from t to t+1
        }
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < N; t++) {
            cost[t] = Long.parseLong(st.nextToken());
        }

        min = cost[0];
        for(int t = 0; t < N-1; t++) {
            min = min < cost[t] ? min : cost[t];
            answer += distance[t] * min;
        }

        System.out.println(answer);
    }
}
