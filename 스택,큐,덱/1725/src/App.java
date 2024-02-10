import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception, IOException{
        // 변수 선언
        int N;
        int area = 0;
        int leftHeight, currentHeight;
        int[] histogram;
        Stack<bar> unUsedBars = new Stack<bar>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        N = Integer.parseInt(br.readLine());
        /*
         * histogram 입력
         * histogram 양 끝에 높이가 0인 bar를 추가해준다.
         * 따라서 길이를 'N+2'로 설정한다.
         */
        histogram = new int[N+2];
        for(int index = 1; index <= N; index++) {
            histogram[index] = Integer.parseInt(br.readLine());
        }

        /*
         * histogram을 순차적으로 탐색하면서 다음을 진행한다.
         * 1) Stack이 비어있지 않다면 다음을 수행한다.
         * 1-1) 현재 Stack의 맨 위에 존재하는 bar의 높이를 확인한다(peek().height, leftHeight)
         * 1-2) 현재 인덱스(current)에 위치한 bar의 높이를 확인한다(currentHeight)
         * 1-3) 현재 bar의 높이가 stack의 맨 위에 존재하는 bar의 높이보다 크거나 같다면 while 문을 빠져나가 2) 을 수행한다.
         * 1-4) Stack을 pop 한다
         * 1-5) 미리 구한 leftHeight를 이용하여 현재위치(current) 이전부터 leftHeight 부분까지의 넓이를 구한다.
         * 1-6) 해당 부분 중에서 최댓값을 area에 넣어준다.
         * 2) Stack에 [index, height]를 넣어준다(push).
         */

        for(int current = 0; current <= N + 1; current++) {
            while(!unUsedBars.empty()) {
                leftHeight = unUsedBars.peek().height;
                currentHeight = histogram[current];

                if(leftHeight <= currentHeight) break;

                unUsedBars.pop();

                area = Math.max(area, (current - unUsedBars.peek().index - 1)* leftHeight);
            }
            unUsedBars.push(new bar(current, histogram[current]));
        }

        System.out.println(area);
    }
}

class bar {
    int index;
    int height;

    public bar(int index, int height) {
        this.index = index;
        this.height = height;
    }
}