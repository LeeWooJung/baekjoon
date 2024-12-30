import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N, K;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] temperatures = new int[N+1];
        int[] cumSum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int index = 1; index <= N; index++) {
            temperatures[index] = Integer.parseInt(st.nextToken());
            cumSum[index] = cumSum[index - 1] + temperatures[index];
        }

        int max = -10000;
        for(int index = K; index <= N; index++) {
            max = Math.max(max, cumSum[index] - cumSum[index - K]);
        }

        System.out.println(max);
    }
}
