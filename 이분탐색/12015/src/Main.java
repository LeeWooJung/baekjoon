import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N;
        int maxlen = 1;
        int[] arr;
        int[] lis;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        lis = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int t = 0; t < N; t++) {
            arr[t] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];

        for(int t = 1; t < N; t++) {

            if(lis[0] > arr[t]) lis[0] = arr[t];
            else if(lis[maxlen-1] < arr[t]) {
                lis[maxlen++] = arr[t];
            } else {
                int index = binarySearch(0, maxlen, arr[t], lis);
                lis[index] = arr[t];
            }
        }

        System.out.println(maxlen);

    }

    static int binarySearch(int left, int right, int value, int[] array) {

        while(left < right) {

            int mid = (left + right) / 2;

            if(array[mid] < value) { // lower bound
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
