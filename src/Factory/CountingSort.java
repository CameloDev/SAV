package Factory;

import java.util.ArrayList;
import java.util.List;

public class CountingSort implements SortingAlgorithm {
    private final List<Object[]> steps = new ArrayList<>();

    @Override
    public void sort(Object[] array, boolean ascending) {
        if (array.length == 0) {
            return;
        }

        int max = (Integer) array[0];
        int min = (Integer) array[0];
        for (Object num : array) {
            int val = (Integer) num;
            if (val > max) max = val;
            if (val < min) min = val;
        }

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[array.length];

        // Contar as ocorrências
        for (Object num : array) {
            count[(Integer) num - min]++;
        }

        // Acumular
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Construir o array ordenado
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(Integer) array[i] - min] - 1] = (Integer) array[i];
            count[(Integer) array[i] - min]--;
        }

        System.arraycopy(output, 0, array, 0, array.length);

        steps.add(array.clone());
    }

    @Override
    public List<Object[]> getSteps() {
        return steps;
    }

    private int compare(Object o1, Object o2) {
        return Integer.compare((Integer) o1, (Integer) o2);
    }
}
