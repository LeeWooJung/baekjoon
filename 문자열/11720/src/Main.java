import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception, IOException {

        // 변수 설정
        int N;
        String str;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        // 문제 해결
        process p = new process(str);
        System.out.println(p.getSum());
    }
}

class process {
    String str;

    process(String str) {
        this.str = str;
    }

    int getSum() {
        int sum = 0;
        for(int index = 0; index < this.str.length(); index++) {
            sum += str.charAt(index) - '0';
        }
        return sum;
    }
}