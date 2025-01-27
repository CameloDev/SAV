package Factory;

import java.util.ArrayList;
import java.util.List;

public class HeapSort implements SortingAlgorithm {
    private final List<Object[]> steps = new ArrayList<>();

    @Override
    public void sort(Object[] array, boolean ascending) {
        int n = array.length;

        // Construir o heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, ascending);
        }

        // Ordenar
        for (int i = n - 1; i > 0; i--) {
            Object temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0, ascending);

            steps.add(array.clone());
        }
    }

    private void heapify(Object[] array, int n, int i, boolean ascending) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && (ascending ? compare(array[left], array[largest]) > 0 : compare(array[left], array[largest]) < 0)) {
            largest = left;
        }

        if (right < n && (ascending ? compare(array[right], array[largest]) > 0 : compare(array[right], array[largest]) < 0)) {
            largest = right;
        }

        if (largest != i) {
            Object swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest, ascending);
        }
    }

    @Override
    public List<Object[]> getSteps() {
        return steps;
    }

    private int compare(Object o1, Object o2) {
        if (o1 instanceof Integer && o2 instanceof Integer) {
            return ((Integer) o1).compareTo((Integer) o2);
        } else if (o1 instanceof Character && o2 instanceof Character) {
            return ((Character) o1).compareTo((Character) o2);
        }
        throw new IllegalArgumentException("Tipos não suportados: " + o1.getClass() + " e " + o2.getClass());
    }
}