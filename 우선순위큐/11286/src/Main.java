import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception,IOException {
        
        // 변수 설정
        int N, x;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        /*
         * Priority Queue Class
         * 
         * 기본적으로 주어지는 값을 우선순위로 보고,
         * 우선순위의 숫자가 작은 것이 우선순위가 높다고 판단함.
         */

         // 1) Comparator Interface의 compare method 구현
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                int absF = Math.abs(first);
                int absS = Math.abs(second);

                if(absF == absS) {
                    return first - second;
                }
                return absF - absS;
            }
        }
        );
        // 2) Lamba expression 구현
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((first, second) -> {
            int absF = Math.abs(first);
            int absS = Math.abs(second);

            if(absF == absS) return first - second;
            return absF - absS;
            }
        );

        while(N-- > 0) {
            x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(pq2.isEmpty()) sb.append("0\n");
                else sb.append(pq2.poll() + "\n");
            } else {
                pq2.offer(x);
            }
        }

        System.out.print(sb.toString());
    }   
}