package pers.wk.leetcode;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        Random rand = new Random();

        int[][] islands = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                islands[i][j] = rand.nextInt(2);
                System.out.print(islands[i][j] + " ");
            }
            System.out.print("\n");
        }

        int result = findMaxArea(islands);
        System.out.println(result);

    }

    private static int findMaxArea(int[][] islands) {

        int max = -1;
        for (int i = 0; i < islands.length; i++) {
            for (int j = 0; j < islands[i].length; j++) {
                if (islands[i][j] == 1) {
                    max = Math.max(max, dfs(islands, i, j));
                }
            }
        }

        return max;
    }

    private static int dfs(int[][] islands, int i, int j) {
        if (i < 0 || j < 0 || i == islands.length || j == islands[0].length || islands[i][j] == 0) {
            return 0;
        }
        islands[i][j] = 0;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};

        int result = 1;
        for (int c = 0; c < 4; c++) {
            result += dfs(islands, i + di[c], j + dj[c]);
        }
        return result;
    }
}
