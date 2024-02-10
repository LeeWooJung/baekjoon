import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int noNums = 10;
        String N;
        int[] array;
        int[] result;

        // Buffered Reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 (String)
        N = br.readLine();

        // array 선언
        array = new int[N.length()];
        result = new int[N.length()];

        // array 값 입력
        for(int idx = 0; idx < N.length(); idx++){
            array[idx] = N.charAt(idx) - '0';
        }

        // counting Sort
        countingSort(array, result, noNums);

        // BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정답 출력
        for(int idx = result.length - 1; idx >= 0; idx--){
            bw.write(Integer.toString(result[idx]));
        }
        bw.close();

    }

    /*
     * @function    countingSort
     * @param   array   정렬을 원하는 배열
     * @param   result  정렬된 결과를 저장할 배열
     * @param   noNums  배열에 들어갈 수들의 개수 - 0 ~ 9
     * 
     * Counting Sort
     * - Array를 읽으면서 각 값이 나올 때 Count 배열의 인덱스의 값을 1 증가시킨다.
     * - Count 배열의 각 값을 누적합으로 바꿔준다.
     * EX)
     * index      0, 1, 2, 3, 4, 5, 6
     * array:    [1, 2, 1, 0, 3, 1, 4]
     * count:    [1, 2, 1, 1, 1, 0, 0]
     * -->       [1, 3, 4, 5, 6, 6, 6] : 누적 합
     * 
     * 이 때 array[6] = 4 이고, count[6] = 6 이다.
     * result[--count[6]] 에 4를 넣어준다. (count[6]의 값은 1 줄어든다.)
     * 즉, count에서 누적된 값은 result에 넣어줄 array의 원소값의 위치이다.
     * 
     * 이와 같이 진행하면 Sorting이 완료된다.
     * 이 때 '안정 정렬'이 되게 하기 위해 array의 끝 인덱스부터 시작하는 것이 좋다.
     */
    private static void countingSort(int[] array, int[] result, int noNums) {
        int[] count = new int[noNums];

        // Step 1. array 내의 원소 개수 카운팅
        for(int idx = 0; idx < array.length; idx++){
            count[array[idx]]++;
        }
        // Step 2. count 배열 누적 합
        for(int idx = 1; idx < count.length; idx++){
            count[idx] += count[idx-1];
        }
        // Step 3. result에 값 저장.
        for(int idx = array.length -1 ; idx >= 0; idx--){
            int value = array[idx];
            result[--count[value]] = value;
        }
    }
}
