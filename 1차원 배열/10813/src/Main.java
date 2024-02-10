import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // 변수 설정
        int N, M;
        int[] basket;
        int front, back;
        int temp;

        // Scanner
        Scanner sc = new Scanner(System.in);

        // N, M 입력
        N = sc.nextInt();
        M = sc.nextInt();

        // basket 길이 확정
        basket = new int[N];
        // basket에 들어 있는 공 번호 입력
        for(int idx = 0; idx < N ; idx++){
            basket[idx] = idx + 1;
        }

        // M 번 바구니에 들어 있는 공 교환
        for(int t = 0; t < M; t++){
            // 바꿀 바구니 번호 입력
            front = sc.nextInt();
            back = sc.nextInt();
            // 바구니에 있는 공들 교환
            temp = basket[front-1];
            basket[front-1] = basket[back-1];
            basket[back-1] = temp;
        }

        for(int idx = 0; idx < N-1; idx++){
            System.out.print(basket[idx] + " ");
        }
        System.out.print(basket[N-1]);



        sc.close();
    }
}
