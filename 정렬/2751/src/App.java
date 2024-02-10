import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;


public class App {

    private static int[] sortedArray;

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
        sortedArray = new int[array.length];

        // array 입력
        for(int idx = 0; idx < N; idx++){
            array[idx] = Integer.parseInt(br.readLine());
        }

        // Merge Sort
        mergeSort_bottomUP(array, 0, array.length - 1);

        // BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정답 출력
        for(int idx = 0; idx < N; idx++){
            bw.write(Integer.toString(array[idx]) + "\n");
        }

        sortedArray = null;
        bw.close();


    }

    /*
     * @function    mergeSort_bottomUp()
     * @param array Merge Sort를 진행할 배열
     * @param start  array의 가장 왼쪽 index 값
     * @param end array의 가장 오른쪽 index 값
     * 
     * Merge Sort
     * - Divide & Conquer
     * - 비교 정렬
     * - 제자리 정렬(in place sort)
     * - 안정 정렬
     * 
     * Merge Sort Bottom Up
     * - 배열이 원소 모두로 쪼개졌다고 가정 하고 해당 부분 리스트들을 정렬 후
     * - 합치는 방향으로 진행하는 방법
     */

    private static void mergeSort_bottomUP(int[] array, int start, int end) {
        /*
         * 배열의 원소가 모두 쪼개졌다고 생각하고 병합하는 방법이기 때문에
         * 첫 부분 리스트들의 크기(size)는 1이다.
         * 또한, 인접한 부분 리스트들끼리 병합하기 때문에 size는 두 배씩 증가한다.
         */
        for(int size = 1; size <= end; size *= 2) {
            /*
             * 병합을 위해 left, mid, right 값을 구하는 과정
             * [--size--] [--size--] 와 같이 병합할 부분 리스트가 있을 때
             * left      mid       right 와 같이 인덱스를 설정해야한다.
             * 
             * 현재 Bottom Up 방식은 In Place Sort로 배열의 처음부터 진행해야 하므로
             * 왼쪽 인덱스 l = 0부터 시작하며 l은 배열의 마지막 end 보다 size 만큼 작아야한다.
             * 따라서 l은 end - size 보다 클 수 없다.
             * 
             * 또한 병합이 진행된 부분 리스트들은 건너 뛰어야 하므로 l의 값은 size * 2씩 증가해야한다.
             */
            for(int l = 0;  l <= end - size; l += size*2) {
                int left = l;
                int mid = l + size -1;
                int right = Math.min(l + size * 2 -1, end); // right의 값이 end를 넘어설 수 있다.
                merge(array, left, mid, right);
            }
        }
    }

    /*
     * @function merge
     * @param array Merge Sort를 진행할 배열.
     * @param left  병합을 시작할 부분의 첫 인덱스
     * @param mid   병합을 시작할 부분의 중간 인덱스
     * @param right 병합을 시작할 부분의 마지막 인덱스
     */
    private static void merge(int[] array, int left, int mid, int right){
        int l = left;
        int r = mid + 1;
        int idx = left; // sortedArray의 인덱스

        /*
         * l이 mid를 넘지 않고, r이 right을 넘지 않을 때까지
         * 두 부분의 array 값을 비교하여 작은 값을 sortedArray에 넣어준다.
         * 그 후 인덱스 값을 증가시킨다.
         */
        while(l <= mid && r <= right){
            if(array[l] <= array[r]){
                sortedArray[idx++] = array[l++];
            }
            else {
                sortedArray[idx++] = array[r++];
            }
        }

        /*
         * 왼쪽 부분리스트의 값들을 다 소진했을 경우
         * 오른쪽 부분리스트의 값을 순서대로 sortedArray에 넣어준다.
         */

        if(l > mid) {
            while(r <= right) {
                sortedArray[idx++] = array[r++];
            }
        }

        /*
         * 오른쪽 부분리스트의 값들을 다 소진했을 경우
         * 왼쪽 부분리스트의 값을 순서대로 sortedArray에 넣어준다.
         */

        else {
            while(l <= mid) {
                sortedArray[idx++] = array[l++];
            }
        }

        for(int i = left ; i <= right; i++){
            array[i] = sortedArray[i];
        }
    }
}
