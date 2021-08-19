package exercise;

import java.util.HashSet;
import java.util.Set;

public class ArithmeticOperators {

    private ArithmeticOperators() {
        throw new IllegalStateException("ArithmeticOperators");
    }

    private static final Set<String> OPERATORS = new HashSet<>();

    static {
        OPERATORS.add("+");
        OPERATORS.add("-");
        OPERATORS.add("*");
        OPERATORS.add("/");
    }

    public static boolean containOperator(String inputValue) {
        return OPERATORS.stream().anyMatch(inputValue::contains);
    }
}
