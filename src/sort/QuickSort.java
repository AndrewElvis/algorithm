package sort;

import java.util.Date;

/**
 * @author AndrewElvis
 * @date 2019-11-21-20:17
 */
public class QuickSort {

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
        swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
        int[] p = partition1(arr, left, right);
        quickSort(arr, left, p[0] - 1);
        quickSort(arr, p[1] + 1, right);
    }

    public static int[] partition1(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        int pivot = arr[r];
        while (l < more){
            if (arr[l] < pivot) {
                swap(arr, ++less, l++);
            } else if (arr[l] > pivot){
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[] {less + 1, more};
    }

    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int p1 = l;
        int p2 = r - 1;
        while (p1 <= p2) {
            while (p1 <= p2 && arr[p1] <= pivot) p1++;
            while (p1 <= p2 && arr[p2] > pivot) p2--;
            if (p1 < p2) swap(arr, p1, p2);
        }
        swap(arr, p1, r);
        return p1;
    }

    private static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}
