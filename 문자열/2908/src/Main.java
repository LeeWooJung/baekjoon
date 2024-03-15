import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        String str1, str2;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        st = new StringTokenizer(br.readLine());
        str1 = st.nextToken();
        str2 = st.nextToken();

        getResult res = new getResult(str1, str2);
        res.printResult();
    }
}

class getResult {
    String str1;
    String str2;

    getResult(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    void printResult() {
        int int1 = reverse(this.str1);
        int int2 = reverse(this.str2);

        if (int1 > int2) System.out.println(int1);
        else System.out.println(int2);
    }

    int reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return Integer.parseInt(sb.reverse().toString());
    }
}
