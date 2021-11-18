package bits;

public class CharacterSetChecker {

    public int isAsciiOrKanji(String str) {

        if (str == null || str.length() == 0) {
            return -1; //Error
        }

        if (str.length() == 1) {
            if (str.charAt(0) == 0) {
                return 1;
            } else {
                return -1; //Error
            }
        }

        int size = str.length() - 1;
        if (str.charAt(size) == '0' && str.charAt(size - 1) == '0') {
            return 1;
        } else if (str.charAt(size) == '1' && str.charAt(size - 1) == '1') {
            return 2;
        } else if (str.charAt(size) == '1' && str.charAt(size - 1) == '0') {
            return -1;
        }

        int numberOfOnes = 0;
        for (int i = size; i >= 0; --i) {

            if (str.charAt(i) == '1' && i - 1 >= 0 && str.charAt(i - 1) == '1') {
                numberOfOnes++;
            } else if (str.charAt(i) == '1' && i - 1 >= 0 && str.charAt(i - 1) == '0') {
                numberOfOnes++;
            }
        }

        return numberOfOnes % 2 == 0 ? 1 : 2;
    }
}
