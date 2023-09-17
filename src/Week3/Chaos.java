package Week3;

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.List;

public class Chaos {
    public static void Bribes(List<Integer> q) {
        // Write your code here
        int bribes = 0;

        for (int i = q.size() - 1; i >= 0; i--) {
            int firstPos = q.get(i);


            if (firstPos - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, firstPos - 2); j < i; j++) {
                if (q.get(j) > firstPos) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < n; i++) {
            int x = StdIn.readInt();
            arr.add(x);
        }
        Bribes(arr);
    }
}
