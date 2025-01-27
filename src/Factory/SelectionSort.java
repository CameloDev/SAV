package Factory;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort implements SortingAlgorithm {
    private final List<Object[]> steps = new ArrayList<>();

    @Override
    public void sort(Object[] array, boolean ascending) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int index = i;

            for (int j = i + 1; j < n; j++) {
                if ((ascending && compare(array[j], array[index]) < 0) || (!ascending && compare(array[j], array[index]) > 0)) {
                    index = j;
                }
            }

            // Swap
            Object temp = array[index];
            array[index] = array[i];
            array[i] = temp;

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