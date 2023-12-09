package Week7;

import java.io.*;
import java.util.*;

public class Solution {

    static void printArray(int[] array)
    {
        for(int num : array)
        {
            System.out.print(num+" ");
        }
        System.out.println("");
    }
    public static int partition(int[] arr, int low, int high) {
        int privot = arr[high];
        int i = low -1;
        for (int j = low; j < high; j++) {
            if(arr[j] <= privot) {
                ++i;
                int tmp = arr[i];
                arr[i] = arr[j] ;
                arr[j] = tmp;
            }
        }
        ++i;
        int tmp2 = arr[i];
        arr[i] = arr[high];
        arr[high] = tmp2;
        return i;
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int p = partition(arr, low, high);
        printArray(arr);
        quickSort(arr, low, p - 1);
        quickSort(arr, p+1, high);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int ar[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            ar[i] = input.nextInt();
        }
        quickSort(ar,0,ar.length-1);
    }

}
