package disjointset;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class CandyFriends {

    private static Map<Integer, Set<Integer>> groups;

    public static int countCandies(int friends_nodes, List<Integer> friends_from, List<Integer> friends_to,
                                   List<Integer> friends_weight) {
        groups = new HashMap<>();

        for (int i = 0; i < friends_from.size(); ++i) {

            int candy = friends_weight.get(i);
            if (!groups.containsKey(candy)) {
                Set<Integer> nodes = new HashSet<>();
                nodes.add(friends_from.get(i));
                nodes.add(friends_to.get(i));
                groups.put(candy, nodes);
            } else {
                Set<Integer> presents = groups.get(candy);
                if (!presents.contains(friends_from.get(i))) {
                    presents.add(friends_from.get(i));
                }

                if (!presents.contains(friends_to.get(i))) {
                    presents.add(friends_to.get(i));
                }
                groups.put(candy, presents);
            }
        }

        List<List<Integer>> sets = buildIndividualSets();

        //Sort by List size.
        Collections.sort(sets, ((o1, o2) -> Integer.compare(o2.size(), o1.size())));

        int product = 0;
        for (List<Integer> group : sets) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2, o1)));
            maxHeap.addAll(group);
            //Collections.sort(group);
            product = Math.max(product, Math.abs(maxHeap.poll() * maxHeap.poll())); //Math.abs(group.get(group.size() - 1) * group.get(group.size() - 2)));
        }
        return product;
    }

    private static List<List<Integer>> buildIndividualSets() {
        List<List<Integer>> sets = new LinkedList<>();
        for (Set<Integer> set: groups.values()) {
            List<Integer> listSet = new LinkedList<>();
            for (Integer i : set) {
                listSet.add(i);
            }
            sets.add(listSet);
        }
        return sets;
    }

}
