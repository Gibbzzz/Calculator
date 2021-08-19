package exercise;

public class NumbersPair {

    private final int a;
    private final int b;

    public NumbersPair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    public static NumbersPair parseStringToArabic(String inputValue) {
        String[] subStr = inputValue.split(" ");
        if (subStr.length != 3) {
            throw new IllegalArgumentException("Неверный формат ввода");
        }
        try {
            int a = Integer.parseInt(subStr[0]);
            int b = Integer.parseInt(subStr[2]);
            if (a > 10 && b > 10) {
                throw new IllegalArgumentException("Введите числа от 1 до 10 включительно, не более");
            }
            return new NumbersPair(a, b);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Введите корректные числа");
        }
    }

    public static NumbersPair parseStringToRoman(String inputValue) {
        String[] subStr = inputValue.split(" ");
        if (subStr.length != 3) {
            throw new IllegalArgumentException("Неверный формат ввода");
        }
        try {
            int a = RomanNumbers.Roman.valueOf(subStr[0]).toInt();
            int b = RomanNumbers.Roman.valueOf(subStr[2]).toInt();
            if (a > 10 && b > 10) {
                throw new IllegalArgumentException("Введите числа от 1 до 10 включительно, не более");
            }
            return new NumbersPair(a, b);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Введите корректные числа");
        }
    }
}
