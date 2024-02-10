import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int N;
        int value;
        int[] sequence;
        ArrayDeque<Integer> idxStack = new ArrayDeque<Integer>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // N 입력
        N = Integer.parseInt(br.readLine());
        sequence = new int[N];
        // 수열 입력
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < N; t++) {
            sequence[t] = Integer.parseInt(st.nextToken());
        }

        /*
         * 수열을 순서대로 지나가면서 갱신되지 않은 것(idxStack에 존재하는 것)과 비교한다.
         * - 갱신 된 것은 이미 우측의 가장 가까운 값으로 교환되었기 때문에 볼 필요가 없다.
         * 
         * 1) idxStack이 비어있을 때는 좌측에 비교할 값이 없는 것이 없는 것이므로 idxStack에 쌓아준다.
         * 2) idxStack이 비어있지 않다면 다음과 같이 진행한다.
         * 2-1) 현재 수열의 값을 value에 저장하고 idxStack이 빌 때까지 반복한다.
         * 2-2) idxStack의 최상단 인덱스에 속하는 수열의 값(sequence[idxStack.peek()])과 value를 비교한다.
         * 2-3) value가 크다면 현재 sequence[idxStack.peek()] 은 자기 자신보다 큰 값을 찾은 것이다.
         *      따라서 해당 수열의 값을 value로 바꿔준다.
         * 2-4) idxStack.peek() 에 있던 인덱스는 이미 자신보다 큰 값으로 교환되었으므로 pop() 해준다.
         *      즉, 이제 비교대상에서 제외된다.
         * 2-5) idxStack이 비거나 value 값이 비교 값보다 작다면 반복을 종료한다.
         * 2-6) 현재 수열의 위치(idx)를 idxStack에 push한다(해당 값은 아직 우측의 큰 수를 찾지 못했기 때문)
         */
        for(int idx = 0; idx < N; idx++) {
            value = sequence[idx];
            while(!idxStack.isEmpty()) {
                if(value > sequence[idxStack.peek()]) {
                    sequence[idxStack.pop()] = value;
                }
                else {
                    break;
                }
            }
            idxStack.push(idx);
        }
        /*
         * 위 과정을 반복하고도 idxStack에 남은 값은
         * 결국 자신보다 큰 값을 찾지 못한 경우를 의미한다.
         * 따라서 해당 위치에 존재하는 값들은 -1을 입력해준다.
         */
        while(!idxStack.isEmpty()) {
            sequence[idxStack.pop()] = -1;       
        }

        for(int idx = 0; idx < N; idx++) {
            sb.append(sequence[idx] + " ");
        }

        System.out.println(sb.toString());
    }
}
