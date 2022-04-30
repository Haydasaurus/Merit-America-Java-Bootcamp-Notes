impport java.io.IOException;

public class CustomTesterApp {

    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        try {
            method3();
        }
        catch (TestException e) {
            System.err.println("The cause of this exception is " + e.getCause());
        }
    }

    public static void method3() throws TestException{
        throws new TestException("It worked quite poorly, my good chap");
    }

    public static void method3() throws TestException{
        try {
            throw new IOException();
        }
        catch (IOException){
          throw new TestException(e);
        }
    }
}