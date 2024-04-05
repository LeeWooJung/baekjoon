import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class topDown {

    static int[][][] dp = new int[21][21][21];
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int a, b, c;

        // initialize dp
        dp[0][0][0] = 1;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

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

    static int w(int a, int b, int c) {

        if(a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20) {
            if(dp[a][b][c] != 0) return dp[a][b][c];
        }

        if(a <= 0 || b <= 0 || c <= 0) return dp[0][0][0];
        else if(a > 20 || b > 20 || c > 20) return dp[20][20][20] = w(20,20,20);
        else if(a < b && b < c) return dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
        else return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
    }

}
