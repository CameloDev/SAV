import Factory.SortingAlgorithm;

import java.util.Arrays;

public class SAV {
    public static void main(String[] args) {
        try {
            // Interpretar os argumentos
            String algorithmType = null;
            String dataType = null;
            String order = null;
            String inputType = null;
            String values = null;
            int pauseTime = 0;
            int repetitions = 0;

            for (String arg : args) {
                if (arg.startsWith("a=")) {
                    algorithmType = arg.substring(2);
                } else if (arg.startsWith("t=")) {
                    dataType = arg.substring(2);
                } else if (arg.startsWith("o=")) {
                    order = arg.substring(2);
                } else if (arg.startsWith("in=")) {
                    inputType = arg.substring(3);
                } else if (arg.startsWith("v=")) {
                    values = arg.substring(2).replace("\"", "");
                } else if (arg.startsWith("s=")) {
                    pauseTime = Integer.parseInt(arg.substring(2));
                }
            }

            // Validar os parâmetros
            if (algorithmType == null || dataType == null || order == null || inputType == null || pauseTime < 100 || pauseTime > 1000) {
                throw new IllegalArgumentException("Parâmetros inválidos ou faltando.");
            }

            boolean ascending = "az".equals(order); // Ordem crescente

            // Criar a lista
            Object[] array;
            if ("m".equals(inputType)) {
                if ("n".equals(dataType)) { // Números
                    array = Arrays.stream(values.split(","))
                            .map(Integer::parseInt)
                            .toArray();
                } else if ("c".equals(dataType)) { // Caracteres
                    array = values.split(",");
                } else {
                    throw new IllegalArgumentException("Tipo de dados não suportado: " + dataType);
                }
            } else {
                throw new IllegalArgumentException("Apenas valores manuais (in=m) são suportados no momento.");
            }

            // Selecionar o algoritmo de ordenação
            SortingAlgorithm algorithm = SortingAlgorithmFactory.createSort(algorithmType);

            // Ordenar com visualização
            System.out.println("Lista inicial: " + Arrays.toString(array));
            algorithm.sort(array, ascending);

            for (Object[] step : algorithm.getSteps()) {
                System.out.println("Iteração: " + Arrays.toString(step));
                Thread.sleep(pauseTime);
            }

            System.out.println("Lista ordenada: " + Arrays.toString(array));
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
