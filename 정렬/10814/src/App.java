import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class App {

    /*
     * @class   Member
     * @implements  Comparable<T> - T : Member
     * 
     * compareTo
     * - Comparable 인터페이스의 compareTo를 오버라이딩한다.
     * 1) 나이를 오름차순으로 정렬한다.
     * 2) 나이가 같을 경우 입력된 순서대로 정렬한다.
     */
    static class Member implements Comparable<Member> {
        int age;
        String Name;
        int order;

        public Member(int age, String Name, int order) {
            super();
            this.age = age;
            this.Name = Name;
            this.order = order;
        }

        @Override
        public int compareTo(Member person) {

            if(this.age > person.age) {
                return 1;
            } else if(this.age < person.age) {
                return -1;
            } else {
                return this.order > person.order ? 1 : -1;
            }
        }

        @Override
        public String toString() {
            return this.age + " " + this.Name + "\n";
        }
    }
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int N;
        Member[] members;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // N 입력
        N = Integer.parseInt(br.readLine());
        // members 선언
        members = new Member[N];
        // members 입력
        for(int t = 0; t < members.length; t++) {
            st = new StringTokenizer(br.readLine(), " ");

            int tmp_age = Integer.parseInt(st.nextToken());
            String tmp_Name = st.nextToken();

            members[t] = new Member(tmp_age, tmp_Name, t);
        }
        // Sort
        Arrays.sort(members);
        // BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 정답 출력
        for(int idx = 0; idx < members.length; idx++) {
            bw.write(members[idx].toString());
        }
        bw.flush();
        bw.close();
    }
}
