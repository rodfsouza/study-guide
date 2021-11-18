package string;

public class PasswordChecker {

    public boolean isEquals(int[] a, int[] b) {

        int max = a.length >= b.length ? a.length : b.length;
        int i = 0;
        int numberOfEquals = 0;

        while (i < a.length && i < b.length) {

            if (a[i] == b[i])
                numberOfEquals++;
            i++;
        }

        return max == numberOfEquals;
    }
}
