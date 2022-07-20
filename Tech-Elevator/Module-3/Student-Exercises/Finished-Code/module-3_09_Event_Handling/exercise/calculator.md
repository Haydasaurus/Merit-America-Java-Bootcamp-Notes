# Calculator Event Handling Exercise

In this exercise, you'll build a simple calculator. This calculator handles basic operations like addition, subtraction, multiplication, and division. The user interface for this project has already been created, so you'll focus on building out its functionality.

## Exercise instructions

To get started, open `/js/calculator.js`, and scroll down to the following line of code:

```js
document.addEventListener('LOADED_EVENT_GOES_HERE', () => {
```

The first step is to replace `LOADED_EVENT_GOES_HERE` with the appropriate event that notifies when the DOM content is ready to go. Inside of the anonymous function on that event listener is a series of comments. Follow the comments in order and when completed, the basic functions of a calculator work.

## Running the exercise tests

To run the exercise tests, run `npm install` to install the required dependencies. If you look in the `package.json`, you'll see two scripts for running the tests: `test` and `test-headless`.

If you want to run the tests in a UI mode, run the command `npm run test`. If you want to run the tests from the command line, run `npm run test-headless`.

If you want to see the tests for this exercise, they're located in `cypress/integration/calculator_spec.js`.
