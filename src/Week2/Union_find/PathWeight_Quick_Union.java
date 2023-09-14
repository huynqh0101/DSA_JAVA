package Week2.Union_find;

import edu.princeton.cs.algs4.StdOut;

public class PathWeight_Quick_Union {
    private int[] parent;
    private int[] size;

    public PathWeight_Quick_Union(int n) {
        parent = new int[n];
        size = new int[n];
        for(int i =0 ; i < n ;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findRoot(int p){
        while (p != parent[p]){
            p = parent[parent[p]]; //Path compression
            p = parent[p];
        }
        return p;
    }
    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }
    public void printSize(int p){
        StdOut.println(size[p]);
    }

    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            StdOut.println(size[rootP]+ " _ "+ size[rootQ]);
            size[rootQ] += size[rootP];
        } else {
            StdOut.println(size[rootP]+ " _ "+ size[rootQ]);
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }
}
