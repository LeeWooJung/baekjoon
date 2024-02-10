import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Stack;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int N;
        int element;
        int command;

        // Stack
        Stack<Integer> stack = new Stack<Integer>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringTokenizer
        StringTokenizer st;

        // N 입력
        N = Integer.parseInt(br.readLine());
        // N번 동안 명령 입력
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());
            // command에 따라 각기 다른 행동을 취한다.
            if(command == 1) { // 주어진 정수 X를 스택에 쌓는다 -- push()
                element = Integer.parseInt(st.nextToken());
                stack.push(element);
            } else if(command == 2) { // 스택의 맨 위 정수를 뺀다. 없다면 -1을 출력한다. -- pop()
                bw.write(pop(stack) + "\n");
            } else if(command == 3) { // 스택에 들어있는 정수의 개수를 출력한다 -- size()
                bw.write(stack.size() + "\n");
            } else if(command == 4) { // 스택이 비어있다면 1, 아니면 0을 출력한다. -- empty()
                bw.write(empty(stack) + "\n");
            } else if(command == 5) { // 스택이 비어있지 않다면 맨 위 정수를 출력한다 -- peek()
                bw.write(peek(stack) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    /*
     * @function pop
     * @param   Stack<Integer> stack
     * @return  stack.pop(); 
     *          stack이 비어있다면 -1
     */
    public static int pop(Stack<Integer> stack) {
        return stack.size() == 0 ? -1 : stack.pop();
    }
    /*
     * @function empty
     * @param Stack<Integer> stack
     * @return stack이 비어있으면 1, 아니면 0
     */
    public static int empty(Stack<Integer> stack) {
        return stack.empty() ? 1 : 0;
    }
    /*
     * @function peek
     * @param Stack<Integer> stack
     * @return stack.peek();
     *         stack이 비어있다면 -1
     */
    public static int peek(Stack<Integer> stack) {
        return stack.size() == 0 ? -1 : stack.peek();
    }
}
