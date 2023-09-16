package Week3.BTVN;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;
// Bài 1.4.12

public class Array1 {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdIn.readInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = StdIn.readInt();
        }
        int i =0 , j = 0;
        List<Integer> l = new ArrayList<>();
        while (i < a.length && j < b.length){
            if(a[i] == b[j]) {
                l.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]){
                i++;
            } else {
                j++;
            }
        }
        for( int cnt : l) {
            StdOut.print(cnt + " ");
        }
    }

}

