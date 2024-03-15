import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception, IOException{
        
        // 변수 설정
        String line;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // 변수 입력 및 결과 입력
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            sb.append(line + "\n");
        }
        br.close();

        // 결과 출력
        System.out.print(sb.toString());
    }
}
