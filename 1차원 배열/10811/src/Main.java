import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        // 변수 설정
        int N, M;
        int left, right;
        int temp;
        int[] basket;

        // Scanner
        Scanner sc = new Scanner(System.in);

        // N, M 입력
        N = sc.nextInt();
        M = sc.nextInt();
        // basket 길이 확정 - 주어진 바구니 번호 그대로 이용할 예정
        basket = new int[N+1];

        // basket에 번호 입력
        for(int idx = 1; idx <= N; idx++){
            basket[idx] = idx;
        }

        for(int t = 0; t < M; t++){
            // 역순으로 바꿀 left, right 값 입력
            left = sc.nextInt();
            right = sc.nextInt();

            while(left < right){ // 아이패드 그림으로 표현하기
                temp = basket[left];
                basket[left++] = basket[right];
                basket[right--] = temp;
            }
        }

        for(int idx = 1; idx < N; idx++){
            System.out.print(basket[idx] + " ");
        }
        System.out.print(basket[N]);



        sc.close();


    }
}
