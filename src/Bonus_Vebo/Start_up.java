package Bonus_Vebo;

import java.util.*;

public class Start_up {

    public class D {
        int p;
        long v;

        public D(int p, long v) {
            this.p = p;
            this.v = v;
        }
    }

    public void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<D> dList = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            long j = in.nextLong();
            if (j == 1) {
                long q = in.nextLong();
                dList.add(new D(i + 1, q));
            } else {
                long k = in.nextLong();
                while (dList.size() >= k) {
                    dList.remove(Collections.min(dList, Comparator.comparingLong(d -> d.v)));
                }
            }
        }

        int a = in.nextInt();
        int b = in.nextInt();

        if (dList.size() < b) {
            System.out.println(-1);
        } else {
            long sum = 0;
            for (D d : dList) {
                sum += d.v;
            }
            System.out.println(sum);

            dList.sort(Comparator.comparingInt(d -> d.p));

            for (D d : dList) {
                System.out.print(d.p + " ");
            }
        }
    }

    public static void main(String[] args) {
        Start_up result = new Start_up();
        result.solution();
    }
}

