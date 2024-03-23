import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static int minDistance;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N, M;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];
        minDistance = N * M;

        for(int row = 0; row < N; row++) {
            String line = br.readLine();
            for(int col = 0; col < M; col++) {
                map[row][col] = line.charAt(col) - '0';
            }
        }

        point start = new point(0,0,0, false);
        point destination = new point(N-1, M-1, 0, false);

        System.out.println(bfs(start, destination));

        br.close();
    }

    static int bfs(point start, point destination) {

        int result = -1;
        
        Queue<point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y][0] = true;
        visited[start.x][start.y][1] = true;

        while(!queue.isEmpty()) {

            point current = queue.poll();
            
            if(current.x == destination.x && current.y == destination.y) {
                result = current.step+1;
                break;
            }

            for(int step = 0; step < 4; step++) {
                int nx = current.x + dx[step];
                int ny = current.y + dy[step];

                if(nx < 0 || ny < 0 || nx > destination.x || ny > destination.y) continue;

                if(map[nx][ny] == 1) {
                    if(current.breakWall) continue; // 이미 벽을 부순 전적이 있으면 더 이상 진행불가

                    queue.offer(new point(nx, ny, current.step + 1, true));
                    visited[nx][ny][1] = true;
                } else {
                    if(current.breakWall) {
                        if(visited[nx][ny][1]) continue;
                        queue.offer(new point(nx, ny, current.step + 1, current.breakWall));
                        visited[nx][ny][1] = true;
                    } else {
                        if(visited[nx][ny][0]) continue;
                        queue.offer(new point(nx, ny, current.step + 1, current.breakWall));
                        visited[nx][ny][0] = true;
                    }
                }
            }
        }

        return result;
    }
}

class point {

    int x, y;
    int step;
    boolean breakWall;

    point(int x, int y, int step, boolean breakWall) {
        this.x = x;
        this.y = y;
        this.step = step;
        this.breakWall = breakWall;
    }
}