package Week2;

import java.util.Scanner;

public class UFClient2 {
    private int[] parent;
    private int[] size;

    public UFClient2(int N) {
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]]; // Path compression
            p = parent[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return; // Already connected

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        UFClient2 uf = new UFClient2(N);
        int Count = N;
        int pairNumber = 0;

        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            pairNumber++;

            if (p < 0 || p >= N || q < 0 || q >= N) {
                System.out.println("FAILED");
                return;
            }

            if (!uf.connected(p, q)) {
                uf.union(p, q);
                Count--;
            }

            if (Count == 1) {
                System.out.println(pairNumber);
            }
        }

        System.out.println("FAILED");
    }
}
