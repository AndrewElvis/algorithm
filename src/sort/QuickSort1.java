package sort;

import java.util.Date;

/**
 * @author AndrewElvis
 * @date 2020-09-17-12:53
 * @description
 */
public class QuickSort1 {
    public static void main(String[] args) {
        long start = new Date().getTime();
        int max = 10;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        quickSort(arr, 0, arr.length - 1);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        long end = new Date().getTime();
        System.out.println();
        System.out.println(end - start);
    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid + 1, right);
    }

    private static int partition(int[] arr, int l, int r) {
        int p = arr[r];
        int less = l;
        int more = r - 1;
        while (less <= more) {
            while (less <= more && arr[less] <= p) less++;
            while (less <= more && arr[more] > p) more--;
            if (less < more) {
                swap(arr, less, more);
            }
        }
        swap(arr, less, r);
        return less;
    }

    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
