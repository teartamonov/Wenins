package search;

//[0, 1, 1, 0, 1, 0, 0]
//[1, 0, 0, 1, 0, 0, 1]
//[1, 0, 0, 1, 0, 0, 0]
//[0, 1, 1, 0, 1, 1, 0]
//[1, 0, 0, 1, 0, 0, 0]
//[0, 0, 0, 1, 0, 0, 1]
//[0, 1, 0, 0, 0, 1, 0]

import java.util.*;

public class Search {
    public static int BFS(int[][] adjMatrix, int start, int goal){
        int len = adjMatrix.length;
        int[] visited = new int[len];
        int[] path = new int[len];
        Arrays.fill(path, 999);
        path[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int curr;
        while(!queue.isEmpty()) {
            curr = queue.poll();
            visited[curr] = 1;
            for (int i = 0; i < len; ++i) {
                if (adjMatrix[curr][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    path[i] = Math.min(path[curr] + 1, path[i]);
                }
            }
        }
        if (visited[goal] == 0) return -1;
        else return path[goal];
    }
}
