package graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RatioVertexTest {

    private RatioVertex a;
    private RatioVertex b;
    private RatioVertex c;
    private RatioVertex d;

    @BeforeEach
    public void setup() {
        a = new RatioVertex("A", 1.125f);

        b = new RatioVertex("B", .75f);

        a.addEdge(b);

        c = new RatioVertex("C", .5f);

        b.addEdge(c);

        d = new RatioVertex("D", 2f);

        a.addEdge(d);

        c.addEdge(d);
    }

    @Test
    public void testCalculateRatio() {
        RatioVertex ratioCalculator = new RatioVertex();
        List<RatioVertex.RatioRate> calculatedRatio = ratioCalculator.calculateRatio(a);
        Assertions.assertNotNull(calculatedRatio);
    }
}
