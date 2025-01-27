package Factory;

import java.util.ArrayList;
import java.util.List;

public class QuickSort implements SortingAlgorithm {
    private final List<Object[]> steps = new ArrayList<>();

    @Override
    public void sort(Object[] array, boolean ascending) {
        quickSort(array, 0, array.length - 1, ascending);
    }

    private void quickSort(Object[] array, int low, int high, boolean ascending) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, ascending);
            quickSort(array, low, pivotIndex - 1, ascending);
            quickSort(array, pivotIndex + 1, high, ascending);
        }
    }

    private int partition(Object[] array, int low, int high, boolean ascending) {
        Object pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if ((ascending && compare(array[j], pivot) < 0) || (!ascending && compare(array[j], pivot) > 0)) {
                i++;
                Object temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        Object temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        steps.add(array.clone());
        return i + 1;
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