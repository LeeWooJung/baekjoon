import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        //변수
        int N, k;
        int[] array;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, k 값 입력
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 배열 선언
        array = new int[N];
        
        // 점수 입력
        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < N; idx++){
            array[idx] = Integer.parseInt(st.nextToken());
        }

        // Bubble Sort - 내림차순 정렬
        BubbleSort(array, N);

        System.out.println(array[k-1]);
    }

    /*
     * @function    BubbleSort
     * @param array 정렬할 배열
     * @param size  배열의 길이
     * 
     * Bubble Sort
     * - 비교 정렬
     * - In Place Sort
     * - 안정 정렬
     */

    private static void BubbleSort(int[] array, int size){
        for(int round = 1; round < size; round++){
            for(int idx = 0; idx < size - round; idx++){
                if(array[idx] < array[idx + 1]){
                    swap(array, idx, idx+1);
                }
            }
        }
    }

    private static void swap(int[] array, int front, int back){
        int temp = array[front];
        array[front] = array[back];
        array[back] = temp;
    }
}
