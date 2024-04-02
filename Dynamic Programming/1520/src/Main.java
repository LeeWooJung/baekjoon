import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int M, N;
        
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for(int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < M; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
                dp[row][col] = -1;
            }
        }

        /*
         * dp[x][y] : (x,y)에서 목적지까지 갈 수 있는 경우의 수
         */
        
        dfs(0,0);

        System.out.println(dp[0][0]);
        
        br.close();
    }

    static int dfs(int row, int col) {
        if(row == map.length -1 && col == map[0].length -1) return 1; // 도착한 경우
        if(dp[row][col] != -1) return dp[row][col]; // 이미 방문한 경우

        dp[row][col] = 0;
        for(int step = 0; step < 4; step++) {
            int nx = row + dx[step];
            int ny = col + dy[step];

            if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;

            if(map[row][col] > map[nx][ny]) dp[row][col] += dfs(nx, ny);
        }
        return dp[row][col];
    }
}
