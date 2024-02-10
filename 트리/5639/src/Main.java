import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        bst graph = new bst();
        String input;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            input = br.readLine();
            if(input == null || input.equals("")) break;
            graph.add(Integer.parseInt(input));
        }

        postOrder(graph.root);
        System.out.println(sb.toString());
    }

    static void postOrder(node current) {
        if(current == null) return;

        postOrder(current.left);
        postOrder(current.right);
        sb.append(current.value + "\n");
    }

    static class bst {
        node root;

        bst() {
            this.root = null;
        }

        void add(int value) {
            if(this.root == null) {
                this.root = new node(value);
            } else {
                node parent = null;;
                node current = root;
                node node = new node(value);

                boolean isLeft = false;
                
                while(current != null) {
                    parent = current;
                    if(current.value < value) {
                        current = current.right;
                        isLeft = false;
                    } else {
                        current = current.left;
                        isLeft = true;
                    }
                }

                if(isLeft) parent.left = node;
                else parent.right = node;
            }
        }
    }

    static class node {
        int value;
        node left;
        node right;

        node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
