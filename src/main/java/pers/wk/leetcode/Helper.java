package pers.wk.leetcode;

import java.util.Random;

public class Helper {

    public static int[][] getRandomMatrix(int m, int n, int bound) {
        Random rand = new Random();

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(bound);
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
