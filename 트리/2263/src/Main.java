import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

    static int[] postorder;
    static int[] inorder;
    static int[] preorder;
    static int preIndex = 1;
    public static void main(String[] args) throws Exception, IOException {
        
        // 변수 설정
        int n;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer
        StringTokenizer st;
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // n 입력
        n = Integer.parseInt(br.readLine());
        postorder = new int[n+1];
        inorder = new int[n+1];
        preorder = new int [n+1];

        // inorder 입력
        st = new StringTokenizer(br.readLine());
        for(int index = 1; index <= n; index++) {
            inorder[index] = Integer.parseInt(st.nextToken());
        }
        // postorder 입력
        st = new StringTokenizer(br.readLine());
        for(int index = 1; index <= n; index++) {
            postorder[index] = Integer.parseInt(st.nextToken());
        }

        getPreorder(1, n, n);

        for(int index = 1; index <= n; index++) {
            sb.append(preorder[index] + " ");
        }

        System.out.print(sb.toString());
    }

    static void getPreorder(int inStart, int inEnd, int postRootIndex) {

        if(inStart > inEnd) return;

        int root = postorder[postRootIndex];

        int inRootIndex;
        int rightSize;


        for(inRootIndex = inStart; inRootIndex <= inEnd; inRootIndex++) {
            if(root == inorder[inRootIndex]) {
                preorder[preIndex++] = root;
                break;
            }
        }

        rightSize = inEnd - inRootIndex;

        // Left Subtree
        getPreorder(inStart, inRootIndex -1, postRootIndex - rightSize - 1);
        // Right Subtree
        getPreorder(inRootIndex + 1, inEnd, postRootIndex - 1);
    }

}
