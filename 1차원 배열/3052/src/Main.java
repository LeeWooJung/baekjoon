import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        // 변수 설정
        int num;
        int count = 0;
        int chk = 10;
        boolean[] remain = new boolean[42];

        // scanner
        Scanner sc = new Scanner(System.in);

        // 주어진 값 입력 후 42로 나눈 나머지에 해당하는 인덱스에 true 넣기.
        for(int t = 0; t < chk; t++){
            num = sc.nextInt();
            remain[num % 42] = true;
        }

        // true로 되어 있는 인덱스 개수 확인
        for(int idx = 0; idx < 42; idx++){
            if(remain[idx]) count++;
        }

        System.out.println(count);



        sc.close();
    }
}
