import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        String str;
        int index;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        str = br.readLine();
        index = Integer.parseInt(br.readLine());

        // 결과 출력
        getI res = new getI(str, index);
        res.printResult();
    }
}

class getI {
    String str;
    int index;

    getI(String str, int index) {
        this.str = str;
        this.index = index-1;
    }

    void printResult() {
        System.out.println(str.charAt(index));
    }
}
