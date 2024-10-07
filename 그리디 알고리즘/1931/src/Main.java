import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N, start, end;
        int answer = 0;
        meeting[] meetings;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        meetings = new meeting[N];

        for(int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            meetings[t] = new meeting(start, end);
        }

        Arrays.sort(meetings, new Comparator<meeting>() {
            @Override
            public int compare(meeting f, meeting s) {
                if(f.end == s.end) return f.start - s.start;
                return f.end - s.end;
            }
        });

        int last = 0;
        for(int t = 0; t < N; t++) {
            int s = meetings[t].start;
            int e = meetings[t].end;

            if(s >= last) {
                last = e;
                answer++;
            }
        }

        System.out.println(answer);
    }

    static class meeting {
        int start;
        int end;

        meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
