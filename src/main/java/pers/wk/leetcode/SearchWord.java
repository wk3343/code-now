package pers.wk.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SearchWord {

    static Map<String, Boolean> map = new HashMap();

    public static void main(String[] args) {
        char[][] input = {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };

        String word = "abcced";
        System.out.println(exist(input, word));
    }

    public static boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean exist = dfs(board, chars, 0, i, j);
                if (exist) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, char[] chars, int level, int i, int j) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || (map.get(getKey(i, j)) != null && map.get(getKey(i, j)))) {
            return false;
        }
        boolean isCurrentMatched = board[i][j] == chars[level];
        if (!isCurrentMatched) {
            return false;
        }
        if (level == chars.length - 1) {
            return true;
        }
        map.put(getKey(i, j), true);

        boolean leftMatched = dfs(board, chars, level + 1, i, j - 1);

        boolean rightMatched = dfs(board, chars, level + 1, i, j + 1);

        boolean upMatched = dfs(board, chars, level + 1, i - 1, j);

        boolean downMatched = dfs(board, chars, level + 1, i + 1, j);

        map.put(getKey(i, j), false);

        return leftMatched || rightMatched || upMatched || downMatched;
    }

    public static String getKey(int i, int j) {
        return i + "-" + j;
    }
}
