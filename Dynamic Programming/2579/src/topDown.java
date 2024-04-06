import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class topDown {

    static int[] stair;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nStairs = Integer.parseInt(br.readLine());
        stair = new int[nStairs + 1];
        dp = new long[nStairs + 1];

        for (int step = 1; step <= nStairs; step++) {
            stair[step] = Integer.parseInt(br.readLine());
        }

        System.out.println(findMax(nStairs));
        br.close();
    }

    static long findMax(int step) {
        if (step <= 0) return 0; // 기저 사례: 계단이 없는 경우
        if (dp[step] != 0) return dp[step]; // 이미 계산한 값이 있다면 반환

        // 현재 계단을 밟을 때와 밟지 않을 때 중 큰 값을 선택
        long current = stair[step] + Math.max(findMax(step - 2), stair[step-1] + findMax(step - 3));

        // 최대 값 저장
        dp[step] = current;

        return current;
    }
}
