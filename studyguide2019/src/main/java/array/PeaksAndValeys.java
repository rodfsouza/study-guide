package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: {5,3,1,2,3}
 * Output: {5,1,3,2,3}
 */
public class PeaksAndValeys {

    public Object[] sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }

        List<Integer> peaks = new ArrayList<>();
        List<Integer> valeys = new ArrayList<>();
        List<Integer> remaining = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; ++i) {
            int left = (i - 1 < 0) ? i : i - 1;
            int right = (i + 1 > (arr.length - 1)) ? i : i + 1;

            if (arr[i] <= arr[left] && arr[i] <= arr[right]) {
                valeys.add(arr[i]);
            } else if (arr[i] >= arr[left] && arr[i] >= arr[right]) {
                peaks.add(arr[i]);
            } else {
                remaining.add(arr[i]);
            }
        }

        int peakSize = peaks.size() - 1;
        int valeySize = valeys.size() - 1;

        int peak = 0;
        int valey = 0;
        while (peak <= peakSize && valey <= valeySize) {
            result.add(peaks.get(peak++));
            result.add(valeys.get(valey++));
        }

        while (peak <= peakSize) {
            result.add(peaks.get(peak++));
        }

        while (valey <= valeySize) {
            result.add(valeys.get(valey++));
        }

        for (int i = 0; i < remaining.size(); ++i) {
            result.add(remaining.get(i));
        }

        return result.toArray();
    }
}
