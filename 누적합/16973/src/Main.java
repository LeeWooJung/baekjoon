import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];
        int[][] cumSum = new int[N+1][M+1];
        boolean[][] visited = new boolean[N+1][M+1];

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for(int row = 1; row <= N; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 1; col <= M; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        for(int row = 1; row <= N; row++) {
            for(int col = 1; col <= M; col++) {
                cumSum[row][col] = map[row][col] + (cumSum[row-1][col] + cumSum[row][col-1] - cumSum[row-1][col-1]);
            }
        }

        int H, W, Sr, Sc, Fr, Fc;
        st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Sr = Integer.parseInt(st.nextToken());
        Sc = Integer.parseInt(st.nextToken());
        Fr = Integer.parseInt(st.nextToken());
        Fc = Integer.parseInt(st.nextToken());

        Queue<point> queue = new LinkedList<>();
        queue.offer(new point(Sr, Sc, 0));

        while(!queue.isEmpty()) {
            point curr = queue.poll();

            if(curr.x == Fr && curr.y == Fc) {
                System.out.println(curr.step);
                return;
            }

            if(visited[curr.x][curr.y]) continue;
            visited[curr.x][curr.y] = true;

            for(int t = 0; t < 4; t++) {
                int nx = curr.x + dx[t];
                int ny = curr.y + dy[t];

                if(nx <= 0 || ny <= 0 || nx > N - (H-1) || ny > M - (W-1)) continue;
                if(visited[nx][ny]) continue;
                if(checkMap(cumSum, nx, ny, H, W)) continue;

                queue.offer(new point(nx, ny, curr.step + 1));
            }
        }

        System.out.println(-1);

    }

    static boolean checkMap(int[][] cumSum, int nx, int ny, int H, int W) {

        int val = cumSum[nx + H -1][ny + W - 1] - cumSum[nx + H -1][ny -1] - cumSum[nx - 1][ny + W -1] + cumSum[nx -1][ny -1];
        if(val >= 1) return true;

        return false;
    }
}

class point {
    int x;
    int y;
    int step;

    point(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}
