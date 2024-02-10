import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.HashMap;


public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int N, val, freq;
        int[] sequence;
        int[] frequency;
        int[] result;
        ArrayDeque<Integer> idxStack = new ArrayDeque<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // N 입력
        N = Integer.parseInt(br.readLine());
        sequence = new int[N];
        frequency = new int[N];
        result = new int[N];
        // 수열 입력
        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < N ; idx++) {
            val = Integer.parseInt(st.nextToken());
            sequence[idx] = val;

            // HashMap을 이용하여 중복되는 수 count
            if(!hashMap.containsKey(val)) {
                hashMap.put(val, 1);
            } else {
                hashMap.put(val, hashMap.get(val) + 1);
            }
        }
        // frequency 입력
        for(int idx = 0; idx < N; idx++) {
            frequency[idx] = hashMap.get(sequence[idx]);
        }

        // 오큰수와 같이 stack을 활용.
        for(int idx = 0; idx < N; idx++) {
            freq = frequency[idx];
            while(!idxStack.isEmpty()) {
                if(freq > frequency[idxStack.peek()]) {
                    result[idxStack.pop()] = sequence[idx];
                } else break;
            }
            idxStack.push(idx);
        }
        
        while(!idxStack.isEmpty()) {
            result[idxStack.pop()] = -1;
        }

        for(int idx = 0; idx < N; idx++) {
            sb.append(result[idx] + " ");
        }

        System.out.println(sb.toString());
    
    }
}
