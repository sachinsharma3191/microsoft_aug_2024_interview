package org.example.bfs;

import java.util.*;

public class FloodFill {

    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor)
            return image;
        return bfs(image, sr, sc, newColor);
    }

    public int[][] bfs(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> q = new LinkedList<>();
        int color = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            image[curr[0]][curr[1]] = newColor;
            for (int[] dir : dirs) {
                int i = dir[0] + curr[0];
                int j = dir[1] + curr[1];
                if(i >= 0 && i < image.length && j >= 0 && j < image[0].length && image[i][j] == color
                        && !visited[i][j]) {
                    q.add(new int[]{i, j});
                    // Mark Visited
                    visited[i][j] = true;
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;

        System.out.println("Original Image:");
        printImage(image);

        image = new FloodFill().floodFill(image, sr, sc, newColor);

        System.out.println("Image after DFS Flood Fill:");
        printImage(image);
    }


    public static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
