package Factory;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements SortingAlgorithm {
    private final List<Object[]> steps = new ArrayList<>();

    @Override
    public void sort(Object[] array, boolean ascending) {
        mergeSort(array, 0, array.length - 1, ascending);
    }

    private void mergeSort(Object[] array, int left, int right, boolean ascending) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle, ascending);
            mergeSort(array, middle + 1, right, ascending);

            merge(array, left, middle, right, ascending);
        }
    }

    private void merge(Object[] array, int left, int middle, int right, boolean ascending) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Object[] leftArray = new Object[n1];
        Object[] rightArray = new Object[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, middle + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if ((ascending && compare(leftArray[i], rightArray[j]) <= 0) ||
                    (!ascending && compare(leftArray[i], rightArray[j]) >= 0)) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }

        steps.add(array.clone());
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