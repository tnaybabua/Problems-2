import java.util.*;

public class Problem2 {

    static class Client {
        String name;
        int riskScore;
        int balance;

        Client(String name, int riskScore, int balance) {
            this.name = name;
            this.riskScore = riskScore;
            this.balance = balance;
        }

        public String toString() {
            return name + ":" + riskScore;
        }
    }

    // Bubble Sort (ascending riskScore)
    static void bubbleSort(Client[] arr) {

        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j].riskScore > arr[j + 1].riskScore) {

                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                }
            }
        }

        System.out.println("Bubble Sort (asc): " + Arrays.toString(arr));
        System.out.println("Swaps: " + swaps);
    }

    // Insertion Sort (descending riskScore, then balance)
    static void insertionSort(Client[] arr) {

        for (int i = 1; i < arr.length; i++) {

            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore && arr[j].balance < key.balance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("Insertion Sort (desc): " + Arrays.toString(arr));
    }

    // Top K highest risk
    static void topK(Client[] arr, int k) {

        System.out.print("Top " + k + " risks: ");

        for (int i = 0; i < k && i < arr.length; i++) {
            System.out.print(arr[i].name + "(" + arr[i].riskScore + ") ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 2000),
                new Client("clientB", 50, 3000)
        };

        // Bubble sort
        bubbleSort(clients.clone());

        // Insertion sort
        Client[] sorted = clients.clone();
        insertionSort(sorted);

        // Top risks
        topK(sorted, 3);
    }
}