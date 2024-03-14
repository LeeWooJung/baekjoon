import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        String line;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 입력
        line = br.readLine();

        // 결과 출력
        useSplit us = new useSplit(line);
        System.out.println(us.count());

        // 결과 출력 2
        // useTokenizer ut = new useTokenizer(line);
        // System.out.println(ut.count());
    }
}

class useSplit {
    String line;

    useSplit(String line){
        this.line = line;
    }

    int count() {
        int count = 0;
        String[] words = this.line.split("\\s+");
        for(int index = 0; index < words.length; index++) {
            if(!words[index].isBlank()) count++;
        }
        return count;
    }
}

class useTokenizer {
    String line;

    useTokenizer(String line) {
        this.line = line;
    }

    int count() {
        int count = 0;
        StringTokenizer st = new StringTokenizer(this.line);
        count = st.countTokens();
        return count;
    }
}
