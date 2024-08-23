import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N, M;
        int result = 0;
        int[][] arr;
        int[][] cumulatedSum;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        cumulatedSum = new int[N+1][N+1];

        for(int x = 1; x <= N; x++) {
            st = new StringTokenizer(br.readLine());
            for(int y = 1; y <= N; y++) {
                arr[x][y] = Integer.parseInt(st.nextToken());

                cumulatedSum[x][y] = arr[x][y] + cumulatedSum[x-1][y] + cumulatedSum[x][y-1] - cumulatedSum[x-1][y-1];
            }
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1, y1, x2, y2;
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            result = cumulatedSum[x2][y2] + cumulatedSum[x1-1][y1-1] - cumulatedSum[x2][y1-1] - cumulatedSum[x1-1][y2];

            sb.append(result).append('\n');
        }

        System.out.print(sb.toString());
    }
}
