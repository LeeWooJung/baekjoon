import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class topDown {
    static int n;
    static long maximum = 0;
    static long[][] dp = new long[500][500];
    static boolean[][] visited = new boolean[500][500];

    public static void main(String[] args) throws IOException {
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        n = Integer.parseInt(br.readLine());

        // initialization
        for (int row = 0; row < n; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col <= row; col++) {
                dp[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        findMax(0, 0);

        System.out.println(dp[0][0]);
        br.close();
    }

    static long findMax(int row, int col) {
        // 기저 사례: 범위를 벗어난 경우
        if (row >= n || col > row) return 0;
        
        // 이미 방문한 경우 값 재사용
        if (visited[row][col]) return dp[row][col];
        
        // 현재 위치의 값과 아래 두 위치 중 큰 값을 선택
        long current = dp[row][col];
        long downLeft = findMax(row + 1, col);
        long downRight = findMax(row + 1, col + 1);
        
        // 현재 위치까지의 최대 합 계산 후 저장
        dp[row][col] = current + Math.max(downLeft, downRight);
        visited[row][col] = true; // 방문 표시
        
        return dp[row][col];
    }
}
