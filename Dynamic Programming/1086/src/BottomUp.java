import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class BottomUp {

    static int N, K;
    static String[] seq;
    static long[][] dp;
    static int[][] modMemo;

    public static void main(String[] args) throws Exception, IOException {

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        seq = new String[N];

        for(int t = 0; t < N; t++) {
            seq[t] = br.readLine();
        }

        K = Integer.parseInt(br.readLine());

        // initialization
        dp = new long[1 << N][K];
        modMemo = new int[N][K];

        for(int[] arr : modMemo) {
            Arrays.fill(arr, -1);
        }

        // Dynamic Programming
        dp[0][0] = 1;

        for(int mask = 0; mask < (1 << N); mask++) {
            for(int mod = 0; mod < K; mod++) {
                for(int i = 0; i < N; i++) {
                    if((mask & (1 << i)) == 0) {
                        int newMod = getMod(mod, i);
                        dp[mask | (1 << i)][newMod] += dp[mask][mod];
                    }
                }
            }
        }

        long total = factorial(N);
        long valid = dp[(1 << N) - 1][0];
        long gcd = EuclideanGCD(valid, total);

        System.out.println((valid / gcd) + "/" + (total / gcd));
    }

    static int getMod(int mod, int index) {
        if(modMemo[index][mod] != -1) {
            return modMemo[index][mod];
        }

        int tempMod = mod;
        for(char c : seq[index].toCharArray()) {
            tempMod = (tempMod * 10 + (c - '0')) % K;
        }

        return modMemo[index][mod] = tempMod;
    }

    static long EuclideanGCD(long x, long y) {
        if(y == 0) return x;
        return EuclideanGCD(y, x % y);
    }

    static long factorial(int n) {
        long result = 1;
        for(int num = 2; num <= n; num++) {
            result *= num;
        }
        return result;
    }
}
