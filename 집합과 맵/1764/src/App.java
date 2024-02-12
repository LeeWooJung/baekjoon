import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception, IOException {

        // 변수 설정
        int N, M;
        int count = 0;
        String name;
        Map<String, Integer> members = new TreeMap<>();
        Map<String, Integer> duplicated = new TreeMap<>(
            (member1, member2) -> {
                return member1.compareTo(member2);
            }
        );

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder
        StringBuilder sb = new StringBuilder();
        // StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람 입력
        for(int t = 0; t < N; t++) {
            name = br.readLine();
            members.put(name, 0);
        }
        /*
         * 보도 못한 사람 확인
         * - 듣도 못한 사람에 존재한다면 count를 증가 시키고, duplicated에 넣어줌.
         */
        for(int t = 0; t < M; t++) {
            name = br.readLine();
            if(members.containsKey(name)) {
                count++;
                duplicated.put(name, 0);
            }
        }

        sb.append(count + "\n");
        Iterator<Map.Entry<String, Integer>> person = duplicated.entrySet().iterator();
        while(person.hasNext()) {
            sb.append(person.next().getKey() + "\n");
        }
        System.out.print(sb);
    }
}
