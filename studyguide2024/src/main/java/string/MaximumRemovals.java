package string;

public class MaximumRemovals {

    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length;
        int res = 0;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canBeSubsequence(s, p, removable, mid)) {
                res = Math.max(res, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    private boolean canBeSubsequence(String s, String p, int[] removable, int k) {
        boolean[] removed = new boolean[s.length()];
        for (int i = 0; i < k; i++) {
            removed[removable[i]] = true;
        }

        int j = 0;
        for (int i = 0; i < s.length() && j < p.length(); i++) {
            if (!removed[i] && s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }

        return j == p.length();
    }
}
