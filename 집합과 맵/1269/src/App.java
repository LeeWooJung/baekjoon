import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception, IOException {

        // 변수 설정
        int numA, numB;
        int count = 0;
        int number;
        Map<Integer, Integer> A = new HashMap<>();
        Map<Integer, Integer> B = new HashMap<>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());

        // numA, numB 입력
        numA = Integer.parseInt(st.nextToken());
        numB = Integer.parseInt(st.nextToken());

        // A 원소 입력
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < numA; t++) {
            number = Integer.parseInt(st.nextToken());
            A.put(number, 0);
        }
        /*
         * B 원소 입력
         * A에 포함된 원소일 때는 A의 원소를 삭제하고, B에도 넣어주지 않는다.
         */
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < numB; t++) {
            number = Integer.parseInt(st.nextToken());
            if(A.containsKey(number)) {
                A.remove(number);
                continue;
            }
            B.put(number, 0);
        }

        count = A.size() + B.size();
        System.out.println(count);
    }
}
