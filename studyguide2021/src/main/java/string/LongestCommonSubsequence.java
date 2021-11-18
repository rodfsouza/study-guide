package string;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] track = new int[text1.length() + 1][text2.length() + 1];

        for (int row = 1; row < track.length; row++) {

            for (int col = 1; col < track[0].length; ++col) {

                if (text1.charAt(row - 1) == text2.charAt(col - 1)) {
                    track[row][col] = track[row - 1][col - 1] + 1;
                } else {
                    track[row][col] = Math.max(track[row - 1][col], track[row][col - 1]);
                }
            }
        }

        return track[text1.length()][text2.length()];
    }
}
