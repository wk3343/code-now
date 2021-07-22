package pers.wk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        List<Integer> temp;


        for (int i = 1; i < (1 << length); i++) {
            temp = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);
                }
            }
            result.add(temp);
        }

        return result;
    }
}
