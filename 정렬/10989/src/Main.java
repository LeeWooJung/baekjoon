import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int N;
        int[] array;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        N = Integer.parseInt(br.readLine());

        // array 선언
        array = new int[N];

        for(int t = 0; t < N; t++){
            array[t] = Integer.parseInt(br.readLine());
        }

        // Quick Sort
        QuickSort(array, 0, array.length-1);

        // Buffered Writer
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 결과 출력
        for(int t = 0; t < N; t++){
            bw.write(Integer.toString(array[t]) + "\n");
        }
        bw.close();

    }

    /*
     * @function QuickSort
     * @param   array   정렬할 배열
     * @param   left     Quick Sort를 적용할 배열의 왼쪽 끝 인덱스
     * @param   right    Quick Sort를 적용할 배열의 오른쪽 끝 인덱스
     * 
     * Quick Sort (Pivot : Middle)
     * 
     * - Pivot을 기준으로 두 개의 배열로 나누어 좌측에는 pivot보다 작은 원소를 포함한 배열
     * - 우측에는 pivot 보다 크거나 같은 원소를 포함한 배열로 나누는 과정을 재귀적으로 반복하는 알고리즘
     * 
     * - Didvide & Conquer 알고리즘
     * - 균등하게 나뉘지 않을 수 있음
     * - 비교 정렬
     * - In Place Sort
     * - Unstable Sort
     */

    private static void QuickSort(int[] array, int left, int right){

        if(left >= right) return;

        int pivot_idx = partition(array, left, right);

        QuickSort(array, left, pivot_idx - 1);
        QuickSort(array, pivot_idx, right);
    }

    /*
     * @function partition
     * @param   array   분할하기 위한 배열(왼쪽은 pivot보다 작은 값, 오른쪽은 pivot보다 큰 값)
     * @param   left    분할하기 위한 배열의 맨 좌측 인덱스
     * @param   right   분할하기 위한 배열의 맨 우측 인덱스
     * 
     * partition
     * - Pivot을 중간에 있는 값으로 정하여 나눈다.
     * - 좌측
     * - 피벗보다 크거나 같은 값을 찾는다(좌측 인덱스를 1씩 증가시키면서).
     * - 우측
     * - 피벗보다 작거나 같은 값을 찾는다(우측 인덱스를 1씩 감소시키면서).
     * 위와 같이 찾았을 때 두 원소의 위치를 바꾼다.
     * 좌측 인덱스와 우측 인덱스가 교차될 때까지 반복하고, 교차되면 해당 기점을 다시 부분 배열로 나눈다.
     */

    private static int partition(int[] array, int left, int right){

        int pivot = array[(left + right)/2];

        while(left <= right) {

            while(array[left] < pivot) left++;
            while(array[right] > pivot) right--;

            if(left > right) break;
            swap(array, left++, right--);
        }

        return left;
    }

    private static void swap(int[] array, int first, int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
