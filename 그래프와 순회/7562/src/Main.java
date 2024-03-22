import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] chess;
    static int[] dx = {2,2,1,1,-1,-1,-2,-2};
    static int[] dy = {1,-1,2,-2,2,-2,1,-1};
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int T, length;
        point start, destination;

        // BufferdReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // 변수 입력
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            length = Integer.parseInt(br.readLine());
            chess = new int[length][length];

            st = new StringTokenizer(br.readLine());            
            start = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());            
            destination = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            sb.append(bfs(start, destination) + "\n");
        }
        System.out.print(sb.toString());
    }

    static int bfs(point start, point destination) {
        Queue<point> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            point curLocation = queue.poll();
            int cx = curLocation.x;
            int cy = curLocation.y;

            if(cx == destination.x && cy == destination.y) {
                break;
            }

            for(int step = 0; step < 8; step++) {

                int nx = cx + dx[step];
                int ny = cy + dy[step];

                if(nx < 0 || ny < 0 || nx >= chess.length || ny >= chess.length) continue;
                if(chess[nx][ny] > 0) continue;

                chess[nx][ny] = chess[cx][cy] + 1;
                queue.offer(new point(nx, ny));
            }
        }

        return chess[destination.x][destination.y];
    }
}

class point {
    int x, y;
    point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
