import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int n;
        long maximum = -1000;
        long[] dp = new long[100001];

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StrinTokenizer
        StringTokenizer st;

        // 변수 입력 및 정답 출력
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int index = 1; index <= n; index++) {

            dp[index] = Integer.parseInt(st.nextToken());
            if(index == 1) {
                maximum = dp[index];
                continue;
            }
            dp[index] = Math.max(dp[index], dp[index] + dp[index-1]);
        }

        System.out.println(maximum);
        br.close();
    }
}
