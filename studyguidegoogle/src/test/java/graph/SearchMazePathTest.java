package graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchMazePathTest {

    private List<List<SearchMazePath.Color>> maze;

    @BeforeEach
    public void setup() {
        maze = new ArrayList<>(4);
        for (int i = 0; i < 4; ++i) {
            maze.add(new ArrayList<>());
        }

    }

    @Test
    public void testSearchMazePath() {
        Assertions.assertNotNull(maze);
    }
}
