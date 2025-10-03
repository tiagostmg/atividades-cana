package HeapSort;

import java.util.Random;
import java.util.Arrays;

public class HeapSort {

    // ----------- Função para "corrigir" o heap ----------
    void maxHeapify(int[] A, int n, int i) {
        int left = 2 * i + 1;   // filho esquerdo
        int right = 2 * i + 2;  // filho direito
        int largest = i;        // assume que a raiz é o maior

        // verifica se filho esquerdo é maior que o pai
        if (left < n && A[left] > A[largest]) {
            largest = left;
        }

        // verifica se filho direito é maior que o maior atual
        if (right < n && A[right] > A[largest]) {
            largest = right;
        }

        // se o maior não for a raiz, troca e aplica heapify recursivo
        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;

            maxHeapify(A, n, largest);
        }
    }

    // ----------- Função para construir o Heap Máximo ----------
    void buildMaxHeap(int[] A, int n) {
        // começa do último nó que possui filhos até a raiz
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(A, n, i);
        }
    }

    // ----------- Função HeapSort ----------
    void heapSort(int[] A) {
        int n = A.length;

        // Constrói o heap máximo
        buildMaxHeap(A, n);

        // Extrai elementos do heap um por um
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz (maior elemento) para o fim
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            // chama maxHeapify na raiz para restaurar o heap
            maxHeapify(A, i, 0);
        }
    }

    // ----------- Função de Validação ----------
    boolean isSorted(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                return false; // encontrou um fora de ordem
            }
        }
        return true;
    }

    // ----------- Main ----------
    public static void main(String[] args) {
        HeapSort sorter = new HeapSort();
        Random random = new Random();

        // Gerar 20 números aleatórios entre 1 e 100
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }

        // Mostrar vetor original
        System.out.println("Vetor original: " + Arrays.toString(array));

        // Executar HeapSort
        sorter.heapSort(array);

        // Mostrar resultado ordenado
        System.out.println("Vetor ordenado: " + Arrays.toString(array));

        // Validação
        System.out.println("Está ordenado? " + sorter.isSorted(array));
    }
}
