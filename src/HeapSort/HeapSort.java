package HeapSort;

import java.util.Random;
import java.util.Arrays;

public class HeapSort {

    // ===========================
    // MAX-HEAP (ORDENAÇÃO CRESCENTE)
    // ===========================

    void maxHeapify(int[] A, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < n && A[left] > A[largest]) {
            largest = left;
        }

        if (right < n && A[right] > A[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            maxHeapify(A, n, largest);
        }
    }

    void buildMaxHeap(int[] A, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(A, n, i);
        }
    }

    void heapSortAscending(int[] A) {
        int n = A.length;
        buildMaxHeap(A, n);

        for (int i = n - 1; i > 0; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            maxHeapify(A, i, 0);
        }
    }

    // ===========================
    // MIN-HEAP (ORDENAÇÃO DECRESCENTE)
    // ===========================

    void minHeapify(int[] A, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < n && A[left] < A[smallest]) {
            smallest = left;
        }

        if (right < n && A[right] < A[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            int temp = A[i];
            A[i] = A[smallest];
            A[smallest] = temp;
            minHeapify(A, n, smallest);
        }
    }

    void buildMinHeap(int[] A, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(A, n, i);
        }
    }

    void heapSortDescending(int[] A) {
        int n = A.length;
        buildMinHeap(A, n);

        for (int i = n - 1; i > 0; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            minHeapify(A, i, 0);
        }
    }

    // ===========================
    // VALIDAÇÃO
    // ===========================
    boolean isSortedAscending(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                return false;
            }
        }
        return true;
    }

    boolean isSortedDescending(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // ===========================
    // MAIN
    // ===========================
    public static void main(String[] args) {
        HeapSort sorter = new HeapSort();
        Random random = new Random();

        // Gera 10 números aleatórios
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }

        System.out.println("Vetor original:     " + Arrays.toString(array));

        // ---------- Max-Heap (Crescente) ----------
        int[] ascArray = array.clone();
        sorter.heapSortAscending(ascArray);
        System.out.println("Max-Heap (Crescente): " + Arrays.toString(ascArray));
        System.out.println("Está ordenado crescente? " + sorter.isSortedAscending(ascArray));

        // ---------- Min-Heap (Decrescente) ----------
        int[] descArray = array.clone();
        sorter.heapSortDescending(descArray);
        System.out.println("Min-Heap (Decrescente): " + Arrays.toString(descArray));
        System.out.println("Está ordenado decrescente? " + sorter.isSortedDescending(descArray));
    }
}
