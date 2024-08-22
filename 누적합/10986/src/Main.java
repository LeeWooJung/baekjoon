import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N, M;
        int[] numbers;
        long[] cumulatedSum;
        long[] remains;
        long result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N+1];
        cumulatedSum = new long[N+1];
        remains = new long[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken()) % M;
            cumulatedSum[i] = (numbers[i] + cumulatedSum[i-1]) % M;
            remains[(int)cumulatedSum[i]]++; // 같은 remain의 개수 저장.

            if(cumulatedSum[i] == 0) result++; // 첫째 요소부터 현 요소까지의 누적 합 % M == 0 인 것 개수 확인.
        }

        for(long r: remains) { // 같은 remain에서 쌍(pair)을 고를 때의 개수 저장.
            if(r < 2) continue;
            result += r*(r-1) /2;
        }

        /*
         * 완전 탐색 : O(N^3)
         * Only 누적 합 : O(N^2)
         * 누적합 + 같은 나머지 쌍의 개수 : O(N + M)
         */
        System.out.println(result);
    }
}
