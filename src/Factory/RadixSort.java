package Factory;

import java.util.ArrayList;
import java.util.List;

public class RadixSort implements SortingAlgorithm {
    private final List<Object[]> steps = new ArrayList<>();

    @Override
    public void sort(Object[] array, boolean ascending) {
        int max = (Integer) array[0];
        for (Object num : array) {
            if ((Integer) num > max) {
                max = (Integer) num;
            }
        }

        // Radix sort para números inteiros
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp, ascending);
        }
    }

    private void countingSort(Object[] array, int exp, boolean ascending) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int index = (Integer) array[i] / exp;
            count[index % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = (Integer) array[i] / exp;
            output[count[index % 10] - 1] = (Integer) array[i];
            count[index % 10]--;
        }

        System.arraycopy(output, 0, array, 0, n);
        steps.add(array.clone());
    }

    @Override
    public List<Object[]> getSteps() {
        return steps;
    }
}