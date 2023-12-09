package Week12;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        List<Boolean> f = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            f.add(true);
        }

        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            a.add(new ArrayList<Integer>());
        }

        for (List<Integer> r : cities) {
            int u = r.get(0);
            int v = r.get(1);
            a.get(u).add(v);
            a.get(v).add(u);
        }

        long tc = 0;
        for (int u = 1; u <= n; ++u) {
            if (f.get(u)) {
                f.set(u, false);
                tc += c_lib;
                tc += buildRoad(u, a, f) * Math.min(c_road, c_lib);
            }
        }

        return tc;
    }

    private static int buildRoad(int u, List<List<Integer>> a, List<Boolean> f) {
        int nr = 0;
        for (int v : a.get(u)) {
            if (f.get(v)) {
                f.set(v, false);
                nr += buildRoad(v, a, f) + 1;
            }
        }
        return nr;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            int c_lib = Integer.parseInt(firstMultipleInput[2]);

            int c_road = Integer.parseInt(firstMultipleInput[3]);

            List<List<Integer>> cities = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                String[] citiesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> citiesRowItems = new ArrayList<>();

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowTempItems[j]);
                    citiesRowItems.add(citiesItem);
                }

                cities.add(citiesRowItems);
            }

            long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

