package Week3.BTVN;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Sort4_8 {
    public static void main(String[] args) {
        In in = new In("C:\\Users\\Huy\\IdeaProjects\\DSA2\\src\\Week2\\Sum\\2Kints.txt");
        int[] a = in.readAllInts();
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                count++;
            }
        }
        StdOut.println(count);
    }
}

