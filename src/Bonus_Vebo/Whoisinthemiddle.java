package Bonus_Vebo;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Whoisinthemiddle {
    public static void main(String[] args) {
        PriorityQueue<Long> a = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> b = new PriorityQueue<>();
        Scanner c = new Scanner(System.in);

        long d = c.nextLong();
        long e = c.nextLong();

        for (long f = 0; f < d; f++) {
            long g = c.nextLong();
            if (a.isEmpty() || g <= a.peek()) {
                a.add(g);
            } else {
                b.add(g);
            }

            if (a.size() < b.size()) {
                a.add(b.poll());
            } else if (a.size() > b.size() + 1) {
                b.add(a.poll());
            }
        }

        for (long h = 0; h < e; h++) {
            long i = c.nextLong();
            if (i == 1) {
                long j = c.nextLong();
                if (a.isEmpty() || j <= a.peek()) {
                    a.add(j);
                } else {
                    b.add(j);
                }

                if (a.size() < b.size()) {
                    a.add(b.poll());
                } else if (a.size() > b.size() + 1) {
                    b.add(a.poll());
                }
            } else if (i == 2) {
                a.poll();

                if (a.size() < b.size()) {
                    a.add(b.poll());
                } else if (a.size() > b.size() + 1) {
                    b.add(a.poll());
                }
            } else if (i == 3) {
                System.out.println(a.isEmpty() ? 0 : a.peek());
            }
        }
    }
}
