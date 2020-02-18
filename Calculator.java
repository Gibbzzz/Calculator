import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Calculator {

    public static void main(String[] args) {
       new Calculator().start();
    }

    public void start() {
        System.out.println("Введите значения: ");
        String inputValue = requestInputValue();
        if (Operators.containOperator(inputValue)) {
            if (containsRoman(inputValue)) {
                NumbersPair pair = NumbersPair.parsStringToRoman(inputValue);
                int result = getArabicResult(pair, inputValue);
                System.out.println(RomanNumbers.convertToRomanNumbers(result));
            }
            else {
                NumbersPair pair = NumbersPair.parseStringToArabic(inputValue);
                System.out.println(getArabicResult(pair, inputValue));
            }
        } else {
            System.out.println("Введен неверный оператор");
        }
    }

    public String requestInputValue() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputValue = null;
        try {
            inputValue = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputValue;
    }

    public int getArabicResult(NumbersPair obj, String inputValue) {
        int result = 0;
        if (inputValue.contains("+")) result = obj.getA() + obj.getB();
        else if (inputValue.contains("-")) result = obj.getA() - obj.getB();
        else if (inputValue.contains("/")) {
            try {
                result = obj.getA() / obj.getB();
            } catch (ArithmeticException e) {
                throw new ArithmeticException("Делить на ноль нельзя");
            }
        } else if (inputValue.contains("*")) result = obj.getA() * obj.getB();
        return result;
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
}

