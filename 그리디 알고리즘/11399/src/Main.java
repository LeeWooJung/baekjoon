import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N;
        int answer = 0;
        int[] cost;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < N; t++) {
            cost[t] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cost);
        answer = cost[0];
        for(int t = 1; t < N; t++) {
            cost[t] += cost[t-1];
            answer += cost[t];
        }

        System.out.println(answer);
    }
}
