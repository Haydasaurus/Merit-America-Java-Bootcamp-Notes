package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    public HomeworkAssignment (int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public String getLetterGrade() {
        double grade = ((double) this.earnedMarks / this.possibleMarks) * 100;
        int percentageOfGrade = (int)grade;
        if (percentageOfGrade >= 90) {
            return "A";
        } else if (percentageOfGrade >= 80) {
            return "B";
        } else if (percentageOfGrade >= 70) {
            return "C";
        } else if (percentageOfGrade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }
}