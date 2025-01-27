
import Factory.SortingAlgorithm;
import Factory.*;
public class SortingAlgorithmFactory {

    public static SortingAlgorithm createSort(String algorithmType) {
        switch (algorithmType.toUpperCase()) {
            case "S":
                return new SelectionSort();
            case "B":
                return new BubbleSort();
            case "I":
                return new InsertionSort();
            case "M":
                return new MergeSort();
            case "Q":
                return new QuickSort();
            case "H":
                return new HeapSort();
            case "C":
                return new CountingSort();
            case "R":
                return new RadixSort();
            default:
                throw new IllegalArgumentException("Algoritmo desconhecido: " + algorithmType);
        }
    }
}