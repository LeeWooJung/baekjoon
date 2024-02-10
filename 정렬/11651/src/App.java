import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

import java.util.Arrays;
import java.util.StringTokenizer;

public class App {

    static class Point implements Comparable<Point> {
        // 두 개의 좌표를 표현할 정수 x, y
        int x;
        int y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            if(this.y > p.y) {
                return 1;
            } else if (this.y < p.y) {
                return -1;
            } else {
                if(this.x > p.x) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception, IOException{
        // 변수 설정
        int N;
        int x, y;
        Point[] array;

        // Buffered Reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        N = Integer.parseInt(br.readLine());

        // Array 선언
        array = new Point[N];

        // String Tokenizer
        StringTokenizer st;

        // Array 입력
        for(int t = 0; t < N ; t++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            array[t] = new Point(x, y);
        }

        Arrays.sort(array);

        // BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 정답 출력
        for(Point p: array){
            bw.write(p.x + " " + p.y + "\n");
        }
        bw.flush();
        bw.close();
    }
}
