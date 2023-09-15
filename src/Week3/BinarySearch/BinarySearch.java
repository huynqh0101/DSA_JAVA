package Week3.BinarySearch;

import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
    public static int BinarySearch(int[] a, int k){
        int r = a.length - 1;
        int l = 0;
        while (l <= r){
            int mid = (l+r)/2;
            if(k == a[mid]) {
                return  mid;
            } else if(a[mid] > k){
                r = r - 1;
            } else {
                l = mid + 1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] a = new int[] {2,3, 5,7, 9, 10, 13};
        int res = BinarySearch(a, 3);
        System.out.println(res);
    }
}
