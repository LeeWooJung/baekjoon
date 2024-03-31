import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class lis {

    static int[] sequence;
    static int[] lisIncrease;
    static int[] lisReverseIncrease;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N;
        int maximum = 0;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        sequence = new int[N];
        lisIncrease = new int[N];
        lisReverseIncrease = new int[N];
        

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
            lisIncrease[i] = lisReverseIncrease[i] = 1;
        }

        lisInc();
        lisReverseInc();

        for(int i = 0; i < N; i++) {
            maximum = Math.max(lisIncrease[i] + lisReverseIncrease[i] - 1, maximum);
        }

        System.out.println(maximum);

        br.close();
    }

    static void lisInc() {
        int maxLength = 1;
        int[] lis = new int[sequence.length];
        lis[0] = sequence[0];

        for(int index = 1; index < sequence.length; index++) {
            if(lis[maxLength - 1] < sequence[index]) {
                lis[maxLength++] = sequence[index];

                lisIncrease[index] = maxLength;

            } else if(lis[0] > sequence[index]) {
                lis[0] = sequence[index];
            } else {
                int location = Arrays.binarySearch(lis, 0, maxLength, sequence[index]);
                location = location < 0 ? -(location + 1) : location;
                lis[location] = sequence[index];

                lisIncrease[index] = Math.max(lisIncrease[index], location + 1);
            }
        }
    }

    static void lisReverseInc() {
        int maxLength = 1;
        int[] lis = new int[sequence.length];
        lis[0] = sequence[sequence.length-1];

        for(int index = sequence.length - 2; index >= 0; index--) {
            if(lis[maxLength - 1] < sequence[index]) {
                lis[maxLength++] = sequence[index];

                lisReverseIncrease[index] = maxLength;

            } else if(lis[0] > sequence[index]) {
                lis[0] = sequence[index];
            } else {
                int location = Arrays.binarySearch(lis, 0, maxLength, sequence[index]);
                location = location < 0 ? -(location + 1) : location;
                lis[location] = sequence[index];

                lisReverseIncrease[index] = Math.max(lisReverseIncrease[index], location + 1);
            }
        }
    }
}
