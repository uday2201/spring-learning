package com.example.spring_learning.leetcode;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] numArr = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(insertPos(numArr, 9));


        int[] sortedRotatedArr = new int[]{6,7,8,9,1,2,3,4,5};
        System.out.println(searchInSortedRotatedArray(sortedRotatedArr, 9));
    }

    private static int insertPos(int[] nums, int i) {
        int left = 0, right = nums.length-1;
        while(left<=right) {
            int mid = left+(right-left)/2;
            if(nums[mid]==i) return mid;
            else if(nums[mid]>i) right = mid - 1;
            else left = mid+1;
        }
        return left;
    }

    private static int searchInSortedRotatedArray(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left<=right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[left] <= nums[mid]) { // left -> mid are sorted
                if(target>=nums[left] && target<nums[mid]) right = mid -1;
                else left = mid+1;
            } else {
                if(target<=nums[right] && target>nums[mid]) left = mid+1;
                else right = mid-1;
            }
        }
        return -1;
    }

}
