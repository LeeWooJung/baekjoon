import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class TopDown {

    static int N, K;
    static String[] seq;
    static long[][] seqModsCount; // 수열을 조합하면서 나머지의 개수 저장
    static int[][] selectedNumMods; // 선택된 수를 마지막에 추가했을 때의 나머지 저장

    public static void main(String[] args) throws Exception, IOException {

        // 변수 설정
        long count;
        long facN;

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
        facN = factorial(N);
        /*
         * 1 << N: BitMask - 선택된 수들로 이루어진 수열
         * K : 선택된 수들로 만들어진 수를 K로 나누었을 때 나머지
         */
        seqModsCount = new long[K][1 << N];
        selectedNumMods = new int[K][N]; // N 번째수가 선택 됐을 때의 나머지 저장

        for(long[] mod : seqModsCount) Arrays.fill(mod, -1);
        for(int[] mod : selectedNumMods) Arrays.fill(mod, -1);

        count = dp(0, 0);
        if(count == 0) System.out.println("0/1");
        else {
            long gcd = EuclideanGCD(count, facN);
            System.out.println(count/gcd + "/" + facN/gcd);
        }

        br.close();
    }

    static long dp(int mod, int combination) {

        // 이미 구한 경우 return. Memoization
        if(seqModsCount[mod][combination] != -1) return seqModsCount[mod][combination];
        // 모든 수를 이어 붙인 경우 나머지가 0이면 count 1 증가
        if(combination == (1 << N) - 1) return mod == 0 ? 1 : 0;

        long count = 0;
        for(int index = 0; index < N; index++) {
            /*
             * index에 위치한 수를 확인하지 않은 경우
             * 해당 수를 수열의 맨 마지막에 추가했을 때의 나머지(mod)를 구하고 - Mod()
             * 다음으로 추가할 수를 확인 (dp recursive)
             */
            if((combination & (1 << index)) == 0) {
                count += dp(Mod(mod, index), combination | (1 << index));
            }
        }

        return seqModsCount[mod][combination] = count;
    }

    static int Mod(int mod, int index) {
        // index에 위치한 수에 대한 나머지를 이미 구했으면 return - Memoization
        if(selectedNumMods[mod][index] != -1) return selectedNumMods[mod][index];

        int temp = mod;
        for(int t = 0; t < seq[index].length(); t++) {
            temp *= 10;
            temp += (seq[index].charAt(t) - '0');
            temp %= K;
        }
        // index에 위치한 수를 마지막에 추가했을 때의 나머지 return
        return selectedNumMods[mod][index] = temp;
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
