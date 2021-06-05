package pers.wk.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 */
public class PacificAtlantic {

    public static void main(String[] args) {
//        int[][] heights = Helper.getRandomMatrix(10, 10, 6);
//        Helper.printMatrix(heights);

        int[][] heights = {
                {1, 2, 2, 3, (5)},
                {3, 2, 3, (4), (4)},
                {2, 4, (5), 3, 1},
                {(6), (7), 1, 4, 5},
                {(5), 1, 1, 2, 4}};

        System.out.println(pacificAtlantic(heights));

    }

    private static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights[0].length;
        int n = heights.length;

        int[][] flags = new int[m][n];

        // i = 0/m j = 0~n
        // j = 0/n i = 0~m
        for (int j = 0; j < n; j++) {
            dfs(heights, flags, 0, j, 1);
            dfs(heights, flags, m - 1, j, 2);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, flags, i, 0, 1);
            dfs(heights, flags, i, n - 1, 2);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flags[i][j] == 3) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private static void dfs(int[][] heights, int[][] flags, int i, int j, int flag) {
        if (flags[i][j] == flag || flags[i][j] == 3) {
            return;
        }
        flags[i][j] += flag;
        int[] iOffset = {1, -1, 0, 0};
        int[] jOffset = {0, 0, 1, -1};
        for (int index = 0; index < 4; index++) {
            int nextI = i + iOffset[index];
            int nextJ = j + jOffset[index];
            if (nextI < 0 || nextJ < 0 || nextI > heights[0].length - 1 || nextJ > heights.length - 1 || heights[nextI][nextJ] < heights[i][j]) {
                continue;
            }
            dfs(heights, flags, nextI, nextJ, flag);
        }
    }
}
