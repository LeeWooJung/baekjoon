import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N, M, L;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        ArrayList<Integer> rests = new ArrayList<>();
        rests.add(0);
        rests.add(L);

        int l = 1;
        int r = 1;

        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < N; t++) {
            int loc = Integer.parseInt(st.nextToken());
            rests.add(loc);
        }
        
        Collections.sort(rests);

        for(int t = 1; t < N+2; t++) {
            r = Math.max(rests.get(t) - rests.get(t-1), r);
        }

        while(l < r) { // lower bound
            int count = 0;
            int mid = (l + r) / 2;

            for(int index = 1; index < N+2; index++) {
                count += (rests.get(index) - rests.get(index-1) - 1) / mid;
            }

            if(count > M) { // 구간 길이 증가
                l = mid + 1;
            } else { // 구간 길이 감소
                r = mid;
            }
        }

        System.out.println(r);

    }
}
