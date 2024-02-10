import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 선언
        int N;
        Queue<Integer> line = new LinkedList<Integer>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringTokenizer
        StringTokenizer st;

        // N 입력
        N = Integer.parseInt(br.readLine());
        // line 입력
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < N; t++) {
            line.offer(Integer.parseInt(st.nextToken()));
        }

        if(canGetSnack(line)) {
            bw.write("Nice");
        } else bw.write("Sad");

        bw.flush();
        bw.close();
    }

    /*
     * @function    canGetSnack
     * @param       Queue<Integer> line
     * 
     * 1) Queue의 맨 앞 요소를 확인한다.
     * 2) 간식을 받을 수 있는 요소면 해당 요소를 빼내고 번호(getSnack)를 1 증가시킨다.
     * 3) 간식을 받을 수 없는 요소면 해당 요소는 냅두고 Stack을 확인한다
     * 4-1) Stack의 맨 위 요소를 확인했을 때 간식을 받을 수 있는 요소면 해당 요소를 빼내고 번호를 1 증가시킨다.
     * 4-2) Stack이 비어있거나 맨 위 요소가 간식을 받을 수 없는 요소면 Queue의 맨 앞 요소를 빼내어 Stack에 넣어준다.
     * 4-3) 위 과정을 반복한다.
     * 5) Queue의 요소들은 모두 제거됬거나 Stack에 들어갔을 것이다.
     * 5-1) Stack의 맨 위 요소와 번호(getSnack)을 확인하여 같으면 제거한다. 이 과정을 반복한다.
     * 5-2) 만약 같지 않으면 잘못되었으므로 False를 반환한다.
     * 6) 5번에서 False가 반환되지 않았다면 True를 반환한다.
     * 
     * @return      간식을 받을 수 있으면 true, 받을 수 없으면 false를 반환
     */

    public static boolean canGetSnack(Queue<Integer> line) {

        int getSnack = 1;
        Stack<Integer> wait = new Stack<Integer>();

        while(!line.isEmpty()) {
            if(line.peek() == getSnack) { // 1)
                line.poll(); // 2)
                getSnack++;
            } else if(wait.empty()) { // 3)
                wait.push(line.poll()); // 4-2)
            } else {
                if(getSnack == wait.peek()) { // 4-1)
                    wait.pop();
                    getSnack++;
                } else { // 4-2)
                    wait.push(line.poll());
                }
            }
        }

        while(!wait.empty()) { // 5)
            if(wait.peek() == getSnack) { // 5-1)
                wait.pop();
                getSnack++;
            } else { // 5-2)
                return false;
            }
        }

        return true; // 6)
    }
}
