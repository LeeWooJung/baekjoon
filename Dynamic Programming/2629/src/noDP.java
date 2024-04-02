import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class noDP {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int numWeights;
        int numBalls;
        final int maxBallWeights = 40000;
        boolean[] checkRange = new boolean[maxBallWeights + 1];

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // 변수 입력
        numWeights = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < numWeights; t++) {
            int weight = Integer.parseInt(st.nextToken());
            Map<Integer, Integer> added = new HashMap<>();
            
            for(int canCheckWeight = 1; canCheckWeight <= maxBallWeights; canCheckWeight++) {
                if(!checkRange[canCheckWeight]) continue;
                if(added.containsKey(canCheckWeight)) continue;

                int sum = weight + canCheckWeight;
                int diff = Math.abs(weight - canCheckWeight);

                if(sum <= maxBallWeights && !checkRange[sum]) {
                    checkRange[sum] = true;
                    added.put(sum, null);
                }
                if(diff <= maxBallWeights && !checkRange[diff]) {
                    checkRange[diff] = true;
                    added.put(diff, null);
                }
            }

            checkRange[weight] = true;
        }

        
        numBalls = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < numBalls; t++) {
            int ballWeight = Integer.parseInt(st.nextToken());
            if(checkRange[ballWeight]) sb.append("Y ");
            else sb.append("N ");
        }

        System.out.println(sb.toString());
        br.close();
    }
}
