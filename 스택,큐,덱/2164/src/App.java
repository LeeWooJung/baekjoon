import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int N;
        int tmpCard;
        Queue<Integer> cards = new LinkedList<Integer>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // N 입력
        N = Integer.parseInt(br.readLine());

        // cards삽입
        for(int card = 1; card <= N; card++) {
            cards.offer(card);
        }

        /*
         * 풀이
         * 1) cards에서 맨 위(맨 앞) 카드를 한 장 버린다 - poll()
         * 2) 그 후 cards의 맨 위 카드를 맨 뒤로 보낸다 - poll() & offer()
         */
        while(cards.size() > 1) {
            // 1)
            cards.poll();
            // 2)
            tmpCard = cards.poll();
            cards.offer(tmpCard);
        }

        bw.write(cards.poll() + "\n");


        bw.flush();
        bw.close();
    }
}
