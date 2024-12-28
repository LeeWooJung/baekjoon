import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        int[][] height = new int[N][N];

        point postoffice = null;
        int nHouses = 0;
        ArrayList<Integer> heights = new ArrayList<>();

        for(int row = 0; row < N; row++) {
            String lines = br.readLine();
            for(int col = 0; col < N; col++) {
                map[row][col] = lines.charAt(col);

                if(map[row][col] == 'P') postoffice = new point(row, col);
                if(map[row][col] == 'K') nHouses++;
            }
        }

        int min_pk = Integer.MAX_VALUE;
        int max_pk = Integer.MIN_VALUE;

        for(int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < N; col++) {

                int h = Integer.parseInt(st.nextToken());

                height[row][col] = h;
                if(!heights.contains(h)) heights.add(h);

                if(map[row][col] != '.') {
                    min_pk = Math.min(h, min_pk);
                    max_pk = Math.max(h, max_pk);
                }
            }
        }

        Collections.sort(heights);

        int left_minIndex = heights.indexOf(min_pk);
        int right_maxIndex = heights.indexOf(max_pk);

        // two pointers algorithm
        int left_index = 0;
        int right_index = right_maxIndex;

        int answer = Integer.MAX_VALUE;

        while(left_index <= right_index && left_index <= left_minIndex && right_index < heights.size()) {

            int high = heights.get(right_index);
            int low = heights.get(left_index);

            boolean res = bfs(postoffice, low, high, nHouses, N, map, height);

            if(res) {
                left_index++;
                answer = Math.min(answer, high - low);
            } else {
                right_index++;
            }

        }

        System.out.println(answer);

    }

    static boolean bfs(point postoffice, int low, int high, int nHouses, int N, char[][] map, int[][] height) {

        boolean[][] visited = new boolean[N][N];
        int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
        int nVisit = 0;

        Queue<point> queue = new LinkedList<>();
        queue.offer(postoffice);

        while(!queue.isEmpty()) {
            point curr = queue.poll();

            if(visited[curr.x][curr.y]) continue;
            if(map[curr.x][curr.y] == 'K') nVisit++;
            if(nVisit == nHouses) return true;

            visited[curr.x][curr.y] = true;

            for(int step = 0; step < 8; step++) {
                int nx = curr.x + dx[step];
                int ny = curr.y + dy[step];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(height[nx][ny] < low || height[nx][ny] > high) continue;

                queue.offer(new point(nx, ny));
            }

        }

        if(nHouses == nVisit) return true;

        return false;
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