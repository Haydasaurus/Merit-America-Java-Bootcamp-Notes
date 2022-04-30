# Use the abstract and final keywords

In this exercise, you'll experiment with the abstract and final keywords to see how they work.

## Use an abstract class with an abstract method

1. Review the provided code.

2. Open the `Product` class. Then, add the `abstrac` keyword to the class declaration.

3. In the `Product` class, add an abstract method named `getDisplayText()`. This method should accept no parameters, and it should return a `String` object.

4. Attempt to compile the application. This should display an error message that indicates that the `Book` and `Software` classes must override the `getDisplayText()` method.

5. Open the `Book` and `Software` classes. Then, add a `getDisplayText()` method to these classes that overrides the abstract `getDisplayText()` method of the `Product` class. One easy way to do that is to rename the `toString()` method to `getDisplayText()`.

6. Open the `ProductApp` class. Then, modify it so it calls the `getDisplayText()` method of a product object instead of the `toString()` method.

7. Run the application to make sure it works correctly.

## Use a final class

8. In the `Book` class, add the `final` keyword to its class declaration.

9. Create a new class named `UsedBook` that inherits the `Book` class. You don't need to include any code in the body of this class. This should display an error message that indicates that the `Book` class can't be inherited because it is final.

10. In the `Book` class, remove the `final` keyword from its class declaration.

11. Run the application to make sure it works correctly.

## Use a final method

12. In the `Book` class, add the `final` keyword to the `getDisplayText()` method.

13. Add a `getDisplayText()` method to the `UsedBook` class to override the `getDisplayText()` method of the `Book` class. This method can return an empty string. This should display an error message that indicates that the `getDisplayText()` method can't be overridden because it is final.

14. In the `Book` class, remove the `final` keyword from the `getDisplayText()` method.

15. Run the application to make sure it works correctly.
