import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class App {

    /*
     * @class   WORD
     * @implements Comparable<T> - T: WORD
     * 
     * Comparable Interface의 compareTo 메소드 오버라이딩.
     * 1) 길이 비교 - 작은 것을 앞으로 정렬
     * 2) 길이가 같을 경우 사전순으로 정렬 : String Class의 comparetoIgnoreCase 사용
     */
    static class WORD implements Comparable<WORD> {
        String word;
        int length;

        public WORD(String word, int length) {
            super();
            this.word = word;
            this.length = length;
        }

        @Override
        public int compareTo(WORD w) {
            if(this.length > w.length ) {
                return 1;
            } else if(this.length < w.length) {
                return -1;
            } else {
                return this.word.compareToIgnoreCase(w.word);
            }
        }
    }

    public static void main(String[] args) throws Exception, IOException {
        // 변수 설정
        int N;
        String tmp_word;
        WORD[] words;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        N = Integer.parseInt(br.readLine());

        // array 선언
        words = new WORD[N];

        // array 입력
        for(int t = 0; t < words.length; t++) {
            tmp_word = br.readLine();
            words[t] = new WORD(tmp_word, tmp_word.length());
        }

        // Sort
        Arrays.sort(words);

        // BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
         * 정답 출력
         * - 중복된 단어를 제거해야함.
         * - 이미 배열이 정렬된 상태이므로 같은 단어는 연속으로 이어져 있음.
         * - 따라서 이전 단어를 확인하고 같은 단어라면 출력하지 않음.
         */
        bw.write(words[0].word + "\n");
        for(int idx = 1; idx < words.length; idx++) {
            if(words[idx].word.equals(words[idx-1].word)) continue;
            bw.write(words[idx].word + "\n");
        }

        bw.flush();
        bw.close();


    }
}
