import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // 변수 설정
        int N;
        double score;
        double avg = 0.0;
        double max = 0.0;
        double[] scores;

        // Scanner
        Scanner sc = new Scanner(System.in);

        // N 입력
        N = sc.nextInt();

        // 배열 길이 확정
        scores = new double[N];

        // 점수 저장 및 최댓값 확인
        for(int idx = 0; idx < N; idx++){
            score = sc.nextDouble();
            scores[idx] = score;
            if(score > max) max = score;
        }

        // 점수 조작 및 총합 구하기
        for(int idx = 0; idx < N; idx++){
            scores[idx] = scores[idx]/max * 100;
            avg += scores[idx];
        }

        // 평균 출력
        System.out.printf("%f", avg/N);

    }
}
