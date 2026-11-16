package Laba8_2;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] a;
    static int[] tree;
    static final int INF = Integer.MAX_VALUE;

    static void build(int v, int tl, int tr) {
        if (tl == tr) {
            tree[v] = a[tl];
            return;
        }
        int tm = (tl + tr) / 2;
        build(2 * v, tl, tm);
        build(2 * v + 1, tm + 1, tr);
        tree[v] = Math.min(tree[2 * v], tree[2 * v + 1]);
    }

    static int query(int v, int tl, int tr, int l, int r) {
        if (l > tr || r < tl) return INF;
        if (l <= tl && tr <= r) return tree[v];
        int tm = (tl + tr) / 2;
        int leftMin  = query(2 * v,     tl,     tm, l, r);
        int rightMin = query(2 * v + 1, tm + 1, tr, l, r);
        return Math.min(leftMin, rightMin);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);

        in.nextToken();
        n = (int) in.nval;

        a = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            a[i] = (int) in.nval;
        }

        tree = new int[4 * n];
        build(1, 0, n - 1);

        StringBuilder sb = new StringBuilder();

        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int i = (int) in.nval;
            in.nextToken();
            int j = (int) in.nval;

            int result;
            if (i >= j) {
                result = INF;
            } else {
                result = query(1, 0, n - 1, i, j - 1);
            }
            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}