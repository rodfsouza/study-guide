package graph;

public class GraphMain {

    public static void main(String[] args) {
        Digraph2 g = new Digraph2(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        //g.addEdge(2, 5);

//        Stack<Integer> topOrder = g.topologicalSort();
//        while (!topOrder.isEmpty()) {
//            System.out.print(topOrder.pop() + " ");
//        }
//
//        System.out.println();
//
//        for (int i : g.kahnTopologicalSort()) {
//            System.out.print(i + " ");
//        }

        for (Object o : g.topologicalOrder()) {
            System.out.print(o + " ");
        }

        System.out.println();

        for (Object o : g.topologicalSortDfs()) {
            System.out.print(o + " ");
        }
    }
}
