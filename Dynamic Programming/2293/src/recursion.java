import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

/*
 * 시간 초과. 참고용으로만 사용.
 */

public class recursion {
    
    static int[] values;
    static int n, k;
    public static void main(String[] args) throws Exception, IOException {

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        values = new int[n];

        for(int idx = 0; idx < n; idx++) {
            values[idx] = Integer.parseInt(br.readLine());
        }

        System.out.println(recursiveCount(k, 0));
        br.close();
    }

    static int recursiveCount(int remain, int index) {
        if(remain == 0) return 1;
        if(remain < 0 || index >= n) return 0;
        return recursiveCount(remain, index+1) + recursiveCount(remain - values[index], index);
    }
}
