import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static int[][] box;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int M, N;
        Queue<location> queue = new LinkedList<>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];

        for(int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < M; col++) {
                box[row][col] = Integer.parseInt(st.nextToken());
                if(box[row][col] == 1) queue.offer(new location(row, col));
            }
        }

        while(!queue.isEmpty()) {
            location curLoc = queue.poll();
            int cx = curLoc.x;
            int cy = curLoc.y;

            if(box[cx][cy] <= 0) continue;

            for(int step = 0; step < 4; step++) {

                int nx = cx + dx[step];
                int ny = cy + dy[step];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(box[nx][ny] > 0 || box[nx][ny] == -1) continue;

                box[nx][ny] = box[cx][cy] + 1;
                queue.offer(new location(nx, ny));
            }
        }

        getResult(N, M);
    }

    static void getResult(int N, int M) {
        int maximum = 0;
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < M; col++) {
                if(box[row][col] == -1) continue;
                if(box[row][col] == 0) {
                    System.out.println(-1);
                    return;
                }
                maximum = box[row][col] > maximum ? box[row][col] : maximum;
            }
        }
        System.out.println(maximum - 1);
    }
}

class location {
    int x, y;
    location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
