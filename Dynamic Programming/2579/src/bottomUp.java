import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bottomUp {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int nStairs;
        int[] Stair = new int[301]; 
        long[] dp = new long[301];

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        nStairs = Integer.parseInt(br.readLine());

        for(int step = 1; step <= nStairs; step++) {
            Stair[step] = Integer.parseInt(br.readLine());
        }

        // Dynamic Programming
        for(int step = 1; step <= nStairs; step++) {
            if(step >= 3) {
                dp[step] = Stair[step] + Math.max(Stair[step-1] + dp[step-3], dp[step-2]);
            } else {
                dp[step] = Stair[step] + dp[step-1];
            }
        }
        
        System.out.println(dp[nStairs]);
        br.close();
    }
}
