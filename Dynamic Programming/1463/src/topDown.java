import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class topDown {

    static int[] dp;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int X;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        X = Integer.parseInt(br.readLine());
        dp = new int[X+1];

        System.out.println(recursive(X));

        br.close();
    }

    static int recursive(int x) {
        if(x == 1) return 0;
        if(dp[x] != 0) return dp[x];

        if(x % 6 == 0) dp[x] = Math.min(recursive(x/3), recursive(x/2)) + 1;
        else if(x % 3 == 0) dp[x] = Math.min(recursive(x/3), recursive(x-1)) + 1;
        else if(x % 2 == 0) dp[x] = Math.min(recursive(x/2), recursive(x-1)) + 1;
        else dp[x] = recursive(x-1) + 1;

        return dp[x];
    }
}
