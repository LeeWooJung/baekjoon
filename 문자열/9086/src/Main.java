import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int T;
        String str;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBulider
        StringBuilder sb = new StringBuilder();

        // 변수 입력
        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            str = br.readLine();
            // 문자열의 첫 글자, 마지막 글자 저장
            sb.append(str.charAt(0)).append(str.charAt(str.length()-1)).append("\n");
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}
