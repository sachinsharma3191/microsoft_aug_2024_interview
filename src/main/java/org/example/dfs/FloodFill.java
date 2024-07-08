package org.example.dfs;

public class FloodFill {

    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor)
            return image;
        int color = image[sr][sc];
        dfs(image, sr, sc, newColor, color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int color) {
        // base case
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color)
            return;
        image[sr][sc] = newColor;
        // Initiate a directions array
        for (int[] dir : dirs) {
            int i = dir[0] + sr;
            int j = dir[1] + sc;
            // recurse on all neigbors.
            dfs(image, i, j, newColor, color);
        }
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
