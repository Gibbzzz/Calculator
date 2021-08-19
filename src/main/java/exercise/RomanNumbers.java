package exercise;

public class RomanNumbers {

    private static final int[] numbers = {1, 4, 5, 9, 10, 40, 50, 90, 100};
    private static final String[] letters = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};

    public enum Roman {
        I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);
        private final int value;
        Roman(int value) {
            this.value = value;
        }
        public int toInt() {
            return value;
        }
    }

    public static String convertToRomanNumbers(int value) { //70
        StringBuilder stringBuilder = new StringBuilder();
        while (value > 0) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] > value) {
                    stringBuilder.append(letters[i - 1]);
                    value -= numbers[i - 1];
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }
}
