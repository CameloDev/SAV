import java.util.Arrays;
import java.util.Random;

public class ListGenerator {
    public static Object[] generateList(String dataType, String inputType, String values, int randomCount) {
        if (inputType.equalsIgnoreCase("r")) {
            return generateRandomList(dataType, randomCount);
        } else if (inputType.equalsIgnoreCase("m")) {
            return parseValues(dataType, values);
        } else {
            throw new IllegalArgumentException("Tipo de entrada inválido: " + inputType);
        }
    }

    private static Object[] generateRandomList(String dataType, int count) {
        Random random = new Random();
        Object[] list = new Object[count];
        if (dataType.equalsIgnoreCase("n")) {
            for (int i = 0; i < count; i++) {
                list[i] = random.nextInt(2001) - 1000; // [-1000, 1000]
            }
        } else if (dataType.equalsIgnoreCase("c")) {
            for (int i = 0; i < count; i++) {
                char c = (char) (random.nextBoolean() ? 'A' + random.nextInt(26) : 'a' + random.nextInt(26));
                list[i] = c;
            }
        }
        return list;
    }

    private static Object[] parseValues(String dataType, String values) {
        String[] tokens = values.split(",");
        if (dataType.equalsIgnoreCase("n")) {
            return Arrays.stream(tokens).map(Integer::parseInt).toArray();
        } else if (dataType.equalsIgnoreCase("c")) {
            return tokens;
        }
        throw new IllegalArgumentException("Tipo de dados inválido: " + dataType);
    }
}