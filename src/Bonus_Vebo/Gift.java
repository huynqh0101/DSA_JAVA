package Bonus_Vebo;

import java.io.*;
import java.util.*;

class Gift {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        long ans = a[0];
        minPQ.add(a[0]);
        System.out.print(ans + " ");

        for (int i = 1; i < n; i++) {
            if (i < m) {
                ans += a[i];
                minPQ.add(a[i]);
            } else {
                if (a[i] > minPQ.peek()) {
                    ans = ans - minPQ.poll() + a[i];
                    minPQ.add(a[i]);
                }
            }
            System.out.print(ans + " ");
        }
    }
}