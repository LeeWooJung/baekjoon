import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 선언
        int N;
        int value;
        int command;
        Deque<Integer> deque = new Deque<Integer>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringTokenizer
        StringTokenizer st;

        // N 입력
        N = Integer.parseInt(br.readLine());
        for(int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());
            if(command == 1) {
                value = Integer.parseInt(st.nextToken());
                deque.pushFirst(value);
            } else if(command == 2) {
                value = Integer.parseInt(st.nextToken());
                deque.pushLast(value);
            } else if(command == 3) {
                if(deque.empty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.popFirst() + "\n");
                }
            } else if(command == 4) {
                if(deque.empty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.popLast() + "\n");
                }
            } else if(command == 5) {
                bw.write(deque.size() + "\n");
            } else if(command == 6) {
                if(deque.empty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if(command == 7) {
                if(deque.empty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.peekFirst() + "\n");
                }
            } else if(command == 8) {
                if(deque.empty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.peekLast() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}

/*
 * @class   Deque
 * 
 * Element<E> head : Deque의 첫 요소를 가리킨다. 없을 경우 null을 가리킨다.
 * Element<E> tail : Deque의 마지막 요소를 가리킨다. 없을 경우 null을 가리킨다.
 * int size : Deque의 요소의 개수를 의미한다.
 * 
 * @function    pushFist(E value) : value를 Deque의 앞에 넣는다.
 * @function    pushLast(E value) : value를 Deque의 마지막에 넣는다.
 * @function    popFirst() : Deque의 첫 요소를 추출한다.
 * @function    popLast() : Deque의 마지막 요소를 추출한다.
 * @fucntion    peekFirst() : Deque의 첫 요소를 확인한다.
 * @function    peekLast() : Deque의 마지막 요소를 확인한다.
 * @function    addOne() : Deque이 비어있을 때는 이 함수를 이용하여 요소를 추가한다.
 * @function    size() : Deque에 존재하는 요소의 개수를 확인한다.
 * @function    empty(): Deque이 비어있는지 확인한다.
 */

class Deque<E> {
    private Element<E> head;
    private Element<E> tail;
    private int size;

    // Deque 생성자
    public Deque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /*
     * @pushFirst
     * 
     * 새로들어오는 요소 : elem
     * 1) Deque이 비어있을 때는 addOne() 메소드를 호출하고 종료한다.
     * 2) elem이 맨 앞에 올 것이므로 elem이 head의 앞에 와야 한다.
     *    따라서 elem -> head가 되도록 elem.next = head
     * 3) elem <- head가 되도록 head.prev = elem
     * 4) 이제 elem이 Deque의 맨 앞 요소이므로 head = elem
     * 5) size를 증가시켜준다.
     */

    public boolean pushFirst(E value) {

        if(size == 0) {
            addOne(value);
            return true;
        }

        Element<E> elem = new Element<E>(value);

        elem.next = head;
        head.prev = elem;
        head = elem;
        size++;

        return true;
    }

    /*
     * @function    pushLast
     * 
     * 새로 들어오는 요소 : elem
     * 1) Deque이 비었을 때는 addOne() 메소드를 호출하고 종료한다.
     * 2) elem이 맨 마지막에 들어올 것이므로 elem이 tail 뒤에 와야한다.
     *    따라서 tail <- elem이 되도록 elem.prev = tail
     * 3) 기존 Deque가 tail이 있었다면 tail -> elem가 되어야 한다.
     *    따라서 tail.next = elem
     * 4) 이제 elem이 맨 마지막 요소이므로 tail = elem
     * 5) size를 증가시킨다.
     */

    public boolean pushLast(E value) {

        if(size == 0) {
            addOne(value);
            return true;
        }

        Element<E> elem = new Element<E>(value);
        elem.prev = tail;
        tail.next = elem;
        tail = elem;
        size++;

        return true;
    }

    /*
     * @function popFirst
     * 
     * 1) Deque이 비어있다면 null을 return한다.
     * 그렇지 않다면,
     * 2) head의 요소 값, 다음 값을 확인한다.
     * 3) head가 가리키는 요소들을 모두 끊어낸다(null을 넣어준다).
     * 4) 기존 head의 다음 요소가 있었다면 다음 요소가 head가 될것이므로
     *    해당 요소의 prev 도 끊어준다(null을 넣어준다).
     * 5) 다음 요소를 head로 선정해준다.
     * 6) size를 1 감소한다.
     * 7) 만약 size가 0이라면, 즉 Deque에 요소가 하나였다면 tail로 연결된 것도 끊어준다.
     */

    public E popFirst() {
        if(size == 0) {
            return null;
        }

        E elem = head.value; // pop 할 값
        Element<E> nextElem = head.next; // head 다음 element

        head.value = null;
        head.next = null;
        head = null;

        if(nextElem != null) {
            nextElem.prev = null;
        }

        head = nextElem;
        size--;

        if(size == 0) {
            tail = null;
        }

        return elem;
    }

    /*
     * @function popLast
     * 
     * 1) Deque이 비어있다면 null을 return한다.
     * 그렇지 않다면,
     * 2) tail의 요소 값, 다음 값을 확인한다.
     * 3) tail이 가리키는 요소들을 모두 끊어낸다(null을 넣어준다).
     * 4) 기존 tail의 이전 요소가 있었다면 이전 요소가 tail이 될것이므로
     *    해당 요소의 next 도 끊어준다(null을 넣어준다).
     * 5) 이전 요소를 tail로 선정해준다.
     * 6) size를 1 감소한다.
     * 7) 만약 size가 0이라면, 즉 Deque에 요소가 하나였다면 head로 연결된 것도 끊어준다.
     */

    public E popLast() {
        if(size == 0) {
            return null;
        }

        E elem = tail.value; // pop 할 값
        Element<E> prevElem = tail.prev; // tail 이전 element

        tail.value = null;
        tail.prev = null;
        tail = null;

        if(prevElem != null) {
            prevElem.next = null;
        }

        tail = prevElem;
        size--;

        if(size == 0) {
            head = null;
        }

        return elem;
    }

    /*
     * @function peekFirst
     * 
     * @return  Deque가 비어있다면 null, 아니면 head의 값을 return
     */

    public E peekFirst() {
        if(size == 0) return null;

        return head.value;
    }

    /*
     * @function peekLast
     * 
     * @return  Deque가 비어있다면 null, 아니면 tail의 값을 return
     */

    public E peekLast() {
        if(size == 0) return null;

        return tail.value;
    }

    /*
     * @function addOne
     * 
     * 해당 함수는 Deque의 size가 0일 떄만 사용한다.
     * 1) 비어있는 Deque에 한 요소를 추가할 때는 head와 tail 모두 해당 요소를 가리키게 해야한다.
     *    따라서 head = elem, tail = elem
     * 2) 그 후 size를 증가시켜준다.
     */

    public void addOne(E value) {
        Element<E> elem = new Element<E>(value);
        head = elem;
        tail = elem;
        size++;
    }

    /*
     * @function    size
     * @return      size의 값을 반환한다.
     */

    public int size() {
        return size;
    }

    /*
     * @function    empty
     * @return      size의 값이 0인지 아닌지 반환한다.
     */
    
    public boolean empty() {
        return size == 0;
    }
}

/*
 * @class   Element
 * 
 * E value : Element의 값을 나타낸다.
 * Element<E> next : 다음 요소를 가리킨다.
 * Element<E> prev : 이전 요소를 가리킨다.
 */
class Element<E> {
    E value;
    Element<E> next;
    Element<E> prev;

    Element(E value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
