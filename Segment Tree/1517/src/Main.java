import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

/*
 * 1. 기존 Array
 * --> 각 element와 index를 저장(indexes).
 * 2. Array 오름차순 정렬
 * --> 순서대로 읽어서(가장 작은 수부터) 그 수에 해당하는 index를 가져옴. O(log N)
 * 3. Segment Tree 생성
 * --> 2번에서 가져온 index에 해당하는 위치를 표현하는 tree의 값을 1씩 증가시킴.
 * ==> Tree는 오름차순된 Array 현재 선택된 값보다 작은 값들이 어느 위치(index)에 몇 개 위치하는지 나타냄.
 * 4. 오름차순된 Array의 각 원소에서 자신보다 뒤에 존재하면서 작은 원소의 개수를 파악.
 * --> 현재 선택된 값의 index가 k라면, k ~ end에 해당하는 tree의 값을 가져오면 됨.
 */

public class Main {

    static int[] arr;
    static long[] tree;
    static long count = 0;
    
    public static void main(String[] args) throws Exception, IOException {
        
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tree = new long[N*4];
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int index = 0; index < N; index++) {
            arr[index] = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(arr[index], k -> new LinkedList<>()).offer(index + 1); // Array Element 값이 같은 경우 index 모두 저장.
        }

        Arrays.sort(arr); // O(N*logN)

        for(int value: arr) {
            
            int index = map.get(value).poll();
            
            getCount(1, N, index+1, N, 1);
            update(1, N, 1, index);
        }


        System.out.println(count);
    }

    static void getCount(int start, int end, int left, int right, int index) {

        if(right < start || end < left) return;

        if(left <= start && end <= right) {
            count += tree[index];
            return;
        }

        int mid = (start + end) / 2;
        getCount(start, mid, left, right, index*2);
        getCount(mid+1, end, left, right, index*2 + 1);
    }

    /*
     * element의 위치인 loc이 포함되는 tree의 모든 노드 값 +1
     */
    static void update(int start, int end, int index, int loc) { 

        if(loc < start || end < loc) return;

        if(start <= loc && loc <= end) {
            tree[index]++;
        }

        if(start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, index*2, loc);
        update(mid + 1, end, index*2 + 1, loc);
    }
    
}
