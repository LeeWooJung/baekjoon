import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};
    static int[][] land;
    static int M, N;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int T, K;
        int x, y;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // 변수 입력
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {

            int res = 0;

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            land = new int[M][N];

            while(K-- > 0) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
    
                land[x][y] = 1;
            }

            for(int row = 0; row < M; row++) {
                for(int col = 0; col < N; col++) {
                    res += bfs(row, col); // dfs or bfs
                    // res += dfs(row, col);
                }
            }
            sb.append(res + "\n");
            
        }

        System.out.print(sb.toString());
    }

    static int dfs(int x, int y) {
        int count = 0;

        if(land[x][y] <= 0) return count;
        land[x][y] = -1;

        for(int step = 0; step < 4; step++) {
            int nx = x + dx[step];
            int ny = y + dy[step];
            if(nx < 0 || ny < 0 || nx >= M || ny >= N || land[nx][ny] <= 0) continue;
            dfs(nx, ny);
        }

        return 1;
    }

    static int bfs(int x, int y) {
        int count = 0;
        Queue<pair> queue = new LinkedList<>();

        if(land[x][y] <= 0) return count;
        queue.offer(new pair(x, y));

        while(!queue.isEmpty()) {
            pair point = queue.poll();
            if(land[point.x][point.y] <= 0) continue;
            land[point.x][point.y] = -1;
            for(int step = 0; step < 4; step++) {
                int nx = point.x + dx[step];
                int ny = point.y + dy[step];
                if(nx < 0 || ny < 0 || nx >= M || ny >= N || land[nx][ny] <= 0) continue;
                queue.offer(new pair(nx, ny));
            }
        }
        count = 1;

        return count;
    }
}

class pair {
    int x,y;
    pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
