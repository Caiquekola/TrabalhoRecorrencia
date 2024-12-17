public class MergeSort {
    private int comparacoes;

    public int getComparacoes() {
        return comparacoes;
    }

    public void mergeSort(int[] vetor) {
        comparacoes = 0;
        ordenar(vetor, 0, vetor.length - 1);
    }

    private void ordenar(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            ordenar(vetor, inicio, meio);
            ordenar(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }
    }

    private void merge(int[] vetor, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        System.arraycopy(vetor, inicio, esquerda, 0, n1);
        System.arraycopy(vetor, meio + 1, direita, 0, n2);

        int i = 0, j = 0, k = inicio;

        while (i < n1 && j < n2) {
            comparacoes++;
            if (esquerda[i] <= direita[j]) {
                vetor[k++] = esquerda[i++];
            } else {
                vetor[k++] = direita[j++];
            }   
        }

        while (i < n1) {
            vetor[k++] = esquerda[i++];
        }

        while (j < n2) {
            vetor[k++] = direita[j++];
        }
    }
}
