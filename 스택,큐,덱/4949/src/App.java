import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수
        String sentence;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            sentence = br.readLine();
            // "."만 주어졌을 때 입력을 종료한다.
            if(sentence.equals(".")) break;

            if(checkVPS(sentence)) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }


        bw.flush();
        bw.close();
    }

    /*
     * ']' 일 때 stack의 맨 위에 존재하는 값이 '(' 인지,
     * ')' 일 때 stack의 맨 위에 존재하는 값이 ']' 인지 확인해야 함.
     */

    public static boolean checkVPS(String sentence) {

        Stack<Character> stack = new Stack<Character>();
        Character c;

        for(int t = 0; t < sentence.length(); t++) {
            c = sentence.charAt(t);
            
            if(c == '(' || c == '[') stack.push(c);
            else if(c == ']') {
                if(stack.empty()) return false;
                else if(stack.peek() == '(') return false;
                else stack.pop();
            } else if(c == ')') {
                if(stack.empty()) return false;
                else if(stack.peek() == '[') return false;
                else stack.pop();
            }
        }

        if(!stack.empty()) {
            stack.clear();
            return false;
        } else {
            stack.clear();
            return true;
        }
    }
}
