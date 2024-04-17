import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class useBitMask {

    static int bit = 0;

    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int M, element;
        String command;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // 변수 입력
        M = Integer.parseInt(br.readLine());
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            if(command.equals("all")) {
                cAll();
                continue;
            } else if(command.equals("empty")) {
                cEmpty();
                continue;
            }

            element = Integer.parseInt(st.nextToken());

            if(command.equals("add")) cAdd(element);
            else if(command.equals("remove")) cRemove(element);
            else if(command.equals("check")) sb.append(cCheck(element) + "\n");
            else cToggle(element);
        }

        System.out.print(sb.toString());
        br.close();
    }

    static void cAdd(int value) {
        bit |= (1 << value);
    }

    static void cRemove(int value) {
        bit &= ~(1 << value);
    }

    static int cCheck(int value) {
        return (bit & (1 << value)) == 0 ? 0 : 1;
    }

    static void cToggle(int value) {
        bit ^= (1 << value);
    }

    static void cAll() {
        bit = (1 << 21) - 1;
    }

    static void cEmpty() {
        bit = 0;
    }
}
