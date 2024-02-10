import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int N = 5;
        int avg = 0;
        int midium;
        int[] array = new int[N];

        // Buffered Reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < N; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[t] = Integer.parseInt(st.nextToken());
            avg += array[t];
        }

        SelectionSort(array, N);
        midium = array[N/2];
        avg = avg / N;

        System.out.println(avg);
        System.out.println(midium);

    }

    /*
     * @function SelectionSort
     * @param   array     정렬할 배열
     * @param   size        배열의 크기
     * 
     * Selection Sort
     * - 비교 정렬
     * - In Place Sort
     * - 불안정 정렬
     */

    public static void SelectionSort(int[] array, int size){
        int min_idx; // 최소 값이 존재하는 인덱스를 나타내는 변수
        int toChange_idx; // 찾은 최솟값을 넣을 위치 인덱스를 나타내는 변수
        int search_idx; // 배열을 훑을 인덱스를 나타내는 변수

        for(toChange_idx = 0; toChange_idx < size - 1; toChange_idx++){
            min_idx = toChange_idx;

            for(search_idx = toChange_idx + 1; search_idx < size; search_idx++){
                if(array[search_idx] < array[min_idx]){
                    min_idx = search_idx;
                }
            }

            swap(array, min_idx, toChange_idx); // 최솟값을 toChange_idx의 값과 교환
        }
    }

    private static void swap(int[] array, int min_idx, int change_idx){
        int temp = array[min_idx];
        array[min_idx] = array[change_idx];
        array[change_idx] = temp;
    }
}
