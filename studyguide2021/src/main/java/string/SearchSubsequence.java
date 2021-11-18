package string;

public class SearchSubsequence {

    public boolean isSubSequence(String txt, String sub) {

        if (txt == null || txt.length() == 0 || sub == null || sub.length() == 0) {
            return false;
        }

        int lastPos = 0;

        for (int i = 0; i < sub.length(); ++i) {

            char c = sub.charAt(i);
            boolean hasLetter = false;

            while (lastPos < txt.length()) {
                char onTxt = txt.charAt(lastPos++);

                if (c == onTxt) {
                    hasLetter = true;
                    break;
                }
            }

            if (!hasLetter) {
                return false;
            }

        }

        return true;
    }
}
