import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class topDown {
    static int[] sequence;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        // 변수 설정
        int n;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        n = Integer.parseInt(br.readLine());
        sequence = new int[501];
        dp = new int[501];

        for (int t = 0; t < n; t++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            sequence[idx] = val;
        }

        int maxIndex = findMaxIndex(sequence);

        // 최대 증가 부분 수열의 길이 구하기
        int maxLength = 0;
        for (int i = 1; i <= maxIndex; i++) {
            if (sequence[i] != 0) { // 값이 있는 경우에만 계산
                maxLength = Math.max(maxLength, findLongestIncreasingSubsequence(i));
            }
        }

        // 전체 길이에서 최대 증가 부분 수열의 길이를 뺀 값 출력
        System.out.println(n - maxLength);

        br.close();
    }

    // 각 위치에서의 최대 증가 부분 수열의 길이를 구하는 재귀 함수
    static int findLongestIncreasingSubsequence(int idx) {
        if (idx == 1) {
            return dp[idx] = 1;
        }
        if (dp[idx] != 0) {
            return dp[idx];
        }

        dp[idx] = 1;
        for (int i = 1; i < idx; i++) {
            if (sequence[i] != 0 && sequence[i] < sequence[idx]) {
                dp[idx] = Math.max(dp[idx], findLongestIncreasingSubsequence(i) + 1);
            }
        }
        return dp[idx];
    }

    // 주어진 수열에서 가장 큰 인덱스를 찾는 함수
    static int findMaxIndex(int[] sequence) {
        int maxIndex = 0;
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] != 0 && i > maxIndex) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
