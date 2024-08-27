import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

/*
 * S : Segment Tree
 * - Leaf Node: S에 추가되는 수의 개수를 뜻함.
 * - Node: 각 구간에 추가되어 있는 수의 총 개수를 뜻함.
 */

public class Main {

    static int MAX = 2000000;
    static int[] S = new int[MAX*4];
    public static void main(String[] args) throws Exception, IOException {
        
        int N, T, X;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for(int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            if(T == 1) {
                add(1, MAX, 1, X);
            } else {  // T == 2
                sb.append(remove(1, MAX, 1, X)).append('\n');
            }
        }

        System.out.print(sb.toString());
    }

    static int remove(int start, int end, int index, int loc) {

        S[index] -= 1;
        if(start == end) {
            return start;
        }

        int mid = (start + end) / 2;

        int leftNodeVal = S[index*2];

        if(leftNodeVal < loc) {
            return remove(mid+1, end, index*2 + 1, loc - leftNodeVal);
        }
        return remove(start, mid, index*2, loc);

    }

    static void add(int start, int end, int index, int value) {

        if(value < start || end < value) return;

        S[index] += 1;

        if(start == end) return;

        int mid = (start + end) / 2;

        add(start, mid, index*2, value);
        add(mid+1, end, index*2 + 1, value);
    }
}
