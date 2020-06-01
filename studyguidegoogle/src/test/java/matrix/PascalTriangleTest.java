package matrix;

import org.junit.jupiter.api.Test;

import java.util.List;

public class PascalTriangleTest {

    @Test
    public void testCreateTriangle() {
        PascalTriangle triangle = new PascalTriangle();
        List<List<Integer>> pascalTriangle = triangle.generate(5);
        for (List<Integer> layer : pascalTriangle) {
            for (int i : layer) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }
}
