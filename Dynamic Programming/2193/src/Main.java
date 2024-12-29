import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(1);
            return;
        }


        long[][] dp = new long[N+1][2];

        dp[N][0] = 1;
        dp[N][1] = 1;

        for(int digit = N-1; digit >= 1; digit--) {
            dp[digit][0] = dp[digit+1][0] + dp[digit+1][1];
            dp[digit][1] = dp[digit+1][0];
        }

        System.out.println(dp[1][1]);
    }
}
