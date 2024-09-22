import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.Stack;

/*
 * Stack
 */

public class stack {

    static long[] h;
    static Stack<Integer> indexes;
    
    public static void main(String[] args) throws Exception, IOException {
        
        int n;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            h = new long[n];
            indexes = new Stack<>();


            for(int t = 0; t < n; t++) {
                h[t] = Long.parseLong(st.nextToken());
            }

            sb.append(getMax()).append("\n");
        }

        System.out.print(sb.toString());
    }

    static long getMax() {

        long max = 0;

        for(int loc = 0; loc < h.length; loc++) {

            while(!indexes.isEmpty() && h[loc] <= h[indexes.peek()]) {

                int hIndex = indexes.pop();
                long height = h[hIndex];

                if(indexes.empty()) {
                    max = Math.max(max, (long)loc * height);
                } else {
                    max = Math.max(max, (long)(loc - 1 - indexes.peek()) * height);
                }

            }

            indexes.push(loc);
        }

        while(!indexes.isEmpty()) {

            long height = h[indexes.pop()];

            int width;
            if(indexes.isEmpty()) width = h.length;
            else width = h.length - indexes.peek() - 1;

            max = Math.max(max, (long)width * height);
        }


        return max;
    }

    
}
