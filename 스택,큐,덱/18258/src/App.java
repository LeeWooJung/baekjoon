import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int N;
        int value;
        String command;
        Queue<Integer> queue = new Queue<Integer>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        N = Integer.parseInt(br.readLine());
        // StringTokenizer
        StringTokenizer st;
        // 명령 수행
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            if(command.equals("push")) {
                value = Integer.parseInt(st.nextToken());
                queue.push(value);
            } else if(command.equals("pop")) {
                if(queue.empty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue.pop() + "\n");
                }
            } else if(command.equals("size")) {
                bw.write(queue.size() + "\n");
            } else if(command.equals("empty")) {
                if(queue.empty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if(command.equals("front")) {
                if(queue.empty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue.front() + "\n");
                }
            } else if(command.equals("back")) {
                if(queue.empty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(queue.back() + "\n");
                }
            }
        }


        bw.flush();
        bw.close();
    }
}

/*
 * @Class Queue
 * 
 * - push : offer() 구현
 * - pop : poll() 구현
 * - size : Queue에 있는 요소 개수 반환
 * - empty : Queue가 비어있는지 확인
 * - front : Queue의 가장 앞 요소 값 반환(peek() 구현)
 * - back : Queue의 가장 뒤 요소 값 반환
 */

 class Queue<E> {

    private Element<E> head;
    private Element<E> tail;
    private int size = 0;

    // Queue 생성자
    public Queue() {
        this.head = null;
        this.tail = null;
    }

    /*
     * @function    push
     * @param       E value
     * 
     * 1) Queue가 비어있을 경우 주어진 value를 가지는 element를 head로 설정.
     * 2) 그렇지 않을 경우 tail의 뒤(next)와 연결.
     * 
     * 3) 마무리 후, 새로운 요소가 마지막 요소가 되었으므로 tail이 해당 요소를 가리키도록 수정.
     * 4) size 값 1 증가.
     */

    public boolean push(E value) {
        Element<E> addElem = new Element<E>(value);

        if(size == 0) { // 1)
            head = addElem;
        } else { // 2)
            tail.next = addElem;
        }

        tail = addElem; // 3)
        size++; // 4)
        return true;
    }

    /*
     * @function pop
     * 
     * 1) Queue가 비어있을 경우 null 반환
     * 
     * 2) Queue가 비어있지 않을 경우 head가 가리키는 요소 수정.
     * 3) 기존에 head였던 요소는 모든 연결 끊어줌.
     * 4) size 값 1 감소.
     * 
     * @return  Queue의 맨 앞 요소 반환.
     */

    public E pop() {
        if(size == 0) { // 1)
            return null;
        }

        E element = head.value;
        // head 다음 요소 확인.
        Element<E> nextElem = head.next;

        head.value = null; // 3)
        head.next = null; // 3)

        head = nextElem; // 2)

        size--; // 4)

        return element;
    }

    /*
     * @function    size
     * 
     * @return      size 값 반환.
     */

    public int size() {
        return size;
    }

    /*
     * @function    front
     * 
     * 1) Queue가 비어있을 경우 null 반환
     * 2) 그렇지 않을 경우 Queue의 맨 앞 요소 반환
     * 
     * @return      Queue의 맨 앞 요소 반환
     */

    public E front() {
        if(size == 0) {
            return null;
        }
        return head.value;
    }

    /*
     * @function    back
     * 
     * 1) Queue가 비어있을 경우 null 반환
     * 2) 그렇지 않을 경우 Queue의 맨 뒤 요소 반환
     * 
     * @return      Queue의 맨 뒤 요소 반환
     */
    
    public E back() {
        if(size == 0) {
            return null;
        }
        return tail.value;
    }

    /*
     * @fucntion    empty
     * @return      size의 값이 0인지 아닌지 반환.
     */

    public boolean empty() {
        return size == 0;
    }

 }

/*
 * @Class Element
 * 
 * - value : 요소의 값
 * - next : 다음 요소를 가리킴
 */

class Element<E> {
    E value;
    Element<E> next;

    Element(E value) {
        this.value = value;
        this.next = null;
    }
}
