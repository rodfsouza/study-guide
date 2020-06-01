package string;

public class MyAtoi {

    public int atoi(String str) {
        if (str == null || str.isEmpty() || str.equals(" ")) {
            return 0;
        }

        int pointer = 0;
        int sign = 1;
        int total = 0;

        while (pointer < str.length() && str.charAt(pointer) == ' ') {
            pointer++;
        }

        if (pointer < str.length() && str.charAt(pointer) == '-') {
            sign = -1;
            pointer++;
        }

        while (pointer < str.length()) {
            if (str.charAt(pointer) == '+') {
                pointer++;
                continue;
            }

            int digit = str.charAt(pointer) - '0';

            if (!isNumeric(digit)) {
                break;
            }

            int max = Integer.MAX_VALUE/10;
            if (max < total || max == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = 10 * total + digit;
            pointer++;
        }
        return total * sign;
    }

    private boolean isNumeric(int digit) {
        if (digit < 0 || digit > 9) {
            return false;
        }
        return true;
    }
}
