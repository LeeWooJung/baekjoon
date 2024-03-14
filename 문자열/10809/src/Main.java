import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception, IOException{
        
        // 변수 설정
        String str;
        int[] firstStart = new int[26];
        Arrays.fill(firstStart, -1);

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder
        StringBuilder sb = new StringBuilder();
        // 변수 입력
        str = br.readLine();

        // 문제해결
        for(int index = 0; index < str.length(); index++) {
            int loc = (int) str.charAt(index) - 'a';
            if(firstStart[loc] == -1) {
                firstStart[loc] = index;
            }
        }
        for(int index = 0; index < firstStart.length - 1; index++) {
            sb.append(firstStart[index] + " ");
        }
        sb.append(firstStart[firstStart.length -1]);

        System.out.println(sb.toString());
    }
}
