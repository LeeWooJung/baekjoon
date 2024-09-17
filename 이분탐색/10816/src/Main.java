import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class Main {
    
    public static void main(String[] args) throws Exception, IOException {
        
        int N, M;
        Map<Integer, Integer> hashMap = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < N; t++) {
            int val = Integer.parseInt(st.nextToken()); 
            hashMap.put(val, hashMap.getOrDefault(val, 0) + 1);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < M; t++) {
            int toFind = Integer.parseInt(st.nextToken());
            sb.append(hashMap.getOrDefault(toFind, 0)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
