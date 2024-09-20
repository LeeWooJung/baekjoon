import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

    /*
     * f(n+1) f(n)                   1   1
     *                            =   
     * f(n) f(n-1) | 2x2 matrix      1   0 | 2x2 matrix's n square
     * 
     */
    static long mod = 1000000007;
    public static void main(String[] args) throws Exception, IOException {
        
        long N;
        long[][] matrix = {{1, 1}, {1, 0}};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        System.out.println(divide(matrix, N)[0][1]);
    }

    static long[][] divide(long[][] matrix, long exp) {

        if(exp == 1) return matrix;
        
        long[][] res = divide(matrix, exp/2);
        res = multiply(res, res);
        if(exp % 2 == 1) res = multiply(res, matrix);

        return res;
    }

    static long[][] multiply(long[][] first, long[][] second) {

        long[][] res = new long[2][2];

        for(int k = 0; k < 2; k++) {
            for(int r = 0; r < 2; r++) {
                for(int c = 0; c < 2; c++) {
                    res[r][c] += first[r][k] * second[k][c];
                    res[r][c] %= mod;
                }
            }
        }

        return res;
    }
}
