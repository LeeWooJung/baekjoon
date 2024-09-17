import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N;
        long k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        k = Long.parseLong(br.readLine());

        long left = 1, right = k;

        while(left < right) { // if left == right then quit
            long cnt = 0;
            long mid = (left + right) / 2;

            for(int num = 1; num <= N; num++) {
                cnt += mid / num > N ? N : mid / num;
            }

            if(cnt >= k) { // lower bound
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);

    }
}
