import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class topDown {
    static int[] sequence;
    static int[] dpIncrease;
    static int[] dpReverseIncrease;

    public static void main(String[] args) throws IOException {

        // 변수 설정
        int N;
        int maximum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        N = Integer.parseInt(br.readLine());

        sequence = new int[N];
        dpIncrease = new int[N];
        dpReverseIncrease = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
            dpIncrease[i] = -1;
            dpReverseIncrease[i] = -1;
        }

        // 각 위치에서 최대 증가 부분 수열의 길이의 합 중 최댓값을 찾음
        for (int i = 0; i < N; i++) {
            maximum = Math.max(maximum, findIncrease(i) + findReverseIncrease(i) - 1);
        }

        System.out.println(maximum);

        br.close();
    }

    // 정방향 최대 증가 부분 수열의 길이를 구하는 함수
    static int findIncrease(int index) {
        if (dpIncrease[index] != -1) {
            return dpIncrease[index];
        }

        dpIncrease[index] = 1; // 초기값 설정
        for (int i = 0; i < index; i++) {
            if (sequence[i] < sequence[index]) {
                dpIncrease[index] = Math.max(dpIncrease[index], findIncrease(i) + 1);
            }
        }

        return dpIncrease[index];
    }

    // 역방향 최대 증가 부분 수열의 길이를 구하는 함수
    static int findReverseIncrease(int index) {
        if (dpReverseIncrease[index] != -1) {
            return dpReverseIncrease[index];
        }

        dpReverseIncrease[index] = 1; // 초기값 설정
        for (int i = index + 1; i < sequence.length; i++) {
            if (sequence[i] < sequence[index]) {
                dpReverseIncrease[index] = Math.max(dpReverseIncrease[index], findReverseIncrease(i) + 1);
            }
        }

        return dpReverseIncrease[index];
    }
}
