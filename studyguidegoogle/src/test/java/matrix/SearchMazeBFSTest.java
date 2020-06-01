package matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchMazeBFSTest {

    @Test
    public void testSearchMaze() {
        final int[][] mat = new int[][] {
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };

        SearchMazeBFS searchMaze = new SearchMazeBFS(mat);
        int distance = searchMaze.calculateDistance(new SearchMazeBFS.Point(0,0),
            new SearchMazeBFS.Point(3,4));
        Assertions.assertTrue(distance > 0);
    }
}
