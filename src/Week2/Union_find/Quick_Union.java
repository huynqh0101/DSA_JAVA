package Week2.Union_find;

import edu.princeton.cs.algs4.StdOut;

public class Quick_Union {
    private int[] parent;

    public Quick_Union(int n) {
        parent = new int[n];
        for(int i =0 ; i < n ;i++) {
            parent[i] = i;
        }
    }

    public int findRoot(int p){
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }
    public void connected(int p, int q) {
        StdOut.println(parent[p] + " " +parent[q]);
    }
    public boolean connected2(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        parent[rootQ] = rootP;
    }

    public static void main(String[] args) {
        Quick_Union qu = new Quick_Union(10);
        qu.union(1,2);
        qu.connected(2,1);
        qu.union(3,2);
        qu.connected(2,3);
        qu.connected(1,3);
        qu.connected(1,2);


        qu.union(2,5);
        //qu.connected(5,1);
        StdOut.println(qu.connected2(3,1));
        StdOut.println(qu.findRoot(2));
        //StdOut.println(qu.connected(4,1));
    }
}
