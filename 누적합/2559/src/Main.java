import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N, K;
        int MAX = -10000001;
        int[] temperatures;
        int[] cumulatedSums;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        temperatures = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
        }

        cumulatedSums = new int[N-K+1];
        for(int i = 0; i < K; i++) {
            cumulatedSums[0] += temperatures[i];
        }

        MAX = MAX > cumulatedSums[0] ? MAX : cumulatedSums[0];

        for(int i = 1; i < N-K+1; i++) {
            cumulatedSums[i] = cumulatedSums[i-1] + temperatures[K+i-1] - temperatures[i-1];
            MAX = MAX > cumulatedSums[i] ? MAX : cumulatedSums[i];
        }

        System.out.println(MAX);
    }
}
