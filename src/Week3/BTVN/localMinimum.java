package Week3.BTVN;

public class localMinimum {
    public static void main(String[] args) {
        int[] arr = {9, 6, 4, 7, 8, 11, 5};
        int localMinIndex = findLocalMinimum(arr);

        if (localMinIndex != -1) {
            System.out.println("Value: [" + localMinIndex + "] = " + arr[localMinIndex]);
        } else {
            System.out.println("Can't Find.");
        }
    }

    public static int findLocalMinimum(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid > 0 && arr[mid] < arr[mid - 1] && mid < arr.length - 1 && arr[mid] < arr[mid + 1]) {
                return mid; // Tìm thấy cực tiểu địa phương tại chỉ số mid
            } else if (mid > 0 && arr[mid] > arr[mid - 1]) {
                right = mid - 1; // Điều này cho biết cực tiểu địa phương nằm ở phía bên trái
            } else {
                left = mid + 1; // Điều này cho biết cực tiểu địa phương nằm ở phía bên phải
            }
        }

        return -1; // Không tìm thấy cực tiểu địa phương
    }
}
