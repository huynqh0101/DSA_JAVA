package Week7;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low + 1;
        int j = high;

        while (true) {
            while (i <= j && arr.get(i) <= pivot) {
                i++;
            }

            while (arr.get(j) >= pivot && j >= i) {
                j--;
            }

            if (j < i) {
                break;
            }

            // Swap arr[i] and arr[j]
            Collections.swap(arr, i, j);
        }

        // Swap pivot with arr[j]
        Collections.swap(arr, low, j);

        return j;
    }

    public static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int findMedian(List<Integer> arr) {
        quickSort(arr, 0, arr.size() - 1);
        int n = arr.size();
        if (n % 2 == 1) {
            return arr.get(n / 2);
        } else {
            int mid1 = arr.get(n / 2);
            int mid2 = arr.get(n / 2 - 1);
            return (mid1 + mid2) / 2;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
