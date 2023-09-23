package Week4.ThucHanh;

import edu.princeton.cs.algs4.In;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySreach {
    public static boolean binarySreach(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        In in = new In("C:\\Users\\Huy\\IdeaProjects\\DSA2\\src\\Week2\\Sum\\2Kints.txt");
        int[] arr = in.readAllInts();
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;
        for ( int i = 0; i < n - 3; i++) {
            for (int j = i+1; j < n-2; j++) {
                int sum2 = arr[i] + arr[j];
                int left = j+1;
                int right = n-1;
                int target = -sum2;
                if(binarySreach(arr,target, left, right)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
