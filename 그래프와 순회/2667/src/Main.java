import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    static int[][] map;
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};
    static List<Integer> counts = new ArrayList<>();

    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N;
        String input;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 지도 초기화
        for(int row = 0; row < N; row++) {
            input = br.readLine();
            for(int col = 0; col < N; col++) {
                map[row][col] = input.charAt(col) - '0';
            }
        }

        // bfs
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < N; col++) {
                if(map[row][col] > 0) counts.add(bfs(row, col));
            }
        }
        // dfs
        /*
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < N; col++) {
                if(map[row][col] > 0) counts.add(dfs(row, col));
            }
        }
        */

        result();
    }

    static int dfs(int x, int y) {
        
        if(x < 0 || y < 0 || x > map.length -1 || y > map.length -1 || map[x][y] <= 0) return 0;

        int count = 1;
        map[x][y] = -1;

        for(int step = 0; step < 4; step++) {
            int nx = x + dx[step];
            int ny = y + dy[step];
            count += dfs(nx, ny);
        }

        return count;
    }

    static int bfs(int x, int y) {
        int count = 0;

        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(x, y));

        while(!queue.isEmpty()) {
            pair point = queue.poll();
            int cx = point.x;
            int cy = point.y;

            if(map[cx][cy] <= 0) continue;
            map[cx][cy] = -1; // 방문한 곳 -1로 체크
            count++;

            for(int step = 0; step < 4; step++) {
                int nx = cx + dx[step];
                int ny = cy + dy[step];
                if(nx < 0 || ny < 0 || nx > map.length -1 || ny > map.length -1) continue;
                if(map[nx][ny] > 0) queue.offer(new pair(nx, ny));
            }
        }
        return count;
    }

    static void result() {
        Collections.sort(counts);
        System.out.println(counts.size());
        for(int val : counts) {
            System.out.println(val);
        }
    }
}

class pair {
    int x;
    int y;

    pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
