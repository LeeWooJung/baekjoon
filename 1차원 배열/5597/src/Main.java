import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // 변수 설정
        int yes = 28;
        int index;
        boolean[] student = new boolean[31];

        // Scanner
        Scanner sc = new Scanner(System.in);

        for(int t = 0; t < yes; t++){
            // 제출한 학생들 번호 입력
            index = sc.nextInt();
            // 해당 학생들 값 true로 변경.
            student[index] = true;
        }

        for(int idx = 1; idx < 31; idx++){
            // 제출하지 않은 학생들 번호 순으로 출력.
            if(!student[idx]) System.out.println(idx);
        }

        sc.close();


    }
}
