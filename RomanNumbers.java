
public class RomanNumbers {

    static int numbers[] = {1, 4, 5, 9, 10, 40, 50, 90, 100};
    static String letters[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};

    public static String convertToRomanNumbers(int number) {
        String romanValue = "";

        while (number > 0) {
            for (int i = 0; i < numbers.length; i++) {
                if (number < numbers[i]) {
                    number -= numbers[i - 1];
                    romanValue += letters[i - 1];
                    break;
                }
            }
        }
        return romanValue;
    }

    public enum Roman {
        I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);
        private int value;
        Roman(int value) {
            this.value = value;
        }
        public int toInt() {
            return value;
        }
    }
}