package graph;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int[] prerequisite : prerequisites) {
            if (!visited.contains(prerequisite[0])) {
                topSort(prerequisite, visited, queue);
            }
        }

        if (queue.size() == numCourses) {
            int[] result = new int[numCourses];
            int i = 0;
            while (!queue.isEmpty()) {
                result[i++] = queue.poll();
            }
            return result;
        }

        return new int[] {0};
    }

    private void topSort(int[] prerequisites, Set<Integer> visited, Deque<Integer> queue) {
        visited.add(prerequisites[0]);

        for (int i = 1; i < prerequisites.length; i++) {
            if (!visited.contains(prerequisites[i])) {
                topSort(new int[] { prerequisites[i] }, visited, queue);
            }
        }
        queue.offer(prerequisites[0]);
    }

    //Khan's Algorithm
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph[prereq].add(course);
            inDegree[course]++;
        };

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> sortOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            sortOrder.add(course);

            for (int neighbor : graph[course]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (sortOrder.size() == numCourses) {
            //return sortOrder.stream().mapToInt(i -> i).toArray();
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; ++i) {
                result[i] = sortOrder.get(i);
            }
            return result;
        } else {
            return new int[0];
        }
    }
}
