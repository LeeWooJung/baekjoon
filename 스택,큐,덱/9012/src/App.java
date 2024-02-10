import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int T;
        String parenthesis;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 변수 입력
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            parenthesis = br.readLine();
            if(checkVPS(parenthesis)) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }

    /*
     * @function    checkVPS
     * @param       parenthesis
     * 
     * Stack을 생성하여 주어지는 parenthesis가 VPS를 만족하는지 확인한다.
     * 1) parenthesis의 문자를 하나씩 읽는다.
     * 2) 문자가 '(' 인 경우 stack에 집어넣는다.
     * 3) 문자가 ')' 인 경우 다음을 확인한다.
     * 4) stack이 비어있는가?
     * 4-1) stack이 비어있으면 VPS를 만족하지 못하므로 false를 return한다.
     * 4-2) stack이 비어있지 않으면 '(' 가 최소 하나 이상 들어있는 것이므로 stack을 pop()한다.
     * 5) 위 과정을 완료했는데도 stack에 남아있는 것이 있다면 false를 return한다.
     * 6) stack이 비어있다면 true를 return한다.
     * 
     * @return      위 과정을 진행하면서 True 혹은 False를 리턴함.
     */

    public static boolean checkVPS(String parenthesis) {
        Stack<Character> stack = new Stack<Character>();
        for(int t = 0; t < parenthesis.length(); t++) {
            if(parenthesis.charAt(t) == '(') {
                stack.push('(') ;
            } else if(parenthesis.charAt(t) == ')') {
                if(stack.empty()) return false;
                stack.pop();
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
