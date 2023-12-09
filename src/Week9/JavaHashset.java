package Week9;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        HashSet set = new HashSet();
        for(int i = 0; i < t; i++) {
            String s2 = pair_left[i] + " " + pair_right[i];
            set.add(s2);
            System.out.println(set.size());
        }
    }
}
