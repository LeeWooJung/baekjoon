import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class lis {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int n;
        int maxLen = 1;

        ArrayList<line> seq = new ArrayList<>();
        int[] lis = new int[501];

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        n = Integer.parseInt(br.readLine());
        for(int t = 0; t < n; t++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            seq.add(new line(from, to));
        }

        Collections.sort(seq);

        // Longest Increasing Sequence
        lis[0] = seq.get(0).to;
        for(int index = 1; index < seq.size(); index++) {
            int value = seq.get(index).to;
            if(lis[maxLen -1] < value) {
                lis[maxLen++] = value;
            } else if (lis[0] > value) {
                lis[0] = value;
            } else {
                int location = Arrays.binarySearch(lis, 0, maxLen, value);
                location = location < 0 ? -(location + 1) : location;
                lis[location] = value;
            }
        }

        System.out.println(seq.size() - maxLen);
        br.close();
    }
}

class line implements Comparable<line>{
    int from;
    int to;

    line(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public int compareTo(line l) {
        if(l.from < from) return 1;
        else return -1;
    }
}
