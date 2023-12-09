package Week11;

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
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        List<Integer> list = new ArrayList<>();

        // Create hash tables to count occurrences
        Map<Integer, Integer> countMapArr = new HashMap<>();
        Map<Integer, Integer> countMapBrr = new HashMap<>();

        for (int num : arr) {
            countMapArr.put(num, countMapArr.getOrDefault(num, 0) + 1);
        }

        for (int num : brr) {
            countMapBrr.put(num, countMapBrr.getOrDefault(num, 0) + 1);
        }

        // Compare the counts and identify missing numbers
        for (Map.Entry<Integer, Integer> entry : countMapBrr.entrySet()) {
            int num = entry.getKey();
            int countInBrr = entry.getValue();
            int countInArr = countMapArr.getOrDefault(num, 0);

            if (countInBrr > countInArr) {
                list.add(num);
            }
        }

        // Sort the result
        Collections.sort(list);

        return list;
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

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
