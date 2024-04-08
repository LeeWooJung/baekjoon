import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bottomUp {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int X;
        int[] dp;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        X = Integer.parseInt(br.readLine());
        dp = new int[X+1];

        for(int number = 1; number <= X; number++) {
            dp[number] = number-1;
        }

        // dynamic programming
        for(int number = 2; number <= X; number++) {
            dp[number] = dp[number-1] + 1;
            if(number % 3 == 0) dp[number] = Math.min(dp[number], dp[number/3] + 1);
            if(number % 2 == 0) dp[number] = Math.min(dp[number], dp[number/2] + 1);
        }
        System.out.println(dp[X]);

        br.close();
    }
}
