import java.util.Stack;

public class QuickSort {

    private int comparacoes = 0; // Contador de comparações

    public void sort(int[] array) {
        quickSortIterativo(array, 0, array.length - 1);
    }

    private void quickSortIterativo(int[] array, int low, int high) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{low, high});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            low = range[0];
            high = range[1];

            if (low < high) {
                int p = partition(array, low, high);
                stack.push(new int[]{low, p - 1});
                stack.push(new int[]{p + 1, high});
            }
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparacoes++;
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int getComparacoes() {
        return comparacoes;
    }
}
