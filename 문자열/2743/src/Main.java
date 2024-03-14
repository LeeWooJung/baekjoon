import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        String str;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        str = br.readLine();

        // 결과 출력
        System.out.println(str.length());
    }
}
