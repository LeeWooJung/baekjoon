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
        int number, count;
        Map<Integer, Integer> numbers = new HashMap<>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // N 입력
        N = Integer.parseInt(br.readLine());

        /*
         * 숫자 입력.
         * 1) 해당 숫자가 numbers에 있을 경우 개수를 + 1하여 다시 넣는다.
         * 2) 해당 숫자가 numbers에 없을 경우 개수를 1로 설정하여 넣는다.
         */
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < N; t++) {
            number = Integer.parseInt(st.nextToken());
            if(numbers.containsKey(number)) {
                count = numbers.get(number);
                numbers.put(number, count + 1);
            } else {
                numbers.put(number, 1);
            }
        }

        // M 입력
        M = Integer.parseInt(br.readLine());
        /*
         * 결과 출력
         * 1) 주어진 수가 numbers에 없을 경우 0을 출력한다.
         * 2) 주어진 수가 numbers에 있을 경우 get 메소드를 이용하여 개수를 출력한다.
         */
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < M; t++) {
            number = Integer.parseInt(st.nextToken());
            if(numbers.containsKey(number)) {
                sb.append(numbers.get(number) + " ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb);
    }
}
