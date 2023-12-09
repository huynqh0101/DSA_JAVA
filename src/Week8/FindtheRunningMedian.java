package Week8;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        List<Double> res = new ArrayList<>();
        Queue<Integer> maxq = new PriorityQueue();
        Queue<Integer> minq = new PriorityQueue();
        for(Integer val : a) {
            if(!maxq.isEmpty() && val >= -maxq.peek()) {
                minq.add(val);

            }
            else {
                maxq.add(-val);
            }

            if(Math.abs(maxq.size() - minq.size()) > 1) {
                if(maxq.size() < minq.size()) {
                    int top = -minq.peek();
                    minq.remove();
                    maxq.add(top);
                }
                else {
                    int top = -maxq.peek();
                    maxq.remove();
                    minq.add(top);
                }
            }

            if((int) res.size() % 2 == 0) {
                if(maxq.size() > minq.size()) res.add((double) -maxq.peek());
                else res.add((double) minq.peek());
            }
            else {
                double cnt = 0;
                if(maxq.isEmpty() != true) cnt += -maxq.peek();
                if(!minq.isEmpty()) cnt += minq.peek();
                cnt /= 2;
                res.add(cnt);
            }
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < aCount; i++) {
            int aItem = Integer.parseInt(bufferedReader.readLine().trim());
            a.add(aItem);
        }

        List<Double> result = Result.runningMedian(a);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

