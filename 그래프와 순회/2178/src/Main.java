import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};
    static int N, M;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int[][][] maze;
        String input;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M][2];
        for(int row = 0; row < N; row++) {
            input = br.readLine();
            for(int col = 0; col < M; col++) {
                maze[row][col][0] = input.charAt(col) - '0';
                maze[row][col][1] = N*M;
            }
        }

        System.out.println(bfs(maze));
    }

    static int bfs(int[][][] maze) {
        int x = 0, y = 0;

        Queue<point> queue = new LinkedList<>();
        queue.offer(new point(x, y));
        maze[x][y][1] = 1;

        while(!queue.isEmpty()) {
            point p = queue.poll();

            if(maze[p.x][p.y][0] == 0) continue;

            for(int step = 0; step < 4; step++) {
                int nx = p.x + dx[step];
                int ny = p.y + dy[step];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || maze[nx][ny][0] == 0) continue;
                if(maze[p.x][p.y][1] + 1 >= maze[nx][ny][1]) continue;

                maze[nx][ny][1] = maze[p.x][p.y][1] + 1;
                queue.offer(new point(nx, ny));
            }
        }

        return maze[N-1][M-1][1];
    }
}

class point {
    int x, y;
    point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}