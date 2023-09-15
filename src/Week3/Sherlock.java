package Week3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sherlock {
    public static String Sherlock(List<Integer> arr) {
        if (arr == null) {
            return "NO";
        }
        if (arr.size() == 1) {
            return "YES";
        }
        int sum = 0, sumL = 0;
        for (int i = 0 ; i < arr.size(); i++){
            sum+= arr.get(i);
        }
        for (int i = 0 ; i < arr.size(); i++) {
            if(i == 0) {
                sumL += 0;
            } else {
                sumL+=arr.get(i - 1);
            }
            int sumR  = sum - sumL - arr.get(i);
            if(sumR == sumL) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        List<Integer> ar = new ArrayList<Integer>();
        int sz = StdIn.readInt();
        for (int i = 0 ; i < sz; i++){
            int x = StdIn.readInt();
            ar.add(x);
        }
        String res = Sherlock(ar);
        StdOut.println(res);
    }
}
