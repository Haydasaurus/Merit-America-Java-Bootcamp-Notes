# Create and work with interfaces

## Create the interfaces

1. Review the code.

2. Note that this code includes an interface named Displayable that contains a single method named getDisplayText() that returns a String.

3. Open the DisplayableTestApp class. Then, note that it includes a method named display() that accepts a Displayable object as an argument.

4. Add an interface named DepartmentConstants that contains these three constants: ADMIN, EDITORIAL and MARKETING.

## Implement the interfaces

5. Open the Product class. Then, edit it so it implements the Displayable interface. To do that, add a getDisplay Text() method that returns a description of the product.

6. Open the Employee class. Then, edit it so it implements the Department Constants and Displayable interfaces. To do that, add a getDisplayText() method that uses the constants in the DepartmentConstants interface to include the department name and the employee's name in the string that it returns.

## Use the classes that implement the interfaces

7. Open the DisplayableTestApp class. Then, modify the variable that stores the Employee object so it is of the Displayable type.

8. Add code that passes the Displayable object to the static display() method that's coded at the end of this class.

9. Run the application to make sure that it displays the employee information.

10. Repeat the previous three steps for a Product object. When you're done, the console should look like this:

---
`Welcome to the Displayable Test Application`  
`John Smith (Editorial)`  
`Murach's Java Programming`
---

## Use a default method

11. In the Employee and Product classes, rename the getDisplayText() methods to toString() methods so they override the toString() method of the Object class. This should prevent the classses from compiling and display an error message that indicates that the classes don't implement the getDisplayText() method.

12. In the Displayable interface, modify the getDisplay Text() method so it's a default method. The code for this method should return the String object that's returned by the toString() method. This should allow the Employeee and Product classes to compile since they can now use the default method.

13. Run the application to make sure it works as before.
