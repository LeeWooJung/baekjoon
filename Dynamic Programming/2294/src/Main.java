import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int n, k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] values = new int[n];
        int[] dp = new int[k+1];

        for(int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= k; i++) {
            dp[i] = Integer.MAX_VALUE-1;
        }

        for(int i = 0; i < n; i++) {
            int nCoins = 1;

            while(nCoins * values[i] <= k) {
                dp[nCoins * values[i]] = Math.min(nCoins, dp[nCoins * values[i]]);
                nCoins++;
            }
        }

        for(int cost = 1; cost <= k; cost++) {
            for(int i = 0; i < n; i++) {
                if(cost - values[i] < 0) continue;

                dp[cost] = Math.min(dp[cost], dp[cost - values[i]] + 1);
            }
        }

        int answer = -1;
        if(dp[k] != Integer.MAX_VALUE-1) answer = dp[k];

        System.out.println(answer);
    }
}