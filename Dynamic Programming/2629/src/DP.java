import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class DP {

    static int numWeights;
    static int numBalls;
    static int[] weightList;
    static boolean[][] dp;
    static final int maxBallWeights = 40000;
    public static void main(String[] args) throws Exception, IOException {
        
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // 변수 입력
        numWeights = Integer.parseInt(br.readLine());
        weightList = new int[numWeights];
        dp = new boolean[numWeights+1][maxBallWeights+1];

        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < numWeights; t++) {
            weightList[t] = Integer.parseInt(st.nextToken());
        }

        // Dynamic Programming
        recursion(0, 0);

        // 결과 출력
        numBalls = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < numBalls; t++) {
            if(dp[numWeights][Integer.parseInt(st.nextToken())]) sb.append("Y ");
            else sb.append("N ");
        }
        System.out.println(sb.toString());
    }

    static void recursion(int order, int canCheckWeights) {
        if(dp[order][canCheckWeights]) return; // 이미 구할 수 있는 걸 알 때
        dp[order][canCheckWeights] = true;

        if(order >= numWeights) return;

        recursion(order + 1, canCheckWeights + weightList[order]);
        recursion(order + 1, canCheckWeights);
        recursion(order + 1, Math.abs(canCheckWeights - weightList[order]));
    }
}
