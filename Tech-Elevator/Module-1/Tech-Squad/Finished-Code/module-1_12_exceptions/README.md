## Throw and catch exceptions

In this exercise, you'll experiment with ways to throw and catch exceptions

1. Open ExceptionTesterApp.java and review its code. 
   Run this class to get a feel for how it works.

2. Add code to method3() that throws an unchecked exception
   by attempting to divide an integer by zero. Compile and run 
   the application and note where the exception is thrown.

3. Delete the code you just added to method3(). Then, add the following statements

`BufferedReader in = new BufferedReader(new FileReader("products.ran"));`  
`String line = in.readLine();`

   The constructor for this class
   throws a checked exception named FileNotFoundException. 
   Note the error message that indicates that you haven't handled
   the exception. If this error message isn't shown, compile
   the class to display the error message.

4. Add throws clauses to all of the methods including the main() method.
   Then, run the application to see how a checked exception can
   propagate all the way out of an application.

5. Add the code necessary to handle the FileNotFoundException in method1().
   To do that, you'll need to remove the throws clauses from the main() method
   and method1(), and you'll need to add a try statement to method1() that
   catches the exception. The catch block should display an appropriate error
   message. Run the application to make sure the exception handler works.
   
## Create a custom class

In this exercise, you'll experiment with custom classes and chained exceptions.

1. Create a custom checked exception class named TestException
   that contains two constructors: one that accepts no parameters and one that accept a message.

2. Open the CustomTesterApp class. Then, add a statement to method3() 
   that throws a TestException without a message. Add the code necessary
   to catch this exception in method2(). The catch block should print a
   message of your choice at the console. Run the application to make sure it works correctly.

3. Modify your solution so a custom message of your choice is passed to the
   TestException and is then displayed in the catch block. Run the application to
   make sure the custom message is displayed correctly.

4. Add another constructor to the TestException class that accepts a Throwable object as a parameter.

5. Add a try statement to method3(). The try block should
   throw an IOException, and the catch block should throw a TestException,
   passing the IOException to its constructor.

6. Modify the catch block in method2() that catches the TestException
   so it prints a message that gives information about the exception 
   and its underlying cause. Run the application to make sure it works correctly.