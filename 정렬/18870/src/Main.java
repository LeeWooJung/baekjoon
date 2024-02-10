import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int N;
        int rank = 0;
        int getElem;
        int[] array;
        int[] sortedArray;
        HashMap<Integer, Integer> ranked = new HashMap<Integer, Integer>();

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N 입력
        N = Integer.parseInt(br.readLine());
        // StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());
        // array, sortedArray 선언
        array = new int[N];
        sortedArray = new int[N];
        // array, sortedArray 입력
        for(int idx = 0; idx < array.length; idx++) {
            getElem = Integer.parseInt(st.nextToken());
            array[idx] = getElem;
            sortedArray[idx] = getElem;
        }
        // sortedArray 정렬
        Arrays.sort(sortedArray);
        /*
         * sortedArray에서 순서대로 값을 훑어가면서 rank를 저장.
         * 중복된 값은 같은 rank를 가져야 함을 유의.
         */
        for(int value: sortedArray) {

            if(!ranked.containsKey(value)) {
                ranked.put(value, rank++);
            }
        }
        // bufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 정답 출력
        for(int index = 0; index < array.length; index++) {
            bw.write(ranked.get(array[index]) + " ");
        }
        bw.flush();
        bw.close();
    }
}
