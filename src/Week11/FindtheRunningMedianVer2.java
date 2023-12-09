package Week11;

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

    public static class TreeNode {
        int val;
        int count; // Number of nodes in the subtree rooted at this node
        TreeNode left, right;

        public TreeNode(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public static class BST {
        private TreeNode root;

        public void insert(int val) {
            root = insert(root, val);
        }

        private TreeNode insert(TreeNode node, int val) {
            if (node == null) {
                return new TreeNode(val, 1);
            }

            if (val <= node.val) {
                node.left = insert(node.left, val);
            } else {
                node.right = insert(node.right, val);
            }

            node.count = 1 + getCount(node.left) + getCount(node.right);
            return node;
        }

        public int getCount(TreeNode node) {
            return node == null ? 0 : node.count;
        }

        public int findKthSmallest(int k) {
            return findKthSmallest(root, k);
        }

        private int findKthSmallest(TreeNode node, int k) {
            int leftCount = getCount(node.left);

            if (k == leftCount + 1) {
                return node.val;
            } else if (k <= leftCount) {
                return findKthSmallest(node.left, k);
            } else {
                return findKthSmallest(node.right, k - leftCount - 1);
            }
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> res = new ArrayList<>();
        BST bst = new BST();

        for (Integer val : a) {
            bst.insert(val);

            int totalElements = bst.getCount(bst.root);
            int middle = (totalElements + 1) / 2;

            double median;
            if (totalElements % 2 == 0) {
                median = (bst.findKthSmallest(middle) + bst.findKthSmallest(middle + 1)) / 2.0;
            } else {
                median = bst.findKthSmallest(middle);
            }

            res.add(median);
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

