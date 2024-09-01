package graph;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph[prereq].add(course);
            inDegree[course]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        if (queue.isEmpty()) {
            return false;
        }

        int nodesVisited = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            nodesVisited++;

            for (int nextCourse : graph[course]) {
                inDegree[nextCourse]--;

                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return nodesVisited == numCourses;
    }

    public boolean canFinish2(int numCourse, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourse];
        int[] inDegree = new int[numCourse];

        for (int i = 0; i < numCourse; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph[prereq].add(course);
            inDegree[course]++;
        }

        boolean[] visited = new boolean[numCourse];
        boolean[] inStack = new boolean[numCourse];
        for (int i = 0; i < numCourse; i++) {
            if (hasCycle(graph, visited, inStack, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<Integer>[] graph, boolean[] visited, boolean[] inStack, int course) {
        //contains cycle
        if (inStack[course]) {
            return true;
        }

        //already visited
        if (visited[course]) {
            return false;
        }

        visited[course] = true;
        inStack[course] = true;

        for (int nextCourse : graph[course]) {
            if (hasCycle(graph, visited, inStack, nextCourse)) {
                return true;
            }
        }

        //remove from stack
        inStack[course] = false;
        return false;
    }


}
