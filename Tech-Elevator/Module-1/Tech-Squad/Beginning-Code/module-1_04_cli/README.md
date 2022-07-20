# Command-line programs

The purpose of this exercise is to provide students with the opportunity to practice and reinforce the skills they have learned during lecture related to building command line applications. In this exercise, you'll create two command-line applications.

## Learning objectives

After completing this exercise, you'll understand:

* How to create command line applications.
* How to prompt and accept user input in a command-line application.
* How to write output to the console in a command-line application.

## Evaluation criteria and functional requirements

* The project must not have any build errors.
* Appropriate variable names and data types are used.

### Make Change

Write a command line program which prompts the user for the total bill, and the amount tendered.
It should then display the change required.

```
Please enter the amount of the bill: 23.65
Please enter the amount tendered: 100.00
The change required is 76.35
```

### Martian Weight
In case you've ever pondered how much you weight on Mars, here's the calculation:
Wm = We* 0.378
where 'Wm' is the weight on Mars, and 'We' is the weight on Earth 
    
Write a command line program which accepts a series of Earth weights as command line arguments,
and displays each Earth weight as itself, and its Martian equivalent.

```
C:\dir\to\the\project\target\classes> java com.techelevator.MartianWeight 98 235 185
98 lbs. on Earth, is 37 lbs. on Mars.
235 lbs. on Earth, is 88 lbs. on Mars.
185 lbs. on Earth, is 69 lbs. on Mars.
```



## Getting started

1. [Import](https://book.techelevator.com/v2_4/content/guides/intellij.html#import-a-project) the command-line programs exercises project into IntelliJ.
2. For each exercise, navigate to the corresponding Java file, and provide the code needed to fulfill the requirements in the `main` method.
3. [Run](https://book.techelevator.com/v2_4/content/guides/intellij.html#running-java-applications) the application to verify that it works as expected.

## Tips and tricks

* Take the time to review each of the tasks for the expected output, as well as the text you must use to prompt the user for information. Try to get this to match the specification as closely as possible when working through the exercise.
