import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception, IOException {

        // 변수 선언
        int N;
        int number;
        int step;
        ArrayDeque<Balloons> balloons = new ArrayDeque<Balloons>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder
        StringBuilder sb = new StringBuilder();
        // StringTokenizer
        StringTokenizer st;

        // N 입력
        N = Integer.parseInt(br.readLine());

        // 풍선안의 숫자 입력
        st = new StringTokenizer(br.readLine());
        for(int num = 1; num <= N; num++) {
            balloons.offer(new Balloons(num, Integer.parseInt(st.nextToken())));
        }

        /*
         * 풍선 터트려서 종이 확인하기
         * 1) step이 0보다 클 때는 아래와 같이 진행한다.
         * 1-1) step - 1번만큼 balloons의 앞에서부터 풍선을 빼내어 순서대로 뒤에서부터 집어넣는다.
         * 1-2) 맨 앞의 요소를 추출하여 결과에 저장한다.
         * 2) step이 0보다 작을 때는 아래와 같이 진행한다.
         * 2-1) -step - 1번만큼 balloons의 뒤에서부터 풍선을 빼내어 순서대로 앞에서부터 집어넣는다.
         * 2-2) 맨 뒤의 요소를 추출하여 결과에 저장한다.
         * 3) ballons가 비어있을 때까지 반복한다.
         */
        number = balloons.peek().number;
        step = balloons.peek().step;
        balloons.pollFirst();
        sb.append(number + " ");

        while(!balloons.isEmpty()) {           
            
            if(step > 0) {
                for(int t = 0; t < step -1; t++) {
                    balloons.offerLast(balloons.pollFirst());
                }
                number = balloons.peekFirst().number;
                step = balloons.peekFirst().step;
                balloons.pollFirst();
            } else {
                for(int t = 0; t < -step -1; t++) {
                      balloons.offerFirst(balloons.pollLast());
                }
                number = balloons.peekLast().number;
                step = balloons.peekLast().step;
                balloons.pollLast();
            }
            sb.append(number + " ");
        }

        System.out.println(sb);
    }
}

class Balloons {
    int number;
    int step;

    public Balloons(int number, int step) {
        this.number = number;
        this.step = step;
    }
}
