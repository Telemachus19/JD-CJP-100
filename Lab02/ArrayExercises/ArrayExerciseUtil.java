package Lab02.ArrayExercises;

public class ArrayExerciseUtil {
    static void merge(int arr[], int l, int m, int r) {

        // Find sizes of two subarrays to be merged
        int leftArraySize = m - l + 1;
        int rightArraySize = r - m;

        // Create temp arrays
        int leftArr[] = new int[leftArraySize];
        int rightArr[] = new int[rightArraySize];

        // Copy data to temp arrays
        for (int i = 0; i < leftArraySize; ++i)
            leftArr[i] = arr[l + i];
        for (int j = 0; j < rightArraySize; ++j)
            rightArr[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < leftArraySize && j < rightArraySize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < leftArraySize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < rightArraySize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergeSort(int arr[], int l, int r) {

        if (l < r) {

            // Find the middle point
            int m = l + ((r - l) >>> 1);

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    static int binarySearch(int[] a, int fromIndex, int toIndex,
            int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1); // key not found.
    }

    static void printArray(int[] arr) {
        int length = arr.length;
        System.out.print("[ ");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
    }
}
