package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseScheduleTest {

    @Test
    public void testCourseSchedule() {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] prerequisites = new int[][]{{1, 0}};
        boolean result = courseSchedule.canFinish(2, prerequisites);
        assertTrue(result);
    }

    @Test
    public void testCourseSchedule2() {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] prerequisites = new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        boolean result = courseSchedule.canFinish2(20, prerequisites);
        assertFalse(result);
    }
}
