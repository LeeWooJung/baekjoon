import java.io.*;
import java.util.*;

public class Main {

    static int tree_size = 1000001;
    static int[] seg_tree = new int[tree_size*4];
    public static void main(String[] args) throws Exception, IOException {
        
        int n;
        int A, B, C;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        for(int t = 0; t < n; t++) {
            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());

            if(A == 2) {
                B = Integer.parseInt(st.nextToken());
                C = Integer.parseInt(st.nextToken());

                update(1, tree_size, 1, B, C);
                
            } else {
                B = Integer.parseInt(st.nextToken());
                
                sb.append(find(1, tree_size, 1, B)).append("\n");
            }

        }

        System.out.print(sb.toString());
    }

    static int find(int start, int end, int index, int target) {

        if(start == end) {
            update(1, tree_size, 1, start, -1);
            return start;
        }

        int mid = (start + end)/2;
        if(target <= seg_tree[index * 2]) return find(start, mid, index * 2, target);
        else return find(mid + 1, end, index*2 + 1, target - seg_tree[index * 2]);
    }

    static void update(int start, int end, int index, int target, int diff) {

        if(target < start || end < target) return;

        seg_tree[index] += diff;
        if(start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, index * 2, target, diff);
        update(mid + 1, end, index*2 + 1, target, diff);
    }
}
