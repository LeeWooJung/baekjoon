import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        // 변수 설정
        int N, M;
        int start, end, Number;
        int[] basket;

        // Scanner
        Scanner sc = new Scanner(System.in);

        // N, M 값 입력
        N = sc.nextInt();
        M = sc.nextInt();

        // 바구니 길이 확정
        basket = new int[N];

        // 바구니에 M 번 공 넣기
        for(int n = 0; n < M; n++){
            // 시작, 끝, 공 번호 입력
            start = sc.nextInt() - 1; // 인덱스는 0부터 시작
            end = sc.nextInt() - 1;
            Number = sc.nextInt();

            for(int index = start; index <= end; index++){
                basket[index] = Number;
            }
        }

        for(int index = 0; index < N - 1; index++){
            System.out.print(basket[index] + " ");
        }
        System.out.print(basket[N-1]);

        sc.close();

    }
}
