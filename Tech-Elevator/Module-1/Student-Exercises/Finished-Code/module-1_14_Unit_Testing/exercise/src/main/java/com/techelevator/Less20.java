package com.techelevator;

public class Less20 {
    /*
         Return true if the given non-negative number is 1 or 2 less than a multiple of 20. So for example 38
         and 39 return true, but 40 returns false.
         (Hint: Think "mod".)
         less20(18) → true
         less20(19) → true
         less20(20) → false
     */
    public boolean isLessThanMultipleOf20(int n) {
        boolean oneLessThanMultipleOf20 = n % 20 == 19;
        boolean twoLessThanMultipleOf20 = n % 20 == 18;

        return oneLessThanMultipleOf20 || twoLessThanMultipleOf20;
    }

}
