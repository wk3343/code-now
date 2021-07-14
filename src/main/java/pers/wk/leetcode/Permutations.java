package pers.wk.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        track(nums, result, 0);
        return result;
    }

    public static void track(int[] nums, List<List<Integer>> result, int level) {
        if (level == nums.length -1) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(list);
        }
        for (int i = level; i < nums.length; i++) {
            swap(nums, level, i);
            track(nums, result, level+1);
            swap(nums, level, i);
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
