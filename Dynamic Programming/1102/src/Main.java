import java.io.*;
import java.util.*;

public class Main {

    static int N, P;
    static int[][] costs;
    static int[][] dp;
    static int max = 36*16 + 1;
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        costs = new int[N][N];

        dp = new int[N+1][1 << 16];

        for(int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());

            Arrays.fill(dp[row], -1);

            for(int col = 0; col < N; col++) {
                costs[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.fill(dp[N], -1);

        String onOff = br.readLine();
        P = Integer.parseInt(br.readLine());


        int onOffs = 0;
        int onCount = 0;

        for(int machine = 0; machine < N; machine++) {
            if(onOff.charAt(machine) == 'Y') {
                onOffs = onOffs | (1 << machine);
                onCount++;
            }
        }

        int answer = solve(onCount, onOffs);
        if(answer == max) answer = -1;

        System.out.println(answer);
    }

    static int solve(int onCount, int onOffs) {

        if(onCount >= P) return 0;

        if(dp[onCount][onOffs] != -1) return dp[onCount][onOffs];
        dp[onCount][onOffs] = max;

        for(int m1 = 0; m1 < N; m1++) {

            if((onOffs & (1 << m1)) == 0) continue; // m1 off

            for(int m2 = 0; m2 < N; m2++) {

                if((onOffs & (1 << m2)) > 0 || m1 == m2) continue; // m2 on OR m1 == m2

                dp[onCount][onOffs] = Math.min(dp[onCount][onOffs], solve(onCount + 1, onOffs | (1 << m2)) + costs[m1][m2]);
            }
        }

        return dp[onCount][onOffs];
    }
}
