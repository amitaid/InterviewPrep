import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Sorting algorithm implementations
 */

public class Sorting {

    // swaps arr[i] with arr[j]. i and j must be legal indices of arr
    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    // testing function to check if a given array is sorted
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // bubble sort implementation for integer arrays
    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    // selection sort implementation for integer arrays
    public static void selection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    // insertion sort implementation for integer arrays
    public static void insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    // mergesort implementation for integer arrays
    public static void mergesort(int[] arr) {
        mergesort(arr, 0, arr.length - 1);
    }

    // mergesort actual implementation
    private static void mergesort(int[] arr, int start, int end) {
        if (end - start > 1) {
            int mid = (end + start) / 2;
            mergesort(arr, start, mid - 1);
            mergesort(arr, mid, end);
            mergejoin(arr, start, end);
        } else if (end - start == 1 && arr[start] > arr[end]) {
            swap(arr, start, end);
        }
    }

    // mergesort join helper
    private static void mergejoin(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        int[] temp = new int[end - start + 1];
        int s = start, m = mid;
        for (int i = 0; i < temp.length; i++) {
            if (s == mid) {
                temp[i] = arr[m++];
            } else if (m > end) {
                temp[i] = arr[s++];
            } else {
                temp[i] = arr[s] < arr[m] ? arr[s++] : arr[m++];
            }
        }
        System.arraycopy(temp, 0, arr, start, temp.length);
    }

    // quicksort
    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    // quicksort implementation
    private static void quicksort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quicksort(arr, start, p - 1);
            quicksort(arr, p + 1, end);
        }
    }

    // quicksort partition function
    private static int partition(int[] arr, int left, int right) {
        int pivot = selectPivot(arr, left, right);
        swap(arr, pivot, right);
        int temp = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= arr[pivot]) {
                swap(arr, i, temp);
                temp++;
            }
        }
        swap(arr, temp, right);
        return temp;
    }

    // selects the pivot for the quicksort. arbitrary for now.
    private static int selectPivot(int[] arr, int left, int right) {
        return right;
    }

    private static void mergeSorted(int[] a, int[] b) {
        int i = 0;
        int j = a.length - b.length - 1;
        System.arraycopy(b, 0, a, j, b.length);
        while (i < a.length) {

        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = IntStream.generate(() -> r.nextInt(100)).limit(20).toArray();
        System.out.println("Before: " + Arrays.toString(arr));
        Sorting.mergesort(arr);
        System.out.println("After:  " + Arrays.toString(arr));
    }

}
