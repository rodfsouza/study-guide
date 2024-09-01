package string;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement2(String s, int k) {
        char[] chars = s.toCharArray();

        Set<Character> charSet = new HashSet<>();
        for (char c : chars) {
            charSet.add(c);
        }

        int max = -1;
        for (char c : charSet) {
            int left = 0;
            int right = 0;
            int count = 0;
            int maxCount = 0;

            while (right < s.length()) {
                if (chars[right] != c) {
                    count++;
                }

                while (count > k) {
                    if (chars[left] != c) {
                        count--;
                    }
                    left++;
                }

                maxCount = Math.max(maxCount, right - left + 1);
                right++;
            }

            max = Math.max(max, maxCount);
        }

        return max;
    }

    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; //Array to store the count of each character for Capital letters
        int maxCount = 0; //Variable to store the maximum count of a character in the window
        int left = 0; //Variable to store the start of the window
        int maxLength = 0; //Variable to store the maximum length of the window

        for (int right = 0; right < s.length(); right++) {
            count[capitalCharToInt(s, right)]++; //Increment the count of the character at the right pointer
            maxCount = Math.max(maxCount, count[capitalCharToInt(s, right)]); //Update the maxCount

            //If the window size - maxCount > k, then we need to shrink the window
            while (right - left + 1 - maxCount > k) {
                count[capitalCharToInt(s, left)]--; //Decrement the count of the character at the left pointer
                left++; //Move the left pointer to the right
            }

            maxLength = Math.max(maxLength, right - left + 1); //Update the maxLength
        }

        return maxLength;
    }

    private static int capitalCharToInt(String s, int pos) {
        return s.charAt(pos) - 'A';
    }
}
