import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class topDown {
    static int[] wine;
    static int[] dp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception, IOException {

        // 변수 설정
        int n;
        
        // BuffredReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        n = Integer.parseInt(br.readLine());
        
        dp = new int[n + 1];
        wine = new int[n + 1];
        visited = new boolean[n + 1];

        for (int step = 1; step <= n; step++) {
            wine[step] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(n));
    }

    static int solution(int step) {

        if (step <= 0) return 0;

        if(visited[step]) return dp[step];

        visited[step] = true;

        if(step == 1) dp[step] = wine[1];
        else if(step == 2) dp[step] = wine[1] + wine[2];
        else dp[step] = Math.max(Math.max(wine[step] + solution(step-2), solution(step-1)), wine[step] + wine[step-1] + solution(step-3));

        
        return dp[step];
    }
}
