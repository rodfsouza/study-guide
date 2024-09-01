package string;

public class SearchSubSequence2 {

    public boolean isSubSequence(String s, String t) {
        if (t == null || s == null) {
            return false;
        }

        int lastPos = 0;
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            boolean hasLetter = false;

            while(lastPos < t.length()) {
                char onTxt = t.charAt(lastPos++);
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
