import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int[][] square = new int[100][100];
        int length = 10;
        int num;
        int rowStart, colStart;
        int filled = 0;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());


        // 정사각형 색종이 개수 구하기
        num = Integer.parseInt(st.nextToken());
        // 색종이 붙이기
        for(int t = 0; t < num; t++){
            st = new StringTokenizer(br.readLine());
            rowStart = Integer.parseInt(st.nextToken()) -1;
            colStart = Integer.parseInt(st.nextToken()) -1;
            for(int r = rowStart; r < rowStart + length; r++){
                for(int c = colStart; c < colStart + length; c++){
                    square[r][c] = 1;
                }
            }
        }
        // 색종이 붙은 넓이 구하기.
        for(int r = 0; r < 100; r++){
            for(int c = 0; c < 100; c++){
                filled += square[r][c];
            }
        }

        System.out.println(filled);


    }
}
