import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class topDown {
    static int[] array;
    static int[] dp;

    public static void main(String[] args) throws Exception, IOException {

        // 변수 설정
        int N ;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        N = Integer.parseInt(br.readLine());

        array = new int[N + 1];
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= N; idx++) {
            array[idx] = Integer.parseInt(st.nextToken());
            dp[idx] = -1; // initialization
        }

        int maximum = 0;
        // 각 위치에서의 최대 증가 부분 수열의 길이를 구하기 위한 재귀함수 호출
        for (int i = 1; i <= N; i++) {
            maximum = Math.max(maximum, recursive(i));
        }

        System.out.println(maximum);

        br.close();
    }

    // 재귀 함수를 통해 최대 증가 부분 수열의 길이를 구함
    static int recursive(int idx) {
        // memoization
        if (dp[idx] != -1) {
            return dp[idx];
        }

        // 초기값 설정
        dp[idx] = 1;

        // 이전 위치들을 확인하여 최대 증가 부분 수열의 길이 계산
        for (int j = 1; j < idx; j++) {
            if (array[idx] > array[j]) {
                dp[idx] = Math.max(dp[idx], recursive(j) + 1);
            }
        }

        return dp[idx];
    }
}
