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
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        List<Integer> dist = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++) {
            dist.add(-1);
        }

        int[][] g = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int x = edges.get(i).get(0);
            int y = edges.get(i).get(1);
            g[x][y] = 6;
            g[y][x] = 6;
        }

        boolean[] v = new boolean[n + 1];
        v[0] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        v[s] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 0; i < n + 1; i++) {
                if (!v[i] && g[node][i] != 0) {
                    q.add(i);
                    v[i] = true;
                    if (dist.get(node) == -1) {
                        dist.set(i, g[node][i]);
                    } else {
                        dist.set(i, dist.get(node) + g[node][i]);
                    }
                }
            }
        }

        dist.remove(s);
        dist.remove(0);
        return dist;
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

            List<List<Integer>> edges = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                String[] edgesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> edgesRowItems = new ArrayList<>();

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowTempItems[j]);
                    edgesRowItems.add(edgesItem);
                }

                edges.add(edgesRowItems);
            }

            int s = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> result = Result.bfs(n, m, edges, s);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

