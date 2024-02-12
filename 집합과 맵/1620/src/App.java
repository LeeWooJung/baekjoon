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
        String name, question;
        int qNum;
        String qName;
        Map<String, Integer> poketmon = new HashMap<>();
        Map<Integer, String> poketmon2 = new HashMap<>();
        
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder
        StringBuilder sb = new StringBuilder();
        // StringTokenizer
        StringTokenizer st;

        // N, M 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 포켓몬 입력
        for(int num = 1; num <= N; num++) {
            name = br.readLine();
            poketmon.put(name, num);
            poketmon2.put(num, name);
        }

        /*
         * 문제 맞추기
         * - 문제가 숫자(도감 번호)로 주어지면 해당 포켓몬의 이름 출력
         * - 문제가 문자(포켓몬 이름)로 주어지면 해당 포켓몬의 번호 출력
         */
        for(int t = 0; t < M; t++) {
            question = br.readLine();
            if(isNum(question)) {
                qNum = Integer.parseInt(question);
                sb.append(poketmon2.get(qNum) + "\n");
            } else {
                qName = question;
                sb.append(poketmon.get(qName) + "\n");
            }
        }

        System.out.print(sb);

    }

    /*
     * @function    isNum
     * @param       number
     * 
     * number를 Integer로 변환했을 때 에러가 나면 - 문자열
     *                               변환이 잘 되면 - 숫자
     * 따라서 try catch 문을 이용하여 문자열 일때는 false, 숫자 일때는 true 반환
     */

    private static boolean isNum(String number) {
        if(number == null) return false;
        
        try {
            Integer num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
