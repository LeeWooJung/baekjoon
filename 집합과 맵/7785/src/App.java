import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int N;
        String name, comeNgo;

        Map<String, Integer> employee = new TreeMap<>((employee1, employee2) -> {
            return -employee1.compareTo(employee2);
        });
/*
        Map<String, Integer> employee = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String employee1, String employee2) {
                return -employee1.compareTo(employee2);
            }
        });
*/
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // N 입력
        N = Integer.parseInt(br.readLine());

        // Employee 출입 기록
        for(int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            comeNgo = st.nextToken();
            if(comeNgo.equals("enter")) {
                employee.put(name, 0);
            } else if(comeNgo.equals("leave")) {
                if(!employee.containsKey(name)) continue;
                employee.remove(name);
            }
        }

        // Iterator를 이용한 결과 출력
        Iterator<Map.Entry<String, Integer>> person = employee.entrySet().iterator();
        while(person.hasNext()) {
            sb.append(person.next().getKey() + "\n");
        }

        System.out.print(sb);
    }
}
