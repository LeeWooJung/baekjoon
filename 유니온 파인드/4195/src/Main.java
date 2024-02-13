import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static HashMap<String, Integer> name;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int T;
        int numFriends;

        // BufferedReader
        

        // 변수 입력
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {

            numFriends = Integer.parseInt(br.readLine());

            initialize(numFriends);
            getFriendShip(numFriends);

            System.out.print(sb.toString());

        }
    }

    static void union(String x, String y) {

        int xIdx = name.get(x);
        int yIdx = name.get(y);

        int xRep = find(xIdx);
        int yRep = find(yIdx);

        int xSize = Math.abs(parent[xRep]);
        int ySize = Math.abs(parent[yRep]);

        if(xRep == yRep) {
            sb.append(xSize + "\n");
            return;
        }

        if(xSize < ySize) { // yRep을 대표 노드로
            parent[xRep] = yRep;
            parent[yRep] -= xSize;
            sb.append(Math.abs(parent[yRep]) + "\n");
        } else if(xSize > ySize) { // xRep을 대표 노드로
            parent[yRep] = xRep;
            parent[xRep] -= ySize;
            sb.append(Math.abs(parent[xRep]) + "\n");
        } else {
            if(xRep < yRep) { // xRep을 대표 노드로
                parent[yRep] = xRep;
                parent[xRep] -= ySize;
                sb.append(Math.abs(parent[xRep]) + "\n");
            } else { // yRep을 대표 노드로
                parent[xRep] = yRep;
                parent[yRep] -= xSize;
                sb.append(Math.abs(parent[yRep]) + "\n");
            }
        }

        return;
    }

    static Integer find(int index) {
        
        if(parent[index] < 0) {
            return index;
        }

        parent[index] = find(parent[index]);
        return parent[index];
    }

    static void getFriendShip(int numFriends) {

        String first, second;
        int personIdx = 0;

        try {
            StringTokenizer st;

            for(int t = 0; t < numFriends; t++) {
                st = new StringTokenizer(br.readLine());
                first = st.nextToken();
                second = st.nextToken();

                if(!name.containsKey(first)) name.put(first, ++personIdx);
                if(!name.containsKey(second)) name.put(second, ++personIdx);

                union(first, second);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        return;
    }

    static void initialize(int numFriends) {

        parent = new int[numFriends * 2 + 1];
        name = new HashMap<>();
        sb = new StringBuilder();

        for(int idx = 0; idx < parent.length; idx++) {
            parent[idx] = -1;
        }
    }
}
