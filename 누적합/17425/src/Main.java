import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int T, N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        long[] cumSum = getDivisors();

        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            sb.append(cumSum[N]).append("\n");
        }

        System.out.print(sb.toString());
    }

    static long[] getDivisors() {
        long[] divisorsSum = new long[1000001];
        long[] cumSum = new long[1000001];
        
        Arrays.fill(divisorsSum, 1);

        for(int x = 2; x < 1000001; x++) {
            for(int y = 1; x * y < 1000001; y++) {
                divisorsSum[x*y] += x; // sum of divisor of x * y
            }
        }

        for(int number = 1; number < 1000001; number++) {
            cumSum[number] = cumSum[number-1] + divisorsSum[number];
        }

        return cumSum;
    }
}
