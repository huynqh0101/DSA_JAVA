package Bonus_Vebo;

import java.util.Scanner;

class SegmentTree {
    private int[] a, t;
    private int n;

    public SegmentTree(int[] a) {
        this.a = a;
        this.n = a.length;
        this.t = new int[4 * n];
        build(1, 0, n - 1);
    }

    private void build(int v, int l, int r) {
        if (l == r) {
            t[v] = a[l];
        } else {
            int m = (l + r) / 2;
            build(2 * v, l, m);
            build(2 * v + 1, m + 1, r);
            t[v] = Math.min(t[2 * v], t[2 * v + 1]);
        }
    }

    public void update(int i, int val) {
        update(1, 0, n - 1, i, val);
    }

    private void update(int v, int l, int r, int i, int val) {
        if (l == r) {
            a[i] = val;
            t[v] = val;
        } else {
            int m = (l + r) / 2;
            if (l <= i && i <= m) {
                update(2 * v, l, m, i, val);
            } else {
                update(2 * v + 1, m + 1, r, i, val);
            }
            t[v] = Math.min(t[2 * v], t[2 * v + 1]);
        }
    }

    public int query(int left, int right) {
        return query(1, 0, n - 1, left, right);
    }

    private int query(int v, int l, int r, int left, int right) {
        if (right < l || r < left) {
            return Integer.MAX_VALUE;
        }
        if (left <= l && r <= right) {
            return t[v];
        }
        int m = (l + r) / 2;
        int leftMin = query(2 * v, l, m, left, right);
        int rightMin = query(2 * v + 1, m + 1, r, left, right);
        return Math.min(leftMin, rightMin);
    }
}

public class Queries2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        SegmentTree st = new SegmentTree(a);

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int queryType = sc.nextInt();
            if (queryType == 1) {
                int l = sc.nextInt() - 1;
                int r = sc.nextInt() - 1;
                int result = st.query(l, r);
                System.out.println(result);
            } else if (queryType == 2) {
                int id = sc.nextInt() - 1;
                int v = sc.nextInt();
                st.update(id, v);
            }
        }
    }
}