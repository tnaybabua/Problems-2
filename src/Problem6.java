import java.util.*;

public class Problem6{

    // -------- LINEAR SEARCH --------
    static void linearSearch(int[] arr, int target) {

        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;

            if (arr[i] == target) {
                found = true;
                System.out.println("Linear: Found at index " + i);
                break;
            }
        }

        if (!found) {
            System.out.println("Linear: Not found");
        }

        System.out.println("Comparisons: " + comparisons);
    }

    // -------- FLOOR (largest <= target) --------
    static int floor(int[] arr, int target) {

        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                result = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // -------- CEILING (smallest >= target) --------
    static int ceiling(int[] arr, int target) {

        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                result = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    // -------- INSERTION POSITION --------
    static int insertionPoint(int[] arr, int target) {

        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        // Linear search
        linearSearch(risks, 30);

        // Binary operations
        System.out.println("\nBinary Results:");
        System.out.println("Floor(30): " + floor(risks, 30));
        System.out.println("Ceiling(30): " + ceiling(risks, 30));
        System.out.println("Insertion Index: " + insertionPoint(risks, 30));
    }
}