package Week3;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;


public class Sum_nSquare {
    public static void main(String[] args) {
        In in = new In("C:\\Users\\Huy\\IdeaProjects\\DSA2\\src\\Week2\\Sum\\4Kints.txt");
        int[] a = in.readAllInts();

        Arrays.sort(a);
        int n = a.length;
        for (int i = 0; i < n - 2; i++) {
            int left = i+1;
            int right = n-1;
            int cur = a[i];
            while (left<right){
                if(a[left] + a[right] == -cur){
                    System.out.println(cur+" "+a[left]+" "+a[right]);
                    while (left < right && a[left] == a[left + 1]) left++;
                    while (left < right && a[right] == a[right - 1]) right--;
                    left++;
                    right--;
                } else if (a[left] + a[right] < -cur) {
                    left++;
                }else{
                    right--;
                }
            }
        }
    }
}

