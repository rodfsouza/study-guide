package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatioVertex {

    String label;
    float ratio;
    private List<RatioVertex> edges;

    public RatioVertex() {

    }

    public RatioVertex(String label, float ratio) {
        this.label = label;
        this.ratio = ratio;
        edges = new ArrayList<>();
    }

    public void addEdge(RatioVertex edge) {
        edges.add(edge);
    }

    public List<RatioRate> calculateRatio(RatioVertex node) {
        if (node == null)
            return Collections.emptyList();

        List<RatioRate> rates = new ArrayList<>();

        for (RatioVertex edge : node.edges) {
            calculateRationHelper(node, edge, rates);
        }
        return rates;
    }

    private List<RatioRate> calculateRationHelper(RatioVertex current, RatioVertex next, List<RatioRate> ratios) {
        if (current == null) {
            return null;
        }

        if (next != null) {
            float calculatedRatio = next.ratio == 0 ? current.ratio : current.ratio / next.ratio;
            RatioRate calculateRate = new RatioRate(current.label, next.label, calculatedRatio);
            ratios.add(calculateRate);
        }

        for (RatioVertex n : next.edges) {
            calculateRationHelper(next, n, ratios);
        }

        return ratios;
    }

    public class RatioRate {
        String a;
        String b;
        float calculatedRatio;

        public RatioRate(String labelA, String labelB, float calculatedRatio) {
            this.a = labelA;
            this.b = labelB;
            this.calculatedRatio = calculatedRatio;
        }
    }
}
