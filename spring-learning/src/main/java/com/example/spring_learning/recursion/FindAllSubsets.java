package com.example.spring_learning.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllSubsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = findAllSubsets(arr);

        List<List<Integer>> resWithDuplicates = findAllSubsets(new int[]{1,2,2});

        for (List<Integer> subset : resWithDuplicates) {
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        List<List<Integer>> result = findAllSubsets(arr);
        List<List<Integer>> resultWithSumEqualToTarget = sumOfSubSet(result, 3);

        for (List<Integer> subset : resultWithSumEqualToTarget) {
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> sumOfSubSet(List<List<Integer>> subsets, int target) {
        return subsets.stream().filter(subset -> subset.stream().mapToInt(Integer::intValue).sum() == target)
                .collect(Collectors.toList());
    }

    private static List<List<Integer>> findAllSubsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subArray = new ArrayList<>();
        subsetWithDuplicates(0, nums, result, subArray);
        return result;
    }

    private static void subsetRec(int i, int[] nums, List<List<Integer>> result, List<Integer> subArray) {
        if(i==nums.length) {
            result.add(new ArrayList<>(subArray));
            return;
        }

        subsetRec(i+1, nums, result, subArray);
        subArray.add(nums[i]);

        subsetRec(i+1, nums, result, subArray);
        subArray.remove(subArray.size() - 1);
    }

    private static void subsetWithDuplicates(int i, int[] nums, List<List<Integer>> result, List<Integer> subArr) {
        result.add(new ArrayList<>(subArr));
        for (int index=i; index<nums.length; index++) {
            if (index > i && nums[index] == nums[index - 1]) continue;
            subArr.add(nums[index]);
            subsetWithDuplicates(index + 1, nums, result, subArr);
            subArr.remove(subArr.size() - 1);
        }
    }
}
