import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N, M;
        int[] numbers;
        int[] cumulatedSum;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        cumulatedSum = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int index = 0; index < N; index++) {
            numbers[index] = Integer.parseInt(st.nextToken());
        }

        cumulatedSum[0] = numbers[0];
        for(int index = 1; index < N; index++) {
            cumulatedSum[index] = cumulatedSum[index-1] + numbers[index];
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;

            int result = cumulatedSum[j] - cumulatedSum[i] + numbers[i];
            sb.append(result).append('\n');
        }

        System.out.print(sb.toString());

    }
}
