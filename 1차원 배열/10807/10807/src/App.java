import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        // 변수 설정
        int N;
        int v;
        int freq = 0;
        int arrVal;
        int[] array;

        // Scanner 설정
        Scanner sc = new Scanner(System.in);

        // N 값 받기
        N = sc.nextInt();

        if(N < 1 || N > 100){
            sc.close();
            return;
        }

        // array 길이 확정
        array = new int[N];

        // array value 받기
        for(int idx = 0; idx < N; idx++){
            arrVal = sc.nextInt();
            array[idx] = arrVal;
        }

        // 찾고자 하는 값(v) 받기
        v = sc.nextInt();

        // 인덱스 처음부터 시작해서 array에 v와 같은 값 저장되어 있는지 확인
        for(int idx = 0; idx < N; idx++){
            if(array[idx] == v){
                freq++;
            }
        }

        System.out.println(freq);

        sc.close();

    }
}
