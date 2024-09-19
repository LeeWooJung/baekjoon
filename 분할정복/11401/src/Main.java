import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N, K;
        long mod = 1000000007; 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        
        // Fermat's little Theorem
        // a (mod 1000000007) 의 역원 : a^(1000000007-2) (mod 1000000007)
        long upper = factorial(N, mod);
        long lower = factorial(K, mod) * factorial(N-K, mod) % mod;

        System.out.println(upper * reverse(lower, mod - 2, mod) % mod);

    }

    static long reverse(long value, long exp, long mod) {

        if(exp == 1) return value % mod;

        long half = reverse(value, exp / 2, mod);

        if(exp % 2 == 1) return (half * half % mod) * value % mod;
        return half * half % mod;
    }

    static long factorial(int val, long mod) {

        long res = 1;

        while(val > 1) {
            res = (res * val--) % mod;
        }

        return res;
    }
}
