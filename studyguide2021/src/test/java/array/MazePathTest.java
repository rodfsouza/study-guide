package array;

import array.MazePath.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static array.MazePath.*;
import static array.MazePath.Color.BLACK;
import static array.MazePath.Color.WHITE;

public class MazePathTest {

    @Test
    public void testMazePathSuccess() {
        Color[][] maze = {{BLACK, WHITE, WHITE, WHITE},
                        {BLACK, WHITE, BLACK, BLACK},
                        {WHITE, WHITE, WHITE, WHITE},
                        {WHITE, BLACK, BLACK, WHITE}};

        MazePath m = new MazePath();
        Coordinate start = new Coordinate(3,0);
        Coordinate exit = new Coordinate(0, 3);

        List<Coordinate> path = m.containsPath(maze, start, exit);

        Assertions.assertFalse(path.isEmpty());
    }
}
