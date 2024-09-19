import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        long A, B, C;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(divide(A, B, C));

    }

    static long divide(long val, long count, long mod) {

        if(count == 1) {
            return val % mod;
        }

        long res = divide(val, count / 2, mod);

        if(count % 2 == 0) {
            return res * res % mod ;
        } else {
            return (res * res % mod) * val % mod;
        }
    }
}
