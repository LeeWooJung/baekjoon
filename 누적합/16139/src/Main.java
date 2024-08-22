import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        String S;
        int q;
        char alpha;
        int l, r;
        int result = 0;
        int[][] alphabetCulumulatedSum;
        // abcdefghijklmnopqrstuvwxyz

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        S = br.readLine();
        q = Integer.parseInt(br.readLine());

        alphabetCulumulatedSum = new int[26][S.length()];

        // O(S.length())
        for(int index = 0; index < S.length(); index++) {
            int row = S.charAt(index) - 'a';
            alphabetCulumulatedSum[row][index] = 1; // initialization
        }
        // O(S.length())
        for(int row = 0; row < 26; row++) {
            for(int col = 1; col < S.length(); col++) {
                alphabetCulumulatedSum[row][col] += alphabetCulumulatedSum[row][col-1];
            }
        }

        // O(q)
        while(q-- > 0) {
            st = new StringTokenizer(br.readLine());
            alpha = st.nextToken().charAt(0);
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            int left = alphabetCulumulatedSum[alpha - 'a'][l];
            int right = alphabetCulumulatedSum[alpha - 'a'][r];

            // l번째 char가 찾는 char면 +1을 해주어야함.
            result = S.charAt(l) == alpha ? right - left + 1 : right - left;

            sb.append(result).append('\n');
        }

        // O(q + S.length())
        System.out.print(sb.toString());
    }
}
