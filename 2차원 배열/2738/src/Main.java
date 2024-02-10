import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //변수 설정
        int N, M;
        int numMatrix = 2;
        int[][] array;

        // Scanner
        Scanner sc = new Scanner(System.in);

        // N, M 입력
        N = sc.nextInt();
        M = sc.nextInt();

        // 이차원 배열 길이 확정
        array = new int[N][M];

        // 두 개의 행렬에 해당하는 원소 값들 바로 더해주기
        for(int t = 0; t < numMatrix; t++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    array[i][j] += sc.nextInt();
                }
            }
        }

        // 결과 출력
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M-1; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println(array[i][M-1]);
        }



        sc.close();
    }
}
