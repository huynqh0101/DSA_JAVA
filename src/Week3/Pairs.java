package Week3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {
    public static int Pair(int k, List<Integer> arr) {
        Set<Integer> numberSet = new HashSet<>();
        int count = 0;
        for( int num : arr) {
            if(numberSet.contains(num - k)) {
                count++;
            }
            if(numberSet.contains(num + k)) {
                count++;
            }
            numberSet.add(num);
        }
        return count;
    }
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int k = StdIn.readInt();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < n; i++) {
            int x = StdIn.readInt();
            arr.add(x);
        }
        int res = Pair(k, arr);
        StdOut.println(res);
    }
}
