package array;

public class KokoEatingBananas {

    public int minEatingSpeed2(int[] piles, int h) {
        int left = 1; int right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int middle = (right + left)  / 2;
            int hoursSpent = 0;

            for (int pile : piles) {
                hoursSpent += (int) Math.ceil(pile / middle);
            }

            if (hoursSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return right;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int currSpeed = 1;

        while (true) {
            int hoursSpent = 0;
            for (int pile : piles) {
                hoursSpent += (int) Math.ceil(pile / currSpeed);
                if (hoursSpent > h) {
                    break;
                }
            }

            if (hoursSpent <= h) {
                return currSpeed;
            }
            currSpeed++;
        }
    }
}
