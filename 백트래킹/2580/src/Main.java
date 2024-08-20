import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int c = 0;
    static int[][] map = new int[9][9];
    static ArrayList<point> toFill = new ArrayList<>();
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int row = 0; row < 9; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < 9; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());

                if(map[row][col] == 0) {
                    toFill.add(new point(row, col)); // 채워야하는 곳 저장.
                    c++; // 채워야하는 개수
                }
            }
        }

        backtracking(0);

        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                sb.append(map[row][col] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());

    }

    static boolean backtracking(int count) {

        if(count == c) { // 다 채워지면 출력
            return true;
        }

        point p = toFill.get(count); // 채워야 하는 위치 확인.

        for(int value = 1; value <= 9; value++) {
            if(check(p.x, p.y, value)) continue; // value를 넣어도 되는지 확인.

            map[p.x][p.y] = value;
            if(backtracking(count + 1)) return true;
            map[p.x][p.y] = 0; // value를 넣었을 때 스도쿠가 완성되지 않으면 초기화.
        }

        return false;
    }

    static boolean check(int row, int col, int value) {

        // 1. 같은 row의 숫자들 확인
        for(int c = 0; c < 9; c++) {
            if(map[row][c] == value) return true;
        }

        // 2. 같은 col의 숫자들 확인
        for(int r = 0; r < 9; r++) {
            if(map[r][col] == value) return true;
        }

        // 같은 3x3 block의 숫자들 확인
        int rowBlock = row / 3;
        int colBlock = col / 3;

        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {

                int cr = rowBlock * 3 + r;
                int cc = colBlock * 3 + c;

                if(cr == row && cc == col) continue;

                if(map[cr][cc] == value) return true;
            }
        }

        return false;
    }

    static class point {
        int x, y;
        point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
