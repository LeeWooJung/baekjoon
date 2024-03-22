import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int[] map = new int[101];
    static int[] visited = new int[101];
    static int[] dice = {1,2,3,4,5,6};
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N, M;
        int start = 1, destination = 100;

        for(int index = start; index <= destination; index++) {
            map[index] = index;
            visited[index] = -1;
        }
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // 변수 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int t = 0; t < N + M; t++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int move : dice) {
                int next = current + move;
                if(next > destination || visited[next] >= 0) continue;
                visited[next] = visited[current] + 1;

                if(next == destination) {
                    System.out.println(visited[destination]);
                    return;
                }
                if(map[next] != next) { // 사다리 혹은 뱀이 있을 때
                    if(visited[map[next]] >= 0) continue;
                    visited[map[next]] = visited[next];
                    queue.offer(map[next]);
                } else {
                    queue.offer(next);
                }
            }
        }
    }
}