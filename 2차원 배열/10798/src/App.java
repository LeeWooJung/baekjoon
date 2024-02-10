import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int maxLength = 0;
        String str;
        char[][] words = new char[15][5];

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 한 줄씩 읽어서 세로로 한 글자씩 넣어주기.
        for(int col = 0; col < 5; col++){
            str = br.readLine();
            if(str.length() > maxLength) maxLength = str.length();
            for(int row = 0; row < str.length(); row++){
                words[row][col] = str.charAt(row);
            }
        }

        // 이미 뒤집어서 배열에 저장했으므로 그대로 line by line으로 출력
        for(int row = 0; row < maxLength; row++){
            for(int col = 0; col < words[row].length; col++){
                // char 배열은 기본 type이 \0(null) 이므로 이 때는 출력값에 넣지 않게 함.
                if(words[row][col] == '\0') continue;
                System.out.print(words[row][col]);
            }
        }
        
        
    }
}
