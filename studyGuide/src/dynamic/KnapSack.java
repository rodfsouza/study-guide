package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapSack {

    public static void main(String... args) {
        Item item = new Item(5, 50);
        Item item2 = new Item(2, 40);
        List<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item);
        items.add(item2);

        System.out.println(knapsack(items, 10));
    }

    public static int knapsack(List<Item> items, int capacity) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int[][] sack = new int[items.size()][capacity + 1];
        for (int[] v : sack) {
            Arrays.fill(v, -1);
        }

        return knapsack(items, items.size() - 1, capacity, sack);
    }

    private static int knapsack(List<Item> items, int k, int availableCapacity, int[][] sack) {
        if (k < 0) {
            return 0;
        }

        if (sack[k][availableCapacity] == -1) {
            int withoutItem = knapsack(items, k -1, availableCapacity, sack);

            int withCurrItem = availableCapacity < items.get(k).weight
                ? 0
                : items.get(k).value + knapsack(items, k -1, availableCapacity - items.get(k).weight, sack);

            sack[k][availableCapacity] = Math.max(withoutItem, withCurrItem);
        }
        return sack[k][availableCapacity];
    }

    private static class Item {
        int weight;
        int value;

        Item(final int weight, final int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
