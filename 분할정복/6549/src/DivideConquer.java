import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

/* 
 * Divide & Conquer
 * 
 * 2 / 1 / 4 / 5 / 1 / 3 / 3
 * 
 * 2 1 max(1, 2, 1*2) / 4 5 max(4, 5, 4*2) / 1 3 max(1, 3, 1*2) / 3 (3*1)
 * 
 * 2 1 4 5 max(1*4, 4*2) / 1 3 3 max(1*3, 3*2)
 * 
 * ...
 */

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int n;
        long[] h;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            h = new long[n];
            for(int t = 0; t < n; t++) {
                h[t] = Long.parseLong(st.nextToken());
            }

            sb.append(divide(h, 0, n-1)).append("\n");
        }

        System.out.print(sb.toString());
    }

    static long divide(long[] h, int left, int right) {

        if(left == right) return h[left];

        int mid = (left + right) / 2;

        long max = Math.max(divide(h, left, mid), divide(h, mid+1, right));

        max = Math.max(max, getTotMax(h, left, mid, right));

        return max;
    }

    static long getTotMax(long[] h, int left, int mid, int right) {

        long height = h[mid];
        long max = h[mid];

        int goLeft = mid, goRight = mid;

        while(left < goLeft && goRight < right) {

            if(h[goLeft - 1] > h[goRight + 1]) {
                goLeft--;
                height = Math.min(height, h[goLeft]);
            } else {
                goRight++;
                height = Math.min(height, h[goRight]);
            }

            max = Math.max(max, (goRight - goLeft + 1) * height);
        }

        while(left < goLeft) {
            goLeft--;
            height = Math.min(height, h[goLeft]);
            max = Math.max(max, (goRight - goLeft + 1) * height);
        }

        while(right > goRight) {
            goRight++;
            height = Math.min(height, h[goRight]);
            max = Math.max(max, (goRight - goLeft + 1) * height);
        }

        return max;
    }
}
