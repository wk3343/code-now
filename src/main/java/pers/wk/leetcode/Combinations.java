package pers.wk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> tempList = new ArrayList();

        dfs(n, 1, k, result, tempList);
        return result;
    }

    /**
     * 每一个数字要么出现要么不出现，这样就构成了一个二叉树，使用dfs+回溯+剪枝就可以得到答案
     */
    public static void dfs(int n, int level, int k, List<List<Integer>> result, List<Integer> tempList) {
        if (tempList.size() == k) {
            System.out.println("size reaches k");
            List<Integer> targetList = new ArrayList();
            targetList.addAll(tempList);
            result.add(targetList);
            return;
        }
        if (tempList.size() + (n - level + 1) < k) {
            return;
        }

        tempList.add(level);
        dfs(n, level + 1, k, result, tempList);
        System.out.println("size = " + tempList.size());
        tempList.remove(tempList.size() - 1);
        dfs(n, level+1,k,result, tempList);
    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
}
