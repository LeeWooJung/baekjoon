import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] numbers;
    static int[] ops = new int[4];

    static int MAX = -1000000000;
    static int MIN = 1000000000;
    public static void main(String[] args) throws Exception, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < N; t++) {
            numbers[t] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(numbers[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);

    }

    static void backtracking(int value, int count) {


        if(count == N) {
            MAX = MAX > value ? MAX : value;
            MIN = MIN < value ? MIN : value;
            return;
        }

        for(int index = 0; index < 4; index++) {

            if(ops[index] == 0) continue;

            ops[index]--;

            switch(index) {
                case 0: // +
                    backtracking(value + numbers[count], count + 1);
                    break;
                case 1: // -
                    backtracking(value - numbers[count], count + 1);
                    break;
                case 2: // x
                    backtracking(value * numbers[count], count + 1);
                    break;
                case 3: // /
                    backtracking((int)value / numbers[count], count + 1);
                    break;
            }

            ops[index]++;

        }
    }
}
