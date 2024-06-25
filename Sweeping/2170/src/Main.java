import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N;
        point[] line;
        int curS, curE;
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        long answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        line = new point[N];

        for(int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            curS = Integer.parseInt(st.nextToken());
            curE = Integer.parseInt(st.nextToken());
            line[t] = new point(curS, curE);
        }

        Arrays.sort(line, (l1, l2) -> {
            if(l1.start != l2.start) return l1.start - l2.start;
            else return l1.end - l2.end;
        });

        for(int t = 0; t < N; t++) {
            curS = line[t].start;
            curE = line[t].end;

            if(end < curS) { // 겹치는 선분이 없을 때
                answer += end - start; // 기존에 그려졌던 선분의 길이를 구하여 더함.
                start = curS; // 새로운 시작 점 갱신.
            }
            if(end < curE) end = curE; // 새로운 끝 점 갱신.
        }

        answer += end - start;

        System.out.println(answer);
    }
}

class point {
    int start;
    int end;

    point(int start, int end) {
        this.start = start;
        this.end = end;
    }
}