package com.techelevator;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeTest {

    @Before
    public void Employee_HasRequiredMembers() {
        Class klass = Employee.class;

        Constructor<Employee> constructor = SafeReflection.getConstructor(klass, Integer.TYPE, String.class,
                String.class, Double.TYPE);
        assertTrue("You do not have the required constructor(int, String, String, double)", constructor != null);

        Method method = SafeReflection.getMethod(klass, "getEmployeeId");
        assertTrue("Employee class needs the getEmployeeId() method.", method != null);
        assertTrue("getEmployeeId() method needs to return type: int", method.getReturnType() == Integer.TYPE);

        method = SafeReflection.getMethod(klass, "setEmployeeId", Integer.TYPE);
        assertTrue("Employee class should not have a setEmployeeId(int) method", method == null);

        method = SafeReflection.getMethod(klass, "getFirstName");
        assertTrue("Employee class needs the getFirstName() method.", method != null);
        assertTrue("getFirstName() method needs to return type: String", method.getReturnType() == String.class);

        method = SafeReflection.getMethod(klass, "setFirstName", String.class);
        assertTrue("Employee class should not have a setFirstName(String) method", method == null);

        method = SafeReflection.getMethod(klass, "getLastName");
        assertTrue("Employee class needs the getLastName() method.", method != null);
        assertTrue("getLastName() method needs to return type: String", method.getReturnType() == String.class);

        method = SafeReflection.getMethod(klass, "setLastName", String.class);
        assertTrue("Employee class needs the setLastName(String) method.", method != null);
        assertTrue("setLastName(String) method needs to return type: void", method.getReturnType() == void.class);

        method = SafeReflection.getMethod(klass, "getFullName");
        assertTrue("Employee class needs the getFullName() method.", method != null);
        assertTrue("getFullName() method needs to return type: String", method.getReturnType() == String.class);

        method = SafeReflection.getMethod(klass, "setFullName", String.class);
        assertTrue("Employee class should not have a setFullName(String) method", method == null);

        method = SafeReflection.getMethod(klass, "getDepartment");
        assertTrue("Employee class needs the getDepartment() method.", method != null);
        assertTrue("getDepartment() method needs to return type: String", method.getReturnType() == String.class);

        method = SafeReflection.getMethod(klass, "setDepartment", String.class);
        assertTrue("Employee class needs the setDepartment(String) method.", method != null);
        assertTrue("setDepartment(String) method needs to return type: void", method.getReturnType() == void.class);

        method = SafeReflection.getMethod(klass, "getAnnualSalary");
        assertTrue("Employee class needs the getAnnualSalary() method.", method != null);
        assertTrue("getAnnualSalary() method needs to return type: double", method.getReturnType() == Double.TYPE);

        method = SafeReflection.getMethod(klass, "setAnnualSalary", Double.TYPE);
        assertTrue("Employee class should not have a setAnnualSalary(double) method", method == null);

        method = SafeReflection.getMethod(klass, "raiseSalary", Double.TYPE);
        assertTrue("Employee class needs the raiseSalary(double) method.", method != null);
        assertTrue("raiseSalary(double) method needs to return type: void", method.getReturnType() == void.class);
    }

    @Test
    public void employeeConstructor() {
        Class klass = Employee.class;

        Constructor<Employee> constructor = SafeReflection.getConstructor(klass, Integer.TYPE, String.class,
                String.class, Double.TYPE);
        assertTrue("You do not have the required constructor(int, String, String, double)", constructor != null);
        try {
            Employee employee = constructor.newInstance(1, "Jane", "Smith", 100000.00);
            Method getEmployeeId = SafeReflection.getMethod(klass, "getEmployeeId");
            Method getFirstName = SafeReflection.getMethod(klass, "getFirstName");
            Method getLastName = SafeReflection.getMethod(klass, "getLastName");
            Method getAnnualSalary = SafeReflection.getMethod(klass, "getAnnualSalary");

            assertTrue("Passed 1 into constructor and expected EmployeeId property to hold 1.",
                    1 == (int) getEmployeeId.invoke(employee));
            assertTrue("Passed Jane into constructor and expected FirstName property to hold Jane.",
                    "Jane".equals((String) getFirstName.invoke(employee)));
            assertTrue("Passed Smith into constructor and expected LastName property to hold Smith.",
                    "Smith".equals((String) getLastName.invoke(employee)));
            assertTrue("Passed 100000.00 into constructor and expected AnnualSalary property to hold 100000.00.",
                    100000.00 == (double) getAnnualSalary.invoke(employee));
        } catch (Exception e) {
            fail("Failed to instantiate Employee");
        }
    }

    @Test
    public void employeeFullNameTest() {
        Class klass = Employee.class;

        Constructor<Employee> constructor = SafeReflection.getConstructor(klass, Integer.TYPE, String.class,
                String.class, Double.TYPE);
        assertTrue("You do not have the required constructor(int, String, String, double)", constructor != null);
        try {
            Employee employee = constructor.newInstance(1, "Jane", "Smith", 100000.00);
            Method getFullName = SafeReflection.getMethod(klass, "getFullName");

            assertTrue("Expected FullName to return derived value of 'LastName, FirstName'",
                    "Smith, Jane".equals((String) getFullName.invoke(employee)));
        } catch (Exception e) {
            fail("Failed to instantiate Employee");
        }
    }

    @Test
    public void employeeRaiseSalaryTest() {
        Class klass = Employee.class;

        Constructor<Employee> constructor = SafeReflection.getConstructor(klass, Integer.TYPE, String.class,
                String.class, Double.TYPE);
        assertTrue("You do not have the required constructor(int, String, String, double)", constructor != null);
        try {
            Employee employee = constructor.newInstance(1, "Jane", "Smith", 100000.00);
            Method getAnnualSalary = SafeReflection.getMethod(klass, "getAnnualSalary");
            Method raiseSalary = SafeReflection.getMethod(klass, "raiseSalary", Double.TYPE);

            raiseSalary.invoke(employee, new Object[] { 5.5 });
            assertTrue("Raised salary by 5.5%. Expected to go from 100000.00 to 105500.00",
                    105500.00 == (double) getAnnualSalary.invoke(employee));
        } catch (Exception e) {
            fail("Failed to instantiate Employee");
        }
    }
}
