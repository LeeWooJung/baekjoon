import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Map;
import java.util.HashMap;

public class Main {

    static Map<Character, Integer> alphabetToNumber = new HashMap<>();
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        String phoneNumber;
        int result = 0;
        
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        phoneNumber = br.readLine();

        // 결과 출력
        changeToNumber();
        for(char c : phoneNumber.toCharArray()) {
            result += alphabetToNumber.get(c);
        }

        System.out.println(result);
    }

    static void changeToNumber() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        int number = 1;
        for(char c : alphabet.toCharArray()) {
            if(c == 'S' || c == 'Z') number--;
            alphabetToNumber.put(c, (number -1)/3 + 3);
            number++;
        }
    }
}
