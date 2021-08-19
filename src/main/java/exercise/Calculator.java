package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Calculator {

    public void start() {
        System.out.println("Введите значения (в формате a + b): ");
        String inputValue = requestInputValue();
        if (ArithmeticOperators.containOperator(inputValue)) {
            if (containsRoman(inputValue)) {
                NumbersPair numbersPair = NumbersPair.parseStringToRoman(inputValue);
                int result = getResult(numbersPair, inputValue);
                System.out.println(RomanNumbers.convertToRomanNumbers(result));
            } else {
                NumbersPair pair = NumbersPair.parseStringToArabic(inputValue);
                int result = getResult(pair, inputValue);
                System.out.println(result);
            }
        }
        else {
            System.out.println("Введите корректный оператор");
        }
    }

    public String requestInputValue() {
        String inputValue = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            inputValue = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputValue;
    }

    public boolean containsRoman(String inputValue) {
        try {
            String[] subStr = inputValue.split(" ");
            return Stream.of(RomanNumbers.Roman.values())
                    .anyMatch(roman -> subStr[0].contains(roman.name())) &&
                    Stream.of(RomanNumbers.Roman.values())
                    .anyMatch(roman -> subStr[2].contains(roman.name()));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Неверный формат ввода");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Введите числа от 1 до 10 включительно, не более");
        }
    }

    private int getResult(NumbersPair obj, String inputValue) {
        int result = 0;
        int a = obj.getA();
        int b = obj.getB();
        if (inputValue.contains("+")) result = a + b;
        else if(inputValue.contains("-")) result = a - b;
        else if (inputValue.contains("*")) result = a * b;
        else if (inputValue.contains("/")) {
            try {
                result = a / b;
            } catch (ArithmeticException e) {
                throw new ArithmeticException("Делить на ноль нельзя");
            }
        }
        return result;
    }
}
