import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        long X, Y;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        long firstZ = 100 * Y / X;

        if(firstZ >= 99) {
            System.out.println(-1);
            return;
        }

        long secondZ = firstZ;

        long left = 0;
        long right = X;

        while(left < right) {
            long mid = (left + right) / 2;
            secondZ = 100 * (Y + mid) / (X + mid);

            if(firstZ == secondZ) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        System.out.println(left);

    }
}
