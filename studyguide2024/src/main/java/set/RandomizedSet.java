package set;

import java.util.*;

public class RandomizedSet {

    private final LinkedList<Integer> list;

    private final Map<Integer, Integer> mapPositions;

    private final Random random;

    private int seedInterval = 0;

    public RandomizedSet() {
        list = new LinkedList<>();
        mapPositions = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (mapPositions.containsKey(val)) {
            return false;
        }
        list.add(val);
        mapPositions.put(val, list.size() - 1);
        seedInterval++;
        return true;
    }

    public boolean remove(int val) {
        if (!mapPositions.containsKey(val)) {
            return false;
        }
        int position = mapPositions.get(val);

        int lastElement = list.get(list.size() - 1);
        list.set(position, lastElement);
        mapPositions.put(lastElement, position);

        list.remove(position);
        mapPositions.remove(val);
        seedInterval--;
        return true;
    }

    public int getRandom() {
        int rndIndex = random.nextInt(seedInterval);
        return list.get(rndIndex);
    }
}