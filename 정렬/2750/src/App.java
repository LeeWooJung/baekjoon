import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class App {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N;
        int element;
        int[] array = new int[1000];
        
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 원소 개수 입력
        N = Integer.parseInt(st.nextToken());
        // 배열 요소 입력
        for(int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());
            element = Integer.parseInt(st.nextToken());
            array[idx] = element;
        }

        // Insertion Sort로 배열을 오름차순으로 정렬.
        InsertionSort(array, N);

        // 출력
        for(int idx = 0; idx < N; idx++){
            System.out.println(array[idx]);
        }
    }

    /*
     * Insertion Sort
     * @param int[] array   : 정렬할 배열
     * @param int size      : 정렬할 배열의 크기
     * 
     * Insertion Sort
     * - 비교 정렬, 안정 정렬
     * - In Place Sort
     */

    public static void InsertionSort(int[] array, int size){

        /*
         * 배열의 두 번째에 존재하는 값부터 비교를 시작한다.
         */

        for(int index = 1; index < size; index++){
            int target = array[index];
            int toCompare_index = index - 1; // 비교하려는 인덱스

            /*
             * target값과 그 앞에 존재하는 값들을 순차적으로 비교한다.
             * target값이 비교하려는 값보다 크다면 while문을 빠져나온다.
             * target값이 비교하려는 값보다 작다면 비교하려는 값을 뒤로 한 칸 미룬다.
             */
            while(toCompare_index >= 0 && target < array[toCompare_index]){
                array[toCompare_index + 1] = array[toCompare_index];
                toCompare_index--;
            }

            array[toCompare_index + 1] = target;
        }
    }
}
