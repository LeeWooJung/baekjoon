import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        int N, M;
        int curS, curE;
        int start, end;
        long answer;
        List<point> move = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = M;
        start = end = -1;

        for(int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            curS = Integer.parseInt(st.nextToken());
            curE = Integer.parseInt(st.nextToken());

            if(curE < curS) move.add(new point(M - curS, M - curE)); // 강을 거꾸로 보고 Sweeping algorithm 적용
        }

        Collections.sort(move);
        

        for(int t = 0; t < move.size(); t++) {
            curS = move.get(t).start;
            curE = move.get(t).end; 

            if(end < curS) {
                answer += (long)2*(end - start);
                start = curS;
            }
            if(end < curE) end = curE;

        }

        answer += (long)2*(end - start);

        System.out.println(answer);
    }
}

class point implements Comparable<point> {
    int start;
    int end;

    point(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(point other) {
        if(this.start == other.start) return this.end - other.end;
        else return this.start - other.start;
    }
}