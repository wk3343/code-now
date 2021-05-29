package pers.wk.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(random.nextInt(100));
        }
        Integer[] input = list.toArray(new Integer[0]);
        sort(input, 0, input.length - 1);

        System.out.println(Arrays.asList(input));
    }

    public static void sort(Integer[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        int m = start;
        int l = start + 1;
        int r = end;
        boolean swi = true;
        while (l <= r) {
            if (swi) {
                if (input[r] >= input[m]) {
                    r--;
                } else {
                    int temp = input[r];
                    input[r] = input[m];
                    input[m] = temp;
                    m = r;
                    swi = false;
                }
            } else {
                if (input[l] <= input[m]) {
                    l++;
                } else {
                    int temp = input[l];
                    input[l] = input[m];
                    input[m] = temp;
                    m = l;
                    swi = true;
                }
            }
        }
        System.out.println(String.format("%d %d %s", start, end, Arrays.asList(input)));
        sort(input, start, m-1);
        sort(input, m + 1, end);
    }
}
