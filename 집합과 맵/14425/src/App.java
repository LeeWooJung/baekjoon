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
        int result = 0;
        String toCheck;
        Map<String, Integer> strings = new HashMap<>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N , M 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // N 개의 String 입력
        for(int t = 0; t < N; t++) {
            strings.put(br.readLine(), 0);
        }
        // M 개의 String 입력 후 확인
        for(int t = 0; t < M; t++) {
            toCheck = br.readLine();
            if(strings.containsKey(toCheck)) result++;
        }

        System.out.println(result);
    }
}
