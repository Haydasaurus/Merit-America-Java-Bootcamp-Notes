# Use objects in the Area and Perimeter application

This exercise guides you through the process of converting an Area and Perimeter application from a procedural application to an object-oriented application.

## Create and use an object

1. Review the code for the AreaAndPerimeterApp class.

2. Create a class named Rectangle and store it in the same package as the AreaAndPerimeterApp class.

3. In the Rectangle class, add instance variables for length and width. Then, code the get and set methods for these instance variables. If possible, use your IntelliJ to generate the get and set methods.

4. Add a constructor with no parameters that initializes the length and width to 0.

5. Add a get method that calculates the area of the rectangle and returns a double value for the result. If you want, you can copy the code that performs this calculation from the AreaAndPerimeterApp class.

6. Add a get method that returns the area as a String object with standard numeric formatting and a minimum of three decimal places. To make it easy to refer to the NumberFormat class, you should add an import statement for it.

7. Repeat the previous two steps for the perimeter.

8. Open the AreaAndPerimeterApp class. Then, add code that creates a Rectangle object and sets its length and width.

9. Modify the code that displays the calculations so it uses the methods of the Rectangle object to get the area and perimeter of the rectangle.

10. Remove any leftover code from the AreaAndPerimeter App class that's unnecessary, including any unnecessary import statements.

11. Run the application and test it with valid data. It should calculate the area and perimeter for a rectangle.

## Overload the constructor

12. Open the Rectangle class. Then, overload the constructor by adding a second constructor that accepts two parameters: length and width. This constructor should set the length and width of the rectangle to the values supplied by these parameters.

13. Open the AreaAndPerimeterApp class. Then, modify its code so it uses this constructor instead of the constructor with no parameters.

14. Run the application and test it to make sure it still works correctly.

