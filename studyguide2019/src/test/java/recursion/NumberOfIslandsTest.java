package recursion;

import org.junit.jupiter.api.Test;

public class NumberOfIslandsTest {

    @Test
    public void Test1() {
        int[][] matrix =   {{1,1,0,0,0},
                            {1,1,0,0,0},
                            {0,0,1,0,0},
                            {0,0,0,1,1}};

        NumberOfIslands ni = new NumberOfIslands();
        int numberOfRows = ni.countIslands(matrix);
        System.out.println("The number of islands: " + numberOfRows);
    }

    @Test
    public void Test2() {
        int[][] matrix = {{1,0,0}, {1,1,0}, {0,1,0}};

        NumberOfIslands ni = new NumberOfIslands();
        int numberOfRows = ni.countIslands(matrix);
        System.out.println("The number of islands: " + numberOfRows);
    }
}
