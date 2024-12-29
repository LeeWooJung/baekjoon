import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int T, n = 1000001;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        long[][] dp = new long[n+1][4];

        dp[1][1] = 1;
        dp[2][2] = 1; dp[2][1] = 1;
        dp[3][1] = 2; dp[3][2] = 1; dp[3][3] = 1;

        for(int number = 4; number <= n; number++) {
            for(int givens = 1; givens <= 3; givens++) {
                dp[number][givens] = (dp[number - givens][1] + dp[number - givens][2] + dp[number - givens][3]) % 1000000009;
            }
        }

        while(T-- > 0) {

            int val = Integer.parseInt(br.readLine());

            long answer = 0;
            answer = (dp[val][1] + dp[val][2] + dp[val][3]) % 1000000009;

            sb.append(answer).append("\n");
        }

        System.out.print(sb.toString());
    }
}
