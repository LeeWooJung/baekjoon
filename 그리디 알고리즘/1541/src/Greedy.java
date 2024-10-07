import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Greedy {
    public static void main(String[] args) throws Exception, IOException {
        
        String equation;
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        equation = br.readLine();
        String[] minusSplit = equation.split("-");

        for(int t = 0; t < minusSplit.length; t++) {

            int sum = 0;

            String[] plusSplit = minusSplit[t].split("\\+");
            for(int k = 0; k < plusSplit.length; k++) {
                sum += Integer.parseInt(plusSplit[k]);
            }

            if(t == 0) answer += sum;
            else answer -= sum;
        }

        System.out.println(answer);
    }
}
