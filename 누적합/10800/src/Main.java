import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        ArrayList<ball> info = new ArrayList<>();
        info.add(new ball(0, 0, 0));

        int[] answer = new int[N+1];
        int[] eachColorSum = new int[N+1];

        for(int index = 1; index <= N; index++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            info.add(new ball(index, color, size));
        }

        Collections.sort(info, (b1, b2) -> b1.size - b2.size);

        int prevPlayer = 0;
        int sum = 0;
        for(int player = 1; player <= N; player++) {

            while(prevPlayer < player && info.get(prevPlayer).size < info.get(player).size) {
                int size = info.get(prevPlayer).size;
                sum += size;
                eachColorSum[info.get(prevPlayer).color] += size;
                prevPlayer++;
            }

            answer[info.get(player).number] = sum - eachColorSum[info.get(player).color];
        }

        StringBuilder sb = new StringBuilder();
        for(int index = 1; index <= N; index++) {
            sb.append(answer[index]).append("\n");
        }

        System.out.print(sb.toString());
    }
}

class ball {

    int number;
    int color;
    int size;

    ball(int number, int color, int size) {
        this.number = number;
        this.color = color;
        this.size = size;
    }
}
