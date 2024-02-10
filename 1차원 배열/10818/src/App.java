import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // 변수 설정
        int N;
        int val;
        int max = -1000001;
        int min = 1000001;

        // Scanner
        Scanner sc = new Scanner(System.in);

        // N 값 입력
        N = sc.nextInt();
        
        // 읽은 값 비교
        for(int idx = 0; idx < N; idx++){
            val = sc.nextInt();
            if(val > max){
                max = val;
            }
            if(val < min){
                min = val;
            }
        }

        System.out.println(min + " " + max);

        sc.close();
    }
}
