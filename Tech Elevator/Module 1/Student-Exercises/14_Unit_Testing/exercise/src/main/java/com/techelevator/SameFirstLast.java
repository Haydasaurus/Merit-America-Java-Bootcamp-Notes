package com.techelevator;

public class SameFirstLast {

    /*
     Given an array of ints, return true if the array is length 1 or more, and the first element and
     the last element are equal.
     IsItTheSame([1, 2, 3]) → false
     IsItTheSame([1, 2, 3, 1]) → true
     IsItTheSame([1, 2, 1]) → true
     */
    public boolean isItTheSame(int[] nums) {
    	if (nums == null) return false;
    	else return nums.length > 0 && nums[0] == nums[nums.length - 1];
    }

}
