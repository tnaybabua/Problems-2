import java.util.*;

public class Problem5{

    // -------- LINEAR SEARCH --------
    static void linearSearch(String[] arr, String target) {

        int first = -1, last = -1, comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;

            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("Linear Search:");
        System.out.println("First Index: " + first);
        System.out.println("Last Index: " + last);
        System.out.println("Comparisons: " + comparisons);
    }

    // -------- BINARY SEARCH (FIRST OCCURRENCE) --------
    static int binaryFirst(String[] arr, String target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                high = mid - 1; // go left
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // -------- BINARY SEARCH (LAST OCCURRENCE) --------
    static int binaryLast(String[] arr, String target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                low = mid + 1; // go right
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // -------- COUNT OCCURRENCES --------
    static void binarySearch(String[] arr, String target) {

        int first = binaryFirst(arr, target);
        int last = binaryLast(arr, target);

        int count = (first == -1) ? 0 : (last - first + 1);

        System.out.println("\nBinary Search:");
        System.out.println("First Index: " + first);
        System.out.println("Last Index: " + last);
        System.out.println("Count: " + count);
    }

    public static void main(String[] args) {

        String[] logs = {"accA", "accB", "accB", "accC"};

        // Linear search
        linearSearch(logs, "accB");

        // Binary search (array must be sorted)
        Arrays.sort(logs);
        binarySearch(logs, "accB");
    }
}