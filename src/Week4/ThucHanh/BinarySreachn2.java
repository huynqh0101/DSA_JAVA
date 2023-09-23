package Week4.ThucHanh;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class BinarySreachn2 {
    public static void main(String[] args) {
        In in = new In("C:\\Users\\Huy\\IdeaProjects\\DSA2\\src\\Week2\\Sum\\2Kints.txt");
        int[] arr = in.readAllInts();
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;
        for ( int i = 0 ; i < n - 2; i++) {
            int j = i+1;
            for( int k = n - 1; k > j + 1; k--) {
                while (j < k) {
                    if(arr[i] + arr[j] + arr[k] == 0) {
                        count++;
                        j++;
                    } else if (arr[i] + arr[j] +arr[k] < 0){
                        j++;
                    } else break;
                }
            }
        }
        System.out.println(count );
    }
}
