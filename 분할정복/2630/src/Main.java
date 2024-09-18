import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {

    static long blue = 0;
    static long white = 0;
    public static void main(String[] args) throws Exception, IOException {
        
        int N;
        int[][] map;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        run(map, 0, N-1, 0, N-1);

        System.out.println(white);
        System.out.println(blue);
    }

    static void run(int[][] map, int rStart, int rEnd, int cStart, int cEnd) {

        if(check(map, rStart, rEnd, cStart, cEnd)) {

            if(map[rStart][cStart] == 1) blue++;
            else white++;

            return;
        }

        int rMid = (rStart + rEnd) / 2;
        int cMid = (cStart + cEnd) / 2;

        run(map, rStart, rMid, cStart, cMid);
        run(map, rStart, rMid, cMid + 1, cEnd);
        run(map, rMid + 1, rEnd, cStart, cMid);
        run(map, rMid + 1, rEnd, cMid + 1, cEnd);
    }

    static boolean check(int[][] map, int rStart, int rEnd, int cStart, int cEnd) {

        int color = map[rStart][cStart];

        for(int r = rStart; r <= rEnd; r++) {
            for(int c = cStart; c <= cEnd; c++) {
                if(color != map[r][c]) return false;
            }
        }

        return true;
    }
}
