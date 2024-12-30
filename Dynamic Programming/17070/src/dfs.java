import java.io.*;
import java.util.*;

public class dfs {

    static int N;
    static int answer = 0;
    static int[][] house;
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        house = new int[N][N];

        for(int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < N; col++) {
                house[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        point left = new point(0,0);
        point right = new point(0, 1);
        int status = 0; // 0 : 가로, 1 : 세로, 2 : 대각선

        dfs(left, right, status);

        System.out.println(answer);

    }

    static void dfs(point left, point right, int status) {

        if(left.x == N - 1 && left.y == N -1) {
            answer++;
            return;
        }
        if(right.x == N - 1 && right.y == N - 1) {
            answer++;
            return;
        }

        int rx = right.x;
        int ry = right.y;

        if(status == 0) { // 가로
            if(ry + 1 < N && house[rx][ry + 1] != 1) {
                dfs(right, new point(rx, ry + 1), 0);
            }
        } else if (status == 1) { // 세로
            if(rx + 1 < N && house[rx+1][ry] != 1) {
                dfs(right, new point(rx+1, ry), 1);
            }
        } else { // 대각선
            if(ry + 1 < N && house[rx][ry+1] != 1) {
                dfs(right, new point(rx, ry + 1), 0);
            }
            if(rx + 1 < N && house[rx+1][ry] != 1) {
                dfs(right, new point(rx + 1, ry), 1);
            }
        }

        if(rx + 1 < N && ry + 1 < N && house[rx+1][ry] != 1 && house[rx][ry+1] != 1 && house[rx+1][ry+1] != 1) {
            dfs(right, new point(rx+1,ry+1), 2);
        }


        return;
    }
}

class point {
    int x;
    int y;
    point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
