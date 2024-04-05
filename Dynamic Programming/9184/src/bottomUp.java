import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class bottomUp {

    static final int MAX = 21; // 최대 값 + 1
    static int[][][] dp = new int[MAX][MAX][MAX];
    
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int a, b, c;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        BottomUp();

        while(true) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) break;

            sb.append("w(" + a + ", " + b + ", " + c + ") = " + w(a,b,c) + "\n");

        }

        System.out.print(sb.toString());
        br.close();
    }

    static void BottomUp() {
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                for (int k = 0; k < MAX; k++) {
                    if (i == 0 || j == 0 || k == 0)
                        dp[i][j][k] = 1;
                    else if (i < j && j < k)
                        dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                    else
                        dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1]
                                - dp[i - 1][j - 1][k - 1];
                }
            }
        }
    }

    static int w(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0)
            return dp[0][0][0];
        else if (a >= MAX || b >= MAX || c >= MAX)
            return dp[MAX - 1][MAX - 1][MAX - 1];
        else
            return dp[a][b][c];
    }

}
