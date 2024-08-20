import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        int T, n;
        point[] islands;
        int count = 0;
        int curX, curY; 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            count = 0;
            n = Integer.parseInt(br.readLine());
            islands = new point[n];

            for(int t = 0; t < n; t++) {
                st = new StringTokenizer(br.readLine());
                curX = Integer.parseInt(st.nextToken());
                curY = Integer.parseInt(st.nextToken());

                islands[t] = new point(curX, curY);
            }

            Arrays.sort(islands);

            for(int i = 0; i < n; i++) {
                point cur = islands[i];
                for(int j = i+1; j < n; j++) {
                    point next = islands[j];

                    if(cur.x <= next.x && cur.y >= next.y) count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }
}

class point implements Comparable<point>{
    int x;
    int y;

    point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(point other) {
        if(this.x != other.x) return this.x - other.x;
        else return other.y - this.y ;
    }
}
