package Factory;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort implements SortingAlgorithm {
    private final List<Object[]> steps = new ArrayList<>();

    @Override
    public void sort(Object[] array, boolean ascending) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            Object key = array[i];
            int j = i - 1;

            while (j >= 0 && ((ascending && compare(array[j], key) > 0) || (!ascending && compare(array[j], key) < 0))) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;

            // Salvar estado do array para animação
            steps.add(array.clone());
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
