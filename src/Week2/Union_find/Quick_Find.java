package Week2.Union_find;

import edu.princeton.cs.algs4.StdOut;

public class Quick_Find {
    private int[] id;
    public Quick_Find(int n) {
        id = new int[n];
        for(int i = 0 ; i < n; i++) {
            id[i] = i;
        }
    }
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void uinon(int p, int q) {
        int pId = id[p];
        int qId = id[q];
        for(int i = 0 ; i < id.length ;i++) {
            if(id[i] == pId){
                id[i] = qId;
            }
        }
    }

    public static void main(String[] args) {
        Quick_Find qf = new Quick_Find(10);
        qf.uinon(0,1);
        qf.uinon(1,2);
        StdOut.println(qf.connected(0,2));
    }
}
