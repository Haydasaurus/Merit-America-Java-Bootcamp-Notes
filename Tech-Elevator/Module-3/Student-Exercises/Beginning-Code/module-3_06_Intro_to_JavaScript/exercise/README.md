# Intro to JavaScript exercises

For each exercise, create the function and implement it inside of `exercises.js`. The unit tests defined in `tests.js` look for these functions and call them using the signature shown in the following list. To view the results of the tests, open `tests.html` in a browser.

## Exercises

1. **sumDouble** Given two int values, return their sum. Unless the two values are the same, then return double their sum.

```javascript
sumDouble(1, 2) → 3
sumDouble(3, 2) → 5
sumDouble(2, 2) → 8

function sumDouble(x, y) {
	// do logic here
	// return result;
	return x + y;
}
```

2. **hasTeen** A number is "teen" if it's in the range 13..19 inclusive. Given three int values, return true if 1 or more of them are teen.

```javascript
hasTeen(13, 20, 10) → true
hasTeen(20, 19, 10) → true
hasTeen(20, 10, 13) → true
```
3. **lastDigit** Given two non-negative int values, return true if they have the same last digit, such as 27 and 57.

```javascript
lastDigit(7, 17) → true
lastDigit(6, 17) → false
lastDigit(3, 113) → true
```

4. **seeColor** Given a string, if the string begins with "red" or "blue" return that color string; otherwise, return the empty string.

```javascript
seeColor("redxx") → "red"
seeColor("xxred") → ""
seeColor("blueTimes") → "blue"
```

5. **oddOnly** Write a function that given an array of integer of any length, removes the even numbers, and returns a new array of just the odd numbers.

```javascript
oddOnly([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]) → [1, 3, 5, 7, 9, 11];
oddOnly([2, 4, 8, 32, 256]); → []
```

6. **frontAgain** Given a string, return true if the first two chars in the string also appear at the end of the string, as with "edited."

```javascript
frontAgain("edited") → true
frontAgain("edit") → false
frontAgain("ed") → true
```

7. **cigarParty** When squirrels get together for a party, they like to have cigars. A squirrel party is successful when the number of cigars is between 40 and 60, inclusive. If it's the weekend, there is no upper bound on the number of cigars. Write a squirrel party function that returns true if the party with the given values is successful, or false otherwise.

```javascript
cigarParty(30, false) → false
cigarParty(50, false) → true
cigarParty(70, true) → true
```

8. **fizzBuzz** Given a number, return a value according to the following rules:
If the number is multiple of 3, return "Fizz."
If the number is a multiple of 5, return "Buzz." 
If the number is a multiple of both 3 and 5, return "FizzBuzz."
In all other cases return the original number. 


```javascript
fizzBuzz(3) → "Fizz"
fizzBuzz(1) → 1
fizzBuzz(10) → "Buzz"
fizzBuzz(15) → "FizzBuzz"
fizzBuzz(8) → 8
```

9. **filterEvens** Write a function that filters an array to only include even numbers.

```javascript
filterEvens([]) → []
filterEvens([1, 3, 5]) → []
filterEvens([2, 4, 6]) → [2, 4, 6]
filterEvens([100, 8, 21, 24, 62, 9, 7]) → [100, 8, 24, 62]
```

10. **filterBigNumbers** Write a function that filters numbers greater than or equal to 100.

```javascript
filterBigNumbers([7, 10, 121, 100, 24, 162, 200]) → [121, 100, 162, 200]
filterBigNumbers([3, 2, 7, 1, -100, -120]) → []
filterBigNumbers([]) → []
```

11. **filterMultiplesOfX** Write a function to filter numbers that are a multiple of a parameter, `x` passed in.

```javascript
filterMultiplesOfX([3, 5, 1, 9, 18, 21, 42, 67], 3) → [3, 9, 18, 21, 42]
filterMultiplesOfX([3, 5, 10, 20, 18, 21, 42, 67], 5) → [5, 10, 20]
```

12. **createObject** Write a function that creates an object with a property called firstName, lastName, and age. Populate the properties with your values.

```javascript
createObject() →

{
	firstName,
	lastName,
	age
}
```

## Challenge exercises

The challenge exercises are optional, but slightly more difficult tasks for you to try. **These don't affect your grade.** The challenge exercises are in `challenge-exercises.js`. You can view the test results by opening `challenge-tests.html` in a browser.

1. **iqTest** Bob is preparing to pass an IQ test. The most frequent task in this test is to find out which one of the given numbers differs from the others. Bob observed that one number usually differs from the others in evenness. Help Bob: to check his answers, he needs a program that, among the given numbers, finds one that's different in evenness and returns the position of this number. _Keep in mind that your task is to help Bob solve a real IQ test, which means indexes of the elements start from 1, not 0_.

```javascript
iqTest("2 4 7 8 10") → 3 // third number is odd, while the rest are even
iqTest("1 2 1 1") → 2 // second number is even, while the rest are odd
iqTest("") → 0 // there are no numbers in the given set
iqTest("2 2 4 6") → 0 // all numbers are even, therefore there is no position of an odd number
```

2. **titleCase** Write a function that converts a string into title case, given an optional list of exceptions (minor words). The list of minor words is a string with each word separated by a space. Your function must ignore the case of the minor words string, it must behave the same whether `"of"` or `"Of"` is in the minor words string. If the first word is a minor word, don't convert it to lowercase.

* First argument (required): the original string.
* Second argument (optional): space-delimited list of minor words that must always be lowercase except for the first word in the string. The JavaScript tests pass undefined when this argument isn't used.

```javascript
titleCase('a clash of KINGS', 'a an the of') // should return: 'A Clash of Kings'
titleCase('THE WIND IN THE WILLOWS', 'The In') // should return: 'The Wind in the Willows'
titleCase('the quick brown fox') // should return: 'The Quick Brown Fox'
```
