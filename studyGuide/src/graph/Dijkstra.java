package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class Dijkstra {

    public static void main(String... args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.add(nodeA);
        graph.add(nodeB);
        graph.add(nodeC);
        graph.add(nodeD);
        graph.add(nodeE);
        graph.add(nodeF);

        List<Node> nodes = graph.shortestPath(nodeA).getNodes().stream().sorted().collect(Collectors.toList());
        for (int i = 0; i <  nodes.size(); i++) {
            System.out.print(String.format(nodes.get(i).getName() + "(%s)->", nodes.get(i).getDistance()));
        }

    }

    private static class Graph {
        private Set<Node> nodes = new HashSet<>();

        Set<Node> getNodes() {
            return new HashSet<>(nodes);
        }

        void add(Node node) {
            Objects.requireNonNull(node);
            nodes.add(node);
        }

        Graph shortestPath(Node source) {
            Objects.requireNonNull(source);

            Set<Node> settled = new HashSet<>();
            PriorityQueue<Node> unsettled = new PriorityQueue<>();

            source.distance = 0;
            unsettled.offer(source);

            while(!unsettled.isEmpty()) {
                Node cur = unsettled.poll();

                for (Map.Entry<Node, Integer> adj : cur.getAdjacentNodes().entrySet()) {
                    Node adjacent = adj.getKey();
                    Integer weight = adj.getValue();

                    if (!settled.contains(adjacent)) {
                        calcMinimumDistance(adjacent, weight, cur);
                        unsettled.offer(adjacent);
                    }
                }
                settled.add(cur);
            }
            return this;
        }

        private void calcMinimumDistance(Node eval, int weight, Node source) {
            Integer sourceDistance = source.getDistance();

            if (sourceDistance + weight < eval.getDistance()) {
                List<Node> shortestPath = new LinkedList<>(source.getShortestPath());
                shortestPath.add(source);
                eval.setDistance(sourceDistance + weight);
                eval.setShortestPath(shortestPath);
            }
        }
    }

    private static class Node implements Comparable {
        private String name;
        private List<Node> shortestPath = new LinkedList<>();
        private Integer distance = Integer.MAX_VALUE;
        Map<Node, Integer> adjacentNodes = new HashMap<>();

        Node (final String name) {
            this.name = name;
        }

        void addDestination(final Node destination, int distance) {
            Objects.requireNonNull(destination);
            adjacentNodes.put(destination, distance);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Node> getShortestPath() {
            return new LinkedList<>(shortestPath);
        }

        public void setShortestPath(List<Node> shortestPath) {
            this.shortestPath = new LinkedList<>(shortestPath);
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

        public Map<Node, Integer> getAdjacentNodes() {
            return new HashMap<>(adjacentNodes);
        }

        public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
            this.adjacentNodes = new HashMap<>(adjacentNodes);
        }

        @Override
        public int compareTo(Object o) {
            Node that = (Node) o;
            return this.getDistance().compareTo(that.getDistance());
        }
    }
}
