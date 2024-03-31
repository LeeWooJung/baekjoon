import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class lis {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int N;
        int maxLength = 1;
        int[] array;
        int[] lis; // longest increasing subsequence

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        array = new int[N];
        lis = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < N; idx++) {
            array[idx] = Integer.parseInt(st.nextToken());
        }

        // longest increasing subsequence
        lis[0] = array[0];

        for(int index = 1; index < N; index++) {
            if(lis[maxLength - 1] < array[index]) { // larger than last lis element
                lis[maxLength++] = array[index];
            } else if(lis[0] > array[index]) { // change smallest element
                lis[0] = array[index];
            } else { // change element between smallest and largest
                // binarySearch : O(logN). if return negative value, it means -(location) -1
                int location = Arrays.binarySearch(lis, 0, maxLength, array[index]);
                location = location < 0 ? -(location + 1) : location;
                lis[location] = array[index];
            }
        }
        
        System.out.println(maxLength);

        br.close();
    }
}
