import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;


public class Main {

    static node[] Graph;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int N;
        Character value;
        Character left, right;
        Character root = 'A';

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;

        // N 입력
        N = Integer.parseInt(br.readLine());

        // Graph 초기화
        Graph = new node[27];

        // node 입력
        for(int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            value = st.nextToken().charAt(0);
            Graph[value - 64] = new node(value);

            left = st.nextToken().charAt(0);
            if(!left.equals('.')) {
                Graph[value - 64].left = left;
            }
            
            right = st.nextToken().charAt(0);
            if(!right.equals('.')) {
                Graph[value - 64].right = right;
            }
        }

        preorder(root); System.out.println();
        inorder(root); System.out.println();
        postorder(root); System.out.println();

    }

    static void preorder(Character current) {
        if(current == null) return;

        System.out.print(current);
        preorder(Graph[current - 64].left);
        preorder(Graph[current - 64].right);
    }

    static void inorder(Character current) {
        if(current == null) return;

        inorder(Graph[current - 64].left);
        System.out.print(current);
        inorder(Graph[current - 64].right);
    }

    static void postorder(Character current) {
        if(current == null) return;

        postorder(Graph[current - 64].left);
        postorder(Graph[current - 64].right);
        System.out.print(current);
    }

    static class node {
        Character value;
        Character left;
        Character right;

        node(Character value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
