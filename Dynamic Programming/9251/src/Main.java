import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        String first, second;
        int[][] dp;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        first = br.readLine();
        second = br.readLine();

        int fLen = first.length();
        int sLen = second.length();

        dp = new int[fLen+1][sLen+1];

        for(int i = 1; i <= fLen; i++) {
            char fChar = first.charAt(i-1);
            for(int j = 1; j <= sLen; j++) {
                char sChar = second.charAt(j-1);

                if(fChar == sChar) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

            }
        }

        System.out.println(dp[fLen][sLen]);
    }
}
