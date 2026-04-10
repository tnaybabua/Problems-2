import java.util.*;

public class Problem3{

    static class Trade {
        String id;
        int volume;

        Trade(String id, int volume) {
            this.id = id;
            this.volume = volume;
        }

        public String toString() {
            return id + ":" + volume;
        }
    }

    // -------- MERGE SORT (ASC) --------
    static void mergeSort(Trade[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(Trade[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Trade[] L = new Trade[n1];
        Trade[] R = new Trade[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].volume <= R[j].volume) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // -------- QUICK SORT (DESC) --------
    static void quickSort(Trade[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Trade[] arr, int low, int high) {

        int pivot = arr[high].volume;
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j].volume > pivot) { // DESC
                i++;
                Trade temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Trade temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // -------- MERGE TWO SORTED LISTS --------
    static Trade[] mergeTwoSorted(Trade[] a, Trade[] b) {

        Trade[] result = new Trade[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i].volume <= b[j].volume) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];

        return result;
    }

    // -------- TOTAL VOLUME --------
    static int totalVolume(Trade[] arr) {
        int sum = 0;
        for (Trade t : arr) sum += t.volume;
        return sum;
    }

    public static void main(String[] args) {

        Trade[] trades = {
                new Trade("trade3", 500),
                new Trade("trade1", 100),
                new Trade("trade2", 300)
        };

        // Merge Sort (ASC)
        Trade[] mergeArr = trades.clone();
        mergeSort(mergeArr, 0, mergeArr.length - 1);
        System.out.println("MergeSort: " + Arrays.toString(mergeArr));

        // Quick Sort (DESC)
        Trade[] quickArr = trades.clone();
        quickSort(quickArr, 0, quickArr.length - 1);
        System.out.println("QuickSort (desc): " + Arrays.toString(quickArr));

        // Merge two sorted lists
        Trade[] morning = {
                new Trade("t1", 100),
                new Trade("t2", 300)
        };

        Trade[] afternoon = {
                new Trade("t3", 500)
        };

        Trade[] merged = mergeTwoSorted(morning, afternoon);
        System.out.println("Merged: " + Arrays.toString(merged));

        // Total volume
        System.out.println("Total Volume: " + totalVolume(merged));
    }
}