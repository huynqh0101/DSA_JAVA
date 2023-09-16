package Week3.BTVN;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
//Bài 1.4.10

public class BinarySearch {
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        In in = new In("C:\\Users\\Huy\\IdeaProjects\\DSA2\\src\\Week2\\Sum\\2Kints.txt");
        int[] arr = in.readAllInts();
        int key = StdIn.readInt();

        int result = binarySearch(arr, key);

        if (result != -1) {
            System.out.println("Phần tử có giá trị bằng " + key + " nằm ở vị trí có chỉ số nhỏ nhất là " + result);
        } else {
            System.out.println("Không tìm thấy phần tử có giá trị bằng " + key);
        }
    }
}