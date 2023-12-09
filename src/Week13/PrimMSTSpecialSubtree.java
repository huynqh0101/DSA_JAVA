package Week13;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Cost implements Comparable<Cost> {
    public int r, v;

    public Cost(int cost, int vertex) {
        r = cost;
        v = vertex;
    }

    @Override
    public int compareTo(Cost c) {
        if (r < c.r) return -1;
        if (r > c.r) return 1;
        if (v < c.v) return -1;
        if (v > c.v) return 1;
        return 0;
    }
}

class Result {

    /*
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */


    public static int prims(int n, List<List<Integer>> edges, int start) {
        // Write your code here
        List<List<Cost>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Cost>());
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adj.get(u).add(new Cost(w, v));
            adj.get(v).add(new Cost(w, u));
        }

        PriorityQueue<Cost> pq = new PriorityQueue<>();
        boolean[] marked = new boolean[n + 1];
        int res = 0;
        pq.add(new Cost(0, start));
        while (!pq.isEmpty()) {
            Cost cost = pq.poll();
            if(marked[cost.v]) {
                continue;
            }
            marked[cost.v] = true;
            res += cost.r;

            for(Cost x : adj.get(cost.v)) {
                if(!marked[x.v]) {
                    pq.add(x);
                }
            }
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] edgesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> edgesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int edgesItem = Integer.parseInt(edgesRowTempItems[j]);
                edgesRowItems.add(edgesItem);
            }

            edges.add(edgesRowItems);
        }

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

