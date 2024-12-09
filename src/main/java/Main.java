import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {

    public static Random random = new Random();

    public static void main(String[] args) {

        int[] tamanhos = {10,50,100,1000,10000,50000};
        //10 50 100 1000 10k 50k
        for (int tamanho: tamanhos){
            int[] vetorQuickSort = new int[tamanho];
            int[] vetorMergeSort = new int[tamanho];

            QuickSort quickSort = new QuickSort();
            MergeSort mergeSort = new MergeSort();

            long inicioQuick = System.nanoTime();
            quickSort.sort(vetorQuickSort);
            long tempoQuick = System.nanoTime() - inicioQuick;

            long inicioMerge = System.nanoTime();
            mergeSort.mergeSort(vetorMergeSort);
            long tempoMerge = System.nanoTime() - inicioMerge;

            // Resultados
            System.out.println("Tamanho: " + tamanho);
            System.out.println("QuickSort - Comparações: " + quickSort.getComparacoes() +
                    ", Tempo: " + tempoQuick / 1_000_000.0 + " ms");
            System.out.println("MergeSort - Comparações: " + mergeSort.getComparacoes() +
                    ", Tempo: " + tempoMerge / 1_000_000.0 + " ms");
            System.out.println();
        }




    }

    //Função para gerar número aleatório
    private static int[] geradorDeNumeros(int tamanho) {
        Set<Integer> numeros = new HashSet<>();
        while (numeros.size() < tamanho) {
            numeros.add(random.nextInt(2*tamanho));
        }

        int[] vetorNumeros = new int[tamanho];
        int i = 0;
        for (int numero : numeros) {
            vetorNumeros[i++] = numero;
        }
        return  vetorNumeros;
    }

    public static void organizacaoVetores(int[] vetorQuickSort, int[] vetorMergeSort) {
        int tamanho = vetorQuickSort.length;
        int[] vetorGerado = geradorDeNumeros(tamanho);
        for (int i = 0; i < tamanho; i++) {
            vetorQuickSort[i] = vetorGerado[i];
            vetorMergeSort[i] = vetorGerado[i];
        }
    }
}
