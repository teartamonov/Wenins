package search;

public class Main {
    public static void main(String[] args){
        int[][] arr = {
                {0, 1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(Search.BFS(arr, 0, 6));
    }
}
