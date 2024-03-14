import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int T, R;
        String S;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // 변수 입력
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            S = st.nextToken();

            sb.append(repetition(R, S)).append("\n");
        }
        System.out.print(sb);

    }

    static String repetition(int R, String S) {
        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < S.length(); index++) {
            sb.append(S.substring(index, index+1).repeat(R));
        }

        return sb.toString();
    }
}
