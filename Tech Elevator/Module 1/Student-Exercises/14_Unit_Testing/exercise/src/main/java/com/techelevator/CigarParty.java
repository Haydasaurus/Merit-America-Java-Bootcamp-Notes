package com.techelevator;

public class CigarParty {

    /*
     When squirrels get together for a party, they like to have cigars. A squirrel party is successful
     when the number of cigars is between 40 and 60, inclusive. Unless it is the weekend, in which case
     there is no upper bound on the number of cigars. Return true if the party with the given values is
     successful, or false otherwise.
     haveParty(30, false) → false
     haveParty(50, false) → true
     haveParty(70, true) → true
     */
    public boolean haveParty(int cigars, boolean isWeekend) {
        int minimumCigarCount = 40;
        int maximumCigarCount = 60;

        boolean hasMinimumCigars = cigars >= minimumCigarCount;
        boolean withinMaxRangeOfCigars = (!isWeekend && cigars <= maximumCigarCount) || isWeekend;
        boolean successful = hasMinimumCigars && withinMaxRangeOfCigars;

        return successful;
    }

}
