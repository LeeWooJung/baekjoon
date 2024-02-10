import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class App {
    public static void main(String[] args) throws Exception, IOException {

        // 변수 설정.
        int N, M;
        ArrayDeque<Integer> queuestack = new ArrayDeque<Integer>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // N 입력
        N = Integer.parseInt(br.readLine());

        // StringTokenizer
        StringTokenizer dataStructure = new StringTokenizer(br.readLine());
        StringTokenizer numbers = new StringTokenizer(br.readLine());

        for(int t = 0; t < N; t++) {
            // Queue일때 주어진 값 넣음.
            // 주어진 순서와 거꾸로 넣어야하기 때문에 Stack처럼 push함.
            if(Integer.parseInt(dataStructure.nextToken()) == 0) { 
                queuestack.push(Integer.parseInt(numbers.nextToken()));
            } else { // Stack은 건너뜀.
                numbers.nextToken();
            }
        }

        // M 값 입력
        M = Integer.parseInt(br.readLine());
        // 수열 입력
        numbers = new StringTokenizer(br.readLine());
        // 해당 수를 차례대로 queuestack에 queue처럼 넣어준다.
        for(int t = 0; t < M ; t++) {
            queuestack.offer(Integer.parseInt(numbers.nextToken()));
        }

        // queuestack의 앞에서 부터 출력.
        while(M-- > 0) {
            sb.append(queuestack.poll() + " ");
        }

        System.out.println(sb);

    }
}
