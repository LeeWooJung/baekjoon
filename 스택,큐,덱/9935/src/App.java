import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception, IOException {
        // 변수 선언
        String sentence;
        String bomb;
        StringBuilder store = new StringBuilder();

        // BufferdReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        sentence = br.readLine();
        // 폭발 문자열 입력
        bomb = br.readLine();

        /*
         * store에 저장되는 문자열들의 길이가 bomb보다 크거나 같을 때마다
         * store에 존재하는 문자열과 bomb를 비교해야 함.
         * 이 때 store에 bomb가 존재하면 해당 문자열 삭제
         */
        for(int idx = 0; idx < sentence.length(); idx++) {
            store.append(sentence.charAt(idx));
            // store의 길이가 bomb 보다 크거나 같다면 bomb가 들어있는지 확인 시작.
            if(store.length() >= bomb.length()) {
                int delIndex = store.substring(store.length()-bomb.length()).indexOf(bomb);
                if(delIndex == -1) {
                    continue;
                }
                store.delete(store.length() - bomb.length(), store.length());
            }
        }

        if(store.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(store.toString());
        }
    }
}
