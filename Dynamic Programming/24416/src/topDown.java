import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class topDown {

    static int[] memoization;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int n;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        n = Integer.parseInt(br.readLine());
        memoization = new int[n+1];

        // 문제 해결
        System.out.println(fibonacci(n) + " " + (n-2));

        br.close();
    }

    static int fibonacci(int n) {
        if(n <= 1) return n;

        if(memoization[n] != 0) return memoization[n]; // memoization
        
        memoization[n] = fibonacci(n-1) + fibonacci(n-2);
        return memoization[n];
    }
}
