import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Stack;


public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int K;
        int money;
        int sum = 0;
        Stack<Integer> wallet = new Stack<Integer>();

        // BufferdReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // K 입력
        K = Integer.parseInt(br.readLine());
        // Stack에 저장 및 제거
        while(K-- > 0) {
            money = Integer.parseInt(br.readLine());
            if(money == 0) {
                wallet.pop();
            } else {
                wallet.push(money);
            }
        }
        // 총합 구하기
        while(!wallet.empty()) {
            sum += wallet.pop();
        }
        // 정답 출력
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
