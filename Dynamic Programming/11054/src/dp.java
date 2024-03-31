import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class dp {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N;
        int maximum = 0;
        int[] sequence;
        int[] dpIncrease;
        int[] dpReverseIncrease;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        sequence = new int[N];
        dpIncrease = new int[N];
        dpReverseIncrease = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
            dpIncrease[i] = dpReverseIncrease[i] = 1;
        }

        // Dynamic Programming
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(sequence[j] < sequence[i]) {
                    dpIncrease[i] = Math.max(dpIncrease[i], dpIncrease[j] + 1);
                }
            }
        }

        for(int i = N-1; i >= 0; i--) {
            for(int j = N-1; j > i; j--) {
                if(sequence[j] < sequence[i]) {
                    dpReverseIncrease[i] = Math.max(dpReverseIncrease[i], dpReverseIncrease[j] + 1);
                }
            }
        }

        for(int index = 0; index < N; index++) {
            maximum = Math.max(dpIncrease[index] + dpReverseIncrease[index] - 1, maximum);
        }

        System.out.println(maximum);

        br.close();
    }
}
