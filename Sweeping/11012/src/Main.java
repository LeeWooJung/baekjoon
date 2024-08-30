import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int l, r, val;

        Node() {
            this.l = 0;
            this.r = 0;
            this.val = 0;
        }

        Node(int l, int r, int val) {
            this.l = l;
            this.r = r;
            this.val = val;
        }
    }

    static int MAXN = 100001;
    static int tsz;
    static List<Node> tree;
    static int[] roots = new int[100005];

    static void init() {
        int sz = tsz >> 1;
        for (int i = 1; i <= sz; ++i) {
            tree.get(i).l = i << 1;
            tree.get(i).r = i << 1 | 1;
        }
    }

    static void update(int node, int s, int e, int val, int idx) {
        if (s != e) {
            int mid = (s + e) >> 1;
            int n1 = tree.get(node).l, n2 = tree.get(node).r;
            if (idx <= mid) {
                tree.get(node).l = tree.size();
                tree.add(new Node(tree.get(n1).l, tree.get(n1).r, tree.get(n1).val + val));
                update(tree.get(node).l, s, mid, val, idx);
            } else {
                tree.get(node).r = tree.size();
                tree.add(new Node(tree.get(n2).l, tree.get(n2).r, tree.get(n2).val + val));
                update(tree.get(node).r, mid + 1, e, val, idx);
            }
        }
    }

    static int query(int node, int s, int e, int l, int r) {
        if (r < s || l > e) return 0;
        if (l <= s && e <= r) return tree.get(node).val;
        int mid = (s + e) >> 1;
        int n1 = tree.get(node).l, n2 = tree.get(node).r;
        return query(n1, s, mid, l, r) + query(n2, mid + 1, e, l, r);
    }

    public static void main(String[] args) throws IOException {
        tsz = 1;
        while (tsz < MAXN) tsz <<= 1;
        tsz <<= 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<List<Integer>> yval = new ArrayList<>(MAXN + 1);
            for (int i = 0; i <= MAXN; i++) {
                yval.add(new ArrayList<>());
            }

            tree = new ArrayList<>(tsz);
            for (int i = 0; i < tsz; i++) {
                tree.add(new Node());
            }

            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) + 1;
                int y = Integer.parseInt(st.nextToken()) + 1;
                yval.get(x).add(y);
            }

            init();

            roots[0] = 1;
            for (int i = 1; i <= MAXN; ++i) {
                roots[i] = tree.size();
                int pi = roots[i - 1];
                tree.add(new Node(tree.get(pi).l, tree.get(pi).r, tree.get(pi).val));
                for (int y : yval.get(i)) {
                    tree.get(roots[i]).val += 1;
                    update(roots[i], 1, MAXN, 1, y);
                }
            }

            long ans = 0;
            for (int i = 0; i < M; ++i) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken()) + 1;
                int b = Integer.parseInt(st.nextToken()) + 1;
                int t = Integer.parseInt(st.nextToken()) + 1;
                ans += query(roots[r], 1, MAXN, b, t) - query(roots[l], 1, MAXN, b, t);
            }

            System.out.println(ans);
        }
    }
}
