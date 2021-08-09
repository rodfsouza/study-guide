package string;

/*
You have a very large (1Million chars) string S consisting of lower case characters and you have a list of strings each of length less than 1000.
For each string, check if it is a subsequence of S.

A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements.
Eg. abc is a subsequence of abdc.

S = hiremeinmongodb
        m        db
mdb -> TRUE
dbm -> FALSE
iiih  -> FALSE
ee -> TRUE
eee -> FALSE

bool isSubsequent(String txt, String sub) {

}

*/
public class SearchSubSequence {

    public boolean isSubSequence(String txt, String sub) {
        if (txt == null) {
            return false;
        }

        if (sub == null) {
            return false;
        }

        int lastPos = 0;

        for(int i = 0; i < sub.length(); ++i) {
            char c = sub.charAt(i);
            boolean hasLetter = false;

            while(lastPos < txt.length()) {
                char onTxt = txt.charAt(lastPos++);
                if (c == onTxt) {
                    hasLetter = true;
                    break;
                }
                //lastPos++; Remember
            }

            if (!hasLetter) {
                return false;
            }
        }

        return true;
    }
}
