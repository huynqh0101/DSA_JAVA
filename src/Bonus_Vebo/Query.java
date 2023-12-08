package Bonus_Vebo;

import java.util.*;

public class Query {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        SegmentTree segmentTree = new SegmentTree(arr);

        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            int result = segmentTree.query(l - 1, r - 1);
            System.out.println(result);
        }
    }

    static class SegmentTree {
        int[] tree;
        int n;

        public SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(arr, 0, n - 1, 0);
        }

        private void build(int[] arr, int start, int end, int index) {
            if (start == end) {
                tree[index] = arr[start];
                return;
            }

            int mid = start + (end - start) / 2;
            build(arr, start, mid, 2 * index + 1);
            build(arr, mid + 1, end, 2 * index + 2);
            tree[index] = Math.max(tree[2 * index + 1], tree[2 * index + 2]);
        }

        public int query(int ql, int qr) {
            return query(0, n - 1, ql, qr, 0);
        }

        private int query(int start, int end, int ql, int qr, int index) {
            if (ql <= start && qr >= end) {
                return tree[index];
            }

            if (end < ql || start > qr) {
                return Integer.MIN_VALUE;
            }

            int mid = start + (end - start) / 2;
            int left = query(start, mid, ql, qr, 2 * index + 1);
            int right = query(mid + 1, end, ql, qr, 2 * index + 2);
            return Math.max(left, right);
        }
    }
}
