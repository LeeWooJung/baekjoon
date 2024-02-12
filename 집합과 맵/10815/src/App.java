import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int N, M;
        Map<Integer, Integer> numbers = new HashMap<>();
        
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // N 입력
        N = Integer.parseInt(br.readLine());
        // numbers 입력
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < N; t++) {
            numbers.put(Integer.parseInt(st.nextToken()), 0);
        }
        // M 입력
        M = Integer.parseInt(br.readLine());
        /*
         * M 개의 수 입력.
         * 주어지는 수가 numbers에 존재하는 수인지 아닌지 확인한다.
         * numbers에 존재하면 출력 값을 1로, 아니면 0으로 한다.
         */
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < M; t++) {
            if(numbers.containsKey(Integer.parseInt(st.nextToken()))){
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString());
    }
}
