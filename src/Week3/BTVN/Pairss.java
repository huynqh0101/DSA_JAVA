package Week3.BTVN;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
//Bài 1.4.16

public class Pairss {
    public static void timkiem(double[] arr) {
        if(arr.length < 2) StdOut.println("-1");
        //Arrays.sort(arr);
        double minn = Double.POSITIVE_INFINITY;
        double x = 0, y = 0;
        for(int i = 0 ; i < arr.length-1; i++) {
            double dif = Math.abs(arr[i] - arr[i+1]);
            if(dif < minn) {
                minn = dif;
                x = arr[i];
                y = arr[i+1];
            }
        }
        StdOut.print(x + " " + y);
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
