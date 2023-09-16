package Week3.BTVN;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
 //Bài 1.4.17

public class Array2 {
    public static void timkiem(double[] arr) {
        double maxDifference = Double.MIN_VALUE;
         int x = 0, y =0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double difference = Math.abs(arr[i] - arr[j]);
                if (difference >= maxDifference) {
                    maxDifference = difference;
                    x = i;
                    y = j;
                }
            }
        }
        StdOut.println(x + " "  + y);
    }
    public static void main(String[] args) {
        int n = StdIn.readInt();
        double[] b = new double[n];
        for ( int i = 0 ; i < n ;i++) {
            b[i] = StdIn.readDouble();
        }
        timkiem(b);
    }
}
