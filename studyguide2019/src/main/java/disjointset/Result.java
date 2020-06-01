package disjointset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Result {

    private static Map<Integer, List<Integer>> groupSets = new HashMap<>();

    /*
     * Complete the 'countCandies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER friends_nodes
     *  2. INTEGER_ARRAY friends_from
     *  3. INTEGER_ARRAY friends_to
     *  4. INTEGER_ARRAY friends_weight
     */

/*    public static int countCandies(int friends_nodes, List<Integer> friends_from, List<Integer> friends_to, List<Integer> friends_weight) {

        for (int i = 0; i < friend_from.size(); ++i) {

            int weight = friends_weight.get(i);
            if (!groupSets.containsKey(weight)) {
                List<Integer> edges = new LinkedList<>();
                edges.add(friends_from.get(i));
                edges.add(friends_to.get(i));
                groupSets.put(weight, edges);
            } else {
                List<Integer> presents = groupSets.get(weight);
                presents.add(friends_from.get(i), element);
                presents.add(friends_to.get(i));
                groupSets.put(weight, presents);
            }
        }

        DisjointSet disjointSet = buildSets(friends_nodes);
        for (int i = 0; i < friends_from.size(); ++i) {
            int from = friends_from.get(i);
            int to = friends_to.get(i);
            int candy = friends_weight.get(i);
            disjointSet.union(from, to, candy);
        }

        Map<Integer, List<Node>> sets = disjointSet.getSets();
        for (Map.Entry<Integer, List<Node>> kv : sets.entrySet()) {

        }

        return 0;
    }


    private static DisjointSet buildSets(int friends_nodes) {
        DisjointSet disjointSet = new DisjointSet();
        for (int i = 1; i < friends_nodes; ++i) {
            disjointSet.makeSet(i);
        }
        return disjointSet;
    }

    class DisjointSet {

        Map<Integer, Node> map = new HashMap<>();
        Map<Integer, List<Node>> sets = new LinkedList<>();

        public Map<Integer, List<Node>> getSets() {
            return sets;
        }

        public void makeSet(Integer id) {
            Node node = new Node();
            node.id = id;
            node.rank = 0;
            node.parent = node;
            map.putIfAbsent(id, node);
        }

        public void union(Integer id1, Integer id2, Integer candy) {
            Node node1 = map.get(id1);
            Node node2 = map.get(id2);

            Node parent1 = findSet(node1);
            Node parent2 = findSet(node2);

            if (parent1 == parent2) {
                return;
            }

            if (parent1.rank >= parent2.rank) {
                parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
                parent1.parent = parent1;
            } else {
                parent1.parent = parent2;
            }

            if (!sets.containsKey(candy)) {
                List<Node> nodes = new LinkedList<>();
                nodes.add(node1);
                nodes.add(node2);
                sets.put(candy, nodes);
            } else {
                List<Node> nodes = sets.get(candy);
                nodes.add(node1);
                nodes.add(node2);
                sets.put(candy, nodes);
            }
        }

        public Node findSet(Node node) {
            Node parent = node.parent;
            if (parent == node) {
                return parent;
            }
            node.parent = findSet(node.parent);
            return node.parent;
        }

        class Node {
            int id;
            int rank;
            Node parent;
        }
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int friends_nodes = Integer.parseInt(bufferedReader.readLine().trim());

        int friends_fromCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> friends_from = IntStream.range(0, friends_fromCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int friends_toCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> friends_to = IntStream.range(0, friends_toCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int friends_weightCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> friends_weight = IntStream.range(0, friends_weightCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.countCandies(friends_nodes, friends_from, friends_to, friends_weight);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }*/
}
