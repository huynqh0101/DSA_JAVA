package Week3.BTVN;

public class BitonicSearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 9, 12, 18, 15, 7, 2};
        int target = 7;
        int result = bitonicSearch(arr, target);

        if (result != -1) {
            System.out.println("Value " + target + " tai vi tri " + result);
        } else {
            System.out.println("None  " + target);
        }
    }

    public static int bitonicSearch(int[] arr, int target) {
        int n = arr.length;
        int bitonicPoint = findBitonicPoint(arr, 0, n - 1);

        int ascendingResult = binarySearchAscending(arr, target, 0, bitonicPoint);
        if (ascendingResult != -1) {
            return ascendingResult;
        }

        int descendingResult = binarySearchDescending(arr, target, bitonicPoint + 1, n - 1);
        return descendingResult;
    }

    public static int findBitonicPoint(int[] arr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int binarySearchAscending(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchDescending(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
