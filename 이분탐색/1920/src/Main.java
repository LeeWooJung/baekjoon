import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    static int[] arr;
    public static void main(String[] args) throws Exception, IOException {
        
        int N, M;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < N; t++) {
            arr[t] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while(M-- > 0) {
            int toFind = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(toFind)).append('\n');
        }

        System.out.print(sb.toString());
    }

    static int binarySearch(int toFind) {

        int l = 0, r = arr.length -1;

        while(l <= r) {
            int mid = (l + r) / 2;

            if(arr[mid] == toFind) {
                return 1;
            } else if(arr[mid] > toFind){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return 0;
    }
}
