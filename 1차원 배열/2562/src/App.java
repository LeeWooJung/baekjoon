import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // 변수 설정
        int max = -1;
        int N = 9;
        int order = -1;
        int val;

        // Scanner 설정
        Scanner sc = new Scanner(System.in);

        for(int idx = 1; idx <= N; idx ++){
            val = sc.nextInt();
            if(val > max){
                order = idx;
                max = val;
            }
        }

        System.out.println(max);
        System.out.println(order);

        sc.close();
    }
}
