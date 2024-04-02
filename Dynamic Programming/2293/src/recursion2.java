import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class recursion2 {
    
    static int[] values;
    static int[][] memoization;
    public static void main(String[] args) throws Exception, IOException {

        // 변수 설정
        int n,k;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        values = new int[n];
        memoization = new int[n][k+1];

        for(int idx = 0; idx < n; idx++) {
            values[idx] = Integer.parseInt(br.readLine());
            for(int val = 0; val <= k; val++) {
                memoization[idx][val] = -1; // initialization
            }
        }

        System.out.println(recursiveCount(n-1, k)); // last coin 부터 시작
        br.close();
    }

    static int recursiveCount(int index, int remain) {
        if(remain == 0) return 1; // remain이 0으로 딱 떨어지는 경우
        if(remain < 0 || index < 0) return 0;
        if(memoization[index][remain] != -1) return memoization[index][remain];

        /*
         * recursiveCount(index-1, remain) : 이전 동전 선택
         * recursiveCount(index, remain - values[index]) : 현재 동전 선택
         */
        memoization[index][remain] = recursiveCount(index-1, remain) + recursiveCount(index, remain - values[index]);
        return memoization[index][remain];
    }
}
