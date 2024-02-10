import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int N;
        int[][] Map;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String Tokenizer
        StringTokenizer st;

        // N 입력
        N = Integer.parseInt(br.readLine());

        // Map 선언
        Map = new int[N][2];

        // Map 값 입력
        for(int idx = 0; idx < N; idx++){
            st = new StringTokenizer(br.readLine());
            Map[idx][0] = Integer.parseInt(st.nextToken());
            Map[idx][1] = Integer.parseInt(st.nextToken());
        }

        /*
         * Arrays.sort를 이용하여 정렬.
         * Comparator iterface에서 compare method를 override하여 구현해준다.
         * Comparator의 Type은 int[]로 설정하였다.
         * - 2차원 배열은 int[][] 다.
         * - 이는 1차원 배열 int[]를 이어 붙였다고 생각할 수 있다.
         * ex) 3행 2열 배열의 경우 : int[3][2]
         * [] [] -- first row : int[2]
         * [] [] -- second row : int[2]
         * [] [] -- third row : int[2]
         * 비교는 다음과 같이 진행한다.
         * 1) 다른 row에 있는 첫 번째 값이 같다면 두 번째 값으로 비교하여 정렬한다.
         * 2) 다른 row에 있는 첫 번째 값이 다르다면 해당 값들로 비교하여 정렬한다.
         */


        Arrays.sort(Map, (row1, row2) -> {
            if(row1[0] == row2[0]) return row1[1] - row2[1];
            else return row1[0] - row2[0];
        });

        // Buffered Writer
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int idx = 0; idx < N ; idx++){
            bw.write(Integer.toString(Map[idx][0]) + " " + Integer.toString(Map[idx][1]) + "\n");
        }
        bw.flush();
        bw.close();

    }
}
