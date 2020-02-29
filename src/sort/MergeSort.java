package sort;

/**
 * @author AndrewElvis
 * @date 2019-11-19-18:55
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        mergeSort(arr);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null && arr.length < 2) return;
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left == right) return;
        int mid = left + ((right - left) >> 1);
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <=right){
            res += arr[p1] < arr[p2] ? arr[p1] * (right - p2 + 1) : 0;
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[i++] = arr[p2++];
        }
        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }
}
