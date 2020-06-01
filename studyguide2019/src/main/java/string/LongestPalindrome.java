package string;

public class LongestPalindrome {

    public int calculateRecursive(char str[],int start,int len){
        if(len == 1){
            return 1;
        }
        if(len ==0){
            return 0;
        }
        if(str[start] == str[start+len-1]){
            return 2 + calculateRecursive(str,start+1,len-2);
        }else{
            return Math.max(calculateRecursive(str, start+1, len-1),
                    calculateRecursive(str, start, len-1));
        }
    }

    public String longest(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String max_so_far = "";
        String max_ending_here = "";

        for (int i = 0; i < s.length(); ++i) {
            max_so_far = max_so_far + s.charAt(i);
            for (int j = i + 1; j < s.length(); ++j) {
                if (max_so_far.length() > max_ending_here.length() && isPalindrome(max_so_far)) {
                    max_ending_here = max_so_far;
                }
                max_so_far = max_so_far + s.charAt(j);
            }
        }

        return max_ending_here;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String currentMax = "";
        String max = "";

        for (int i = 0; i < s.length(); ++i) {
            currentMax = currentMax + s.charAt(i);

            if (max.length() < currentMax.length() && isPalindrome(currentMax)) {
                max = currentMax;
            }
        }
        return max;
    }

    private boolean isPalindrome(String s) {
        int mid = s.length()/2;
        for (int i = 0, j = s.length() - 1; i <= mid && j >= mid; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
