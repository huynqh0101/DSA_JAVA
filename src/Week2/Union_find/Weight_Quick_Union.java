package Week2.Union_find;

import edu.princeton.cs.algs4.StdOut;

public class Weight_Quick_Union {
    private int[] parent;
    private int[] size;

    public Weight_Quick_Union(int n) {
        parent = new int[n];
        size = new int[n];
        for(int i =0 ; i < n ;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findRoot(int p){
        while (p != parent[p]){
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

    public static void main(String[] args) {
        PathWeight_Quick_Union qu = new PathWeight_Quick_Union(10);
        qu.union(1,2);
        qu.union(2,3);
        qu.union(4,5);
        qu.union(5,6);
        qu.union(6,7);
        qu.union(1,5);

        StdOut.println(qu.connected(3,1));
        StdOut.println(qu.connected(4,1));
    }

}
