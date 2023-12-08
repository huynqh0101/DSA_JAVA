package Bonus_Vebo;

//Jesse and Cookies
import java.io.*;

import java.util.ArrayList;
import java.util.List;

class MyPriorityQueue {
    private List<Integer> a;

    public MyPriorityQueue() {
        a = new ArrayList<>();
    }

    public void add(int b) {
        a.add(b);
        heapifyUp();
    }

    public int peek() {
        if (!isEmpty()) {
            return a.get(0);
        }
        throw new IllegalStateException("000");
    }

    public int remove() {
        if (!isEmpty()) {
            int c = a.get(0);
            int d = a.remove(a.size() - 1);
            if (!isEmpty()) {
                a.set(0, d);
                heapifyDown();
            }
            return c;
        }
        throw new IllegalStateException("000");
    }

    public boolean isEmpty() {
        return a.isEmpty();
    }

    public int size() {
        return a.size();
    }

    private void heapifyUp() {
        int b = a.size() - 1;
        while (b > 0) {
            int c = (b - 1) / 2;
            if (a.get(b) < a.get(c)) {
                swap(b, c);
                b = c;
            } else {
                break;
            }
        }
    }

    private void heapifyDown() {
        int b = 0;
        int c = a.size();

        while (b < c) {
            int d = 2 * b + 1;
            int e = 2 * b + 2;
            int f = b;

            if (d < c && a.get(d) < a.get(f)) {
                f = d;
            }

            if (e < c && a.get(e) < a.get(f)) {
                f = e;
            }

            if (f != b) {
                swap(b, f);
                b = f;
            } else {
                break;
            }
        }
    }

    private void swap(int b, int c) {
        int d = a.get(b);
        a.set(b, a.get(c));
        a.set(c, d);
    }
}

class Result {
    public static int cookies(int k, List<Integer> A) {
        int cnt = 0;
        int N = A.size();
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();

        for (int i = 0; i < N; i++) {
            myPriorityQueue.add(A.get(i));
        }

        while (!myPriorityQueue.isEmpty() && myPriorityQueue.peek() < k) {
            int first = myPriorityQueue.remove();

            if (!myPriorityQueue.isEmpty()) {
                int second = myPriorityQueue.remove();
                myPriorityQueue.add(first + 2 * second);
                cnt++;
            } else {
                return -1;
            }
        }

        return cnt;
    }
}


public class JesseandCookies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] ATemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> A = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int AItem = Integer.parseInt(ATemp[i]);
            A.add(AItem);
        }

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
