import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int result;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 및 결과 입력
        result = br.read();

        System.out.println(result);
    }
}
