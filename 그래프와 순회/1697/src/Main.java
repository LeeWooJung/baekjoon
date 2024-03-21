import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static final int end = 100000;
    static int[] road = new int[end + 1];
    static boolean[] visited = new boolean[end + 1];
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N, M;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer, 변수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;

        while(!queue.isEmpty()) {

            int current = queue.poll();
            if(current == M) break;

            int[] nextPosition = {current -1, current + 1, current * 2};

            for(int next : nextPosition) {
                if(next >= 0 && next <= end && !visited[next]) {
                    queue.offer(next);
                    road[next] = road[current] + 1;
                    visited[next] = true;
                }
            }
        }
        System.out.println(road[M]);
    }
}
