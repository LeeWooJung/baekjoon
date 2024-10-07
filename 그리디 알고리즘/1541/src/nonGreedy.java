import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class nonGreedy {

    // 10 + 10 - 20 - 20 + 40 + 40 - 30 + 10
    public static void main(String[] args) throws Exception, IOException {
        
        String equation;
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        equation = br.readLine();

        int digit = 1;
        int temp = 0;

        for(int t = equation.length() - 1; t >= 0; t--) {
            char c = equation.charAt(t);

            if('0' <= c && c <= '9') {
                temp += digit * (c - '0');
                digit *= 10;
            } else if(c == '+') {
                digit = 1;
            } else { // c == '-'
                answer -= temp;
                temp = 0;
                digit = 1;
            }
        }

        answer += temp;

        System.out.println(answer);
    }
}
