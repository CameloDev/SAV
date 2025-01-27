package Factory;

import java.util.List;

public interface SortingAlgorithm {
        void sort(Object[] array, boolean ascending); // Ordena o array
        List<Object[]> getSteps(); // Retorna os passos intermediários para animação
}