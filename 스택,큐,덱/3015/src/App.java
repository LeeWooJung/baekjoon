import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정.
        int N;
        int count, overlapped, currHeight;
        int[] line;
        Stack<person> personList = new Stack<>();

        long result = 0;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        N = Integer.parseInt(br.readLine());
        // line 선언
        line = new int[N];

        // line에 키 입력
        for(int idx = 0; idx < N; idx++) {
            line[idx] = Integer.parseInt(br.readLine());
        }

        /*
         * line에 저장된 키(currHeight) 값들을 순차적으로 확인한다.
         * 1) personList(stack) 이 비어있다면 아무것도 하지 않고 현재 위치 사람의 정보를 push 한다.
         * 2) personList가 비어있지 않다면 다음을 수행한다.
         * 2-1) 현재 선택된 사람의 앞에 최소 한 명이 있으므로 count를 1 증가시킨다.
         * 2-2) (1) 현재 선택된 사람의 키(currHeight)와 (2) 왼쪽에서 가장 가까운 사람의 키(personList.peek().height)를 비교한다.
         * 2-3) (1)이 크다면 : personList를 pop() 해주고, 해당 사람이 갖고 있는 정보(count, overlapped)를 result 에 더한다.
         * 2-4) (1)과 (2)가 같다면 : personList를 pop() 해주고, 해당 사람이 갖고 있는 정보(count, overlapped)를 result 에 더한다.
         *      또한, 두 사람이 한 사람으로 겹쳐졌으므로 기존 overlapped에 (2)의 overlapped와 1을 더해준다.
         * 2-5) (2)가 크다면 추가로 해줄 작업이 없으므로 while문을 벗어난다.
         * 3) while문을 벗어났다면 현재 사람의 정보(height, count, overlapped)를 push 한다.
         */

        for(int idx = 0; idx < N; idx++) {
            count = 0;
            overlapped = 0;
            currHeight = line[idx];

            while(!personList.empty()) {
                count++;
                // 현재 선택된 사람의 키가 stack.top의 키보다 클 경우
                if(currHeight > personList.peek().height) {
                    person popped = personList.pop();
                    result += popped.count + popped.overlapped;
                } // 현재 선택된 사람의 키와 stack.top의 키와 같을 경우
                else if(currHeight == personList.peek().height) {
                    person popped = personList.pop();
                    result += popped.count + popped.overlapped;;
                    overlapped += popped.overlapped + 1;
                } // 현재 선택된 사람의 키가 stack.top의 키보다 작을 경우
                else {
                    break;
                }
            }

            personList.push(new person(currHeight, count, overlapped));
        }

        // 남은 사람들의 count를 결과에 더해준다.
        while(!personList.empty()) {
            person popped = personList.pop();
            result += popped.count ;
        }


        System.out.println(result);


    }
}


class person {
    int height;
    int count;
    int overlapped;

    person(int height, int count, int overlapped) {
        this.height = height;
        this.count = count;
        this.overlapped = overlapped;
    }
}
