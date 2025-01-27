public class InputValidator {
    public static void validateParameters(String algorithm, String dataType, String order, String inputType, String values, int randomCount, int pauseTime) {
        if (!algorithm.matches("[SBIMQHCR]")) {
            throw new IllegalArgumentException("Algoritmo inválido: " + algorithm);
        }
        if (!dataType.matches("[nc]")) {
            throw new IllegalArgumentException("Tipo de dado inválido: " + dataType);
        }
        if (!order.matches("az|za")) {
            throw new IllegalArgumentException("Ordem inválida: " + order);
        }
        if (!inputType.matches("[rm]")) {
            throw new IllegalArgumentException("Tipo de entrada inválido: " + inputType);
        }
        if (inputType.equalsIgnoreCase("m") && (values == null || values.isEmpty())) {
            throw new IllegalArgumentException("Valores devem ser fornecidos para entrada manual.");
        }
        if (inputType.equalsIgnoreCase("r") && (randomCount < 1 || randomCount > 40)) {
            throw new IllegalArgumentException("Quantidade de valores aleatórios deve estar entre 1 e 40.");
        }
        if (pauseTime < 100 || pauseTime > 1000) {
            throw new IllegalArgumentException("Pausa deve estar entre 100 e 1000 ms.");
        }
    }
}