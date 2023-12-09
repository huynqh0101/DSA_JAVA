package Week9;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        if (arr == null || arr.size() < 2)
            return new ArrayList<Integer>();

        int minDifference = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<Integer>();

        mergeSort(arr);

        for (int i = 1; i < arr.size(); i++) {
            int currentDifference = Math.abs(arr.get(i) - arr.get(i - 1));

            if (currentDifference < minDifference) {
                minDifference = currentDifference;
                result.clear();
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            } else if (currentDifference == minDifference) {
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            }
        }

        return result;
    }

    private static void mergeSort(List<Integer> arr) {
        if (arr.size() <= 1) {
            return;
        }

        int mid = arr.size() / 2;
        List<Integer> left = new ArrayList<>(arr.subList(0, mid));
        List<Integer> right = new ArrayList<>(arr.subList(mid, arr.size()));

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(List<Integer> arr, List<Integer> left, List<Integer> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                arr.set(k++, left.get(i++));
            } else {
                arr.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            arr.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            arr.set(k++, right.get(j++));
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result.closestNumbers(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
