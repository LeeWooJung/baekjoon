import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception, IOException {
        
        int N;
        int[][] map;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int r = 0; r < N; r++) {
            String colors = br.readLine();
            for(int c = 0; c < N; c++) {
                map[r][c] = colors.charAt(c) - '0';
            }
        }

        divide(map, 0, N-1, 0, N-1);
        System.out.println(sb.toString());
    }

    static void divide(int[][] map, int rStart, int rEnd, int cStart, int cEnd) {

        if(check(map, rStart, rEnd, cStart, cEnd)) {
            sb.append(map[rStart][cStart]);
            return;
        }

        int rMid = (rStart + rEnd) / 2;
        int cMid = (cStart + cEnd) / 2;

        sb.append("(");

        divide(map, rStart, rMid, cStart, cMid);
        divide(map, rStart, rMid, cMid + 1, cEnd);
        divide(map, rMid + 1, rEnd, cStart, cMid);
        divide(map, rMid + 1, rEnd, cMid + 1, cEnd);

        sb.append(")");

        return;
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
