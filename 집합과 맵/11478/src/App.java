import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Map;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        String s;
        String subString;
        int howmany = 1;
        Map<String, Integer> diffString = new HashMap<>();
        
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // s 입력
        s = br.readLine();
        
        /*
         * 문자열에서 한 문자씩 차례대로 읽으면서
         * 1) 문자 1개씩 잘라서 확인
         * 2) 문자 2개씩 잘라서 확인
         * ...
         * N) 문자 N개(문자열의 길이)씩 잘라서 확인한다.
         * Map 구조에서는 중복을 허용하지 않으므로 put으로 넣었을 때 중복된 것은 알아서 사라진다.
         */
        while(howmany <= s.length()) {

            for(int begin = 0; begin + howmany <= s.length(); begin++) {
                subString = s.substring(begin, begin + howmany);
                diffString.put(subString, 0);
            }

            howmany++;
        }

        System.out.println(diffString.size());
    }
}
