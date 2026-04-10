import java.util.*;

public class Problem1 {

    static class Transaction {
        String id;
        double fee;
        int time; // minutes

        Transaction(String id, double fee, int time) {
            this.id = id;
            this.fee = fee;
            this.time = time;
        }

        public String toString() {
            return id + ":" + fee;
        }
    }

    // Bubble Sort (by fee)
    static void bubbleSort(List<Transaction> list) {

        int n = list.size();
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (list.get(j).fee > list.get(j + 1).fee) {

                    // swap
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break; // early stop
        }

        System.out.println("Bubble Sort Result: " + list);
        System.out.println("Swaps: " + swaps);
    }

    // Insertion Sort (by fee + timestamp)
    static void insertionSort(List<Transaction> list) {

        for (int i = 1; i < list.size(); i++) {

            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 &&
                    (list.get(j).fee > key.fee ||
                            (list.get(j).fee == key.fee && list.get(j).time > key.time))) {

                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);
        }

        System.out.println("Insertion Sort Result: " + list);
    }

    // find high fee outliers
    static void findOutliers(List<Transaction> list) {

        System.out.print("High-fee outliers: ");

        boolean found = false;

        for (Transaction t : list) {
            if (t.fee > 50) {
                System.out.print(t.id + " ");
                found = true;
            }
        }

        if (!found) System.out.print("none");

        System.out.println();
    }

    public static void main(String[] args) {

        List<Transaction> list = new ArrayList<>();

        list.add(new Transaction("id1", 10.5, 600));
        list.add(new Transaction("id2", 25.0, 570));
        list.add(new Transaction("id3", 5.0, 615));

        // Bubble Sort (small batch)
        bubbleSort(new ArrayList<>(list));

        // Insertion Sort (medium batch)
        insertionSort(new ArrayList<>(list));

        // Outliers
        findOutliers(list);
    }
}