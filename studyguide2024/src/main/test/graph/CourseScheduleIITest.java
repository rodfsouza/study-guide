package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseScheduleIITest {

    @Test
    public void testFindOrder() {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        CourseScheduleII cs = new CourseScheduleII();
        int[] result = cs.findOrder(numCourses, prerequisites);
        assertEquals(4, result.length);

        int[] expected = {0, 1, 2, 3};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFindOrder2() {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        CourseScheduleII cs = new CourseScheduleII();
        int[] result = cs.findOrder(numCourses, prerequisites);
        assertEquals(2, result.length);

        int[] expected = {0, 1};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFindOrder3Empty() {
        int numCourses = 1;
        int[][] prerequisites = new int[][]{};
        CourseScheduleII cs = new CourseScheduleII();
        int[] result = cs.findOrder(numCourses, prerequisites);
        assertEquals(1, result.length);
        int[] expected = {0};
        assertArrayEquals(expected, result);
    }
}
