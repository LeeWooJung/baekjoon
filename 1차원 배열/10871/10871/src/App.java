import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // 변수 설정
        int N;
        int X;
        int val;
        int freq = 0;
        int[] A;

        // 스캐너 설정
        Scanner sc = new Scanner(System.in);

        // N, X 값 입력
        N = sc.nextInt();
        X = sc.nextInt();

        // 배열 사이즈 확정
        A = new int[N];

        // X보다 작은 val만 A에 넣어주고 freq 증가.
        for(int idx = 0; idx < N; idx++){
            val = sc.nextInt();
            if(val < X){
                A[freq] = val;
                freq++;
            }
        }

        // 답 출력
        for(int idx = 0; idx < freq; idx++){
            System.out.print(A[idx]);
            if(idx < freq - 1) System.out.print(" ");
        }

        sc.close();
    }
}
