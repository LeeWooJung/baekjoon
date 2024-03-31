import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class dp {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int n;
        int maximum = 0;
        int maxIndex = 0;
        int[] sequence = new int[501];
        int[] dp = new int[501];

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        n = Integer.parseInt(br.readLine());
        for(int t = 0; t < n; t++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            maxIndex = Math.max(maxIndex, idx);

            sequence[idx] = val;
            dp[idx] = 1;
        }

        // Dynamic Programming
        for(int i = 1; i <= maxIndex; i++) {
            if(sequence[i] == 0) continue;
            for(int j = 1; j < i; j++) {
                if(sequence[j] == 0) continue;
                if(sequence[i] > sequence[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maximum = Math.max(dp[i], maximum);
        }

        System.out.println(n - maximum);
        br.close();
    }
}
