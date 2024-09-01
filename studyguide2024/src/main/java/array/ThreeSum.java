package array;

import java.util.*;

public class ThreeSum {

    //-1,0,1,2,-1,-4 -> -4,-1,-1,0,1,2
    //0,1,1
    //0,0,0
    public List<List<Integer>> sum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        HashSet<Triplet> nonDuplicates = new HashSet<>();

        for (int i = 0; i < nums.length; ++i) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                        if (!nonDuplicates.add(new Triplet(nums[i], nums[j], nums[k]))) {
                            j++;
                            k--;
                            continue;
                        }
                        triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }

            return triplets;
    }

    public List<List<Integer>> sum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            //remove duplicates
            // && nums[i] == nums[i - 1]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum  = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    //remove duplicates
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    while (j< k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        return triplets;
    }

    private static class Triplet {
        int i;
        int j;
        int k;

        public Triplet(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Triplet && ((Triplet) obj).i == i && ((Triplet) obj).j == j && ((Triplet) obj).k == k;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(i) + Objects.hashCode(j) + Objects.hashCode(k);
        }
    }
}
