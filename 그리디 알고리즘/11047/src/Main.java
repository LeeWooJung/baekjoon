import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N, K;
        int answer = 0;
        int[] values;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        values = new int[N];
        for(int t = 0; t < N; t++) {
            values[t] = Integer.parseInt(br.readLine());
        }

        for(int index = N-1; index >= 0; index--) {
            if(values[index] > K) continue;

            answer += K / values[index];
            K %= values[index];
        }


        System.out.println(answer);
    }
}
