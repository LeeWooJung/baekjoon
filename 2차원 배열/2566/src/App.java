import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N = 9;
        int max = -1;
        int ROW = 0, COL = 0;
        int[][] arr = new int[9][9];

        // BufferedReader 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 각 행(Line) 별, 각 Column 별 값들을 읽은 후 최댓값 및 그에 맞는 인덱스 구하기
        for(int row = 0; row < N; row++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int col = 0; col < N; col++){
                arr[row][col] = Integer.parseInt(st.nextToken());
                if(arr[row][col] > max){
                    max = arr[row][col];
                    ROW = row + 1;
                    COL = col + 1;
                }
            }
        }

        System.out.println(max);
        System.out.print(ROW + " " + COL);

    }
}
