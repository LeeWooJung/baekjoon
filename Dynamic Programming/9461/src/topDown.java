import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class topDown {
    static long[] dp;

    public static void main(String[] args) throws IOException {

        // 변수 설정
        int T, N;

        // 변수 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        // initialization memoization
        dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            sb.append(TopDown(N) + "\n");
        }
        System.out.print(sb.toString());

        br.close();
    }

    // Top-Down 방식으로 동적 계획법을 구현한 메소드
    static long TopDown(int N) {
        // 기저 조건: N이 1, 2, 3인 경우
        if (N <= 3) {
            return dp[N];
        }
        // 이미 계산된 값이면 그대로 반환
        if (dp[N] != 0) {
            return dp[N];
        }
        // 메모이제이션하여 재귀적으로 계산
        return dp[N] = TopDown(N - 2) + TopDown(N - 3);
    }
}
