import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int N, K;
        int member;
        Queue<Integer> queue = new LinkedList<Integer>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, K 입력
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // Queue 입력
        for(int num = 1; num <= N; num++) {
            queue.offer(num);
        }

        bw.write("<");

        /*
         * 요세푸스 문제
         * 1) K-1 번째까지 Queue에서 제거하고(poll) 순서대로 Queue 뒤에 다시 넣어준다(offer).
         * 2) K 번째 수를 Queue에서 제거하고(poll) 출력한다.
         * 3) Queue가 빌 때까지 1),2)를 반복한다.
         */
        while(!queue.isEmpty()) {
            for(int t = 1; t < K; t++) {
                member = queue.poll();
                queue.offer(member);
            }
            if(queue.size() != 1){
                bw.write(queue.poll() + ", ");
            } else {
                bw.write(queue.poll() + "");
            }
        }

        bw.write(">");

        bw.flush();
        bw.close();
    }
}
