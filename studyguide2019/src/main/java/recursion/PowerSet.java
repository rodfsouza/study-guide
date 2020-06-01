package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public List<List<Integer>> subsets(List<Integer> set, int index) {
        List<List<Integer>> allSubSets;
        if (set.size() == index) {
            allSubSets = new ArrayList<>();
            allSubSets.add(new ArrayList<>());
            return allSubSets;
        } else {
            allSubSets = subsets(set, index + 1);
            int item = set.get(index);
            List<List<Integer>> more = new ArrayList<>();
            for (List<Integer> subset : allSubSets) {
                List<Integer> s = new ArrayList<>();
                s.addAll(subset);
                s.add(item);
                more.add(s);
            }
            allSubSets.addAll(more);
        }
        return allSubSets;
    }
}
