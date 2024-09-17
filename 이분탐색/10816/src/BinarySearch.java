import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {

    static ArrayList<count> arrlist = new ArrayList<>();
    public static void main(String[] args) throws Exception, IOException {
        
        int N, M;
        int[] arr;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < N; t++) {
            arr[t] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        arrlist.add(new count(arr[0]));
        for(int t = 1; t < N; t++) {
            int val = arr[t];
            if(val == arrlist.get(arrlist.size()-1).value) {
                arrlist.get(arrlist.size()-1).cnt += 1;
            } else {
                arrlist.add(new count(val));
            }
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while(M-- > 0) {
            int toFind = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(toFind)).append(" ");
        }

        System.out.println(sb.toString());
    }

    static int binarySearch(int toFind) {

        int l = 0, r = arrlist.size() - 1;

        while(l <= r) {
            int mid = (l + r) / 2;

            int value = arrlist.get(mid).value;

            if(toFind == value) {
                return arrlist.get(mid).cnt;
            } else if(toFind > value) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return 0;
    }

    static class count {
        int value;
        int cnt;

        count(int value) {
            this.value = value;
            this.cnt = 1;
        }
    }
}
