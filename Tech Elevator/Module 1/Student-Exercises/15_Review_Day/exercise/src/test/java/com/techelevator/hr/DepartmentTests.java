package com.techelevator.hr;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DepartmentTests {

    @Test
    public void transferEmployeeIn() {

        Department oldDept = new Department("Old Department");
        Department newDept = new Department("New Department");

        Employee employee = new Employee("Test","Test");
        employee.setDepartment(oldDept);
        newDept.transferEmployeeIn(employee);

        List<Employee> oldDeptEmployees = oldDept.getDepartmentEmployees();
        List<Employee> newDeptEmployees = newDept.getDepartmentEmployees();

        assertEquals("Old Department Employees size is not equal to 0", 0, oldDeptEmployees.size());
        assertEquals("New Department Employees size is not equal to 1", 1, newDeptEmployees.size());
        assertTrue("New Department Employees does not contain employee", newDeptEmployees.contains(employee));
    }

    @Test
    public void setDepartmentHead_TestManager() {
        Department department = new Department("Test Department");
        Manager manager = new Manager("Manager", "Managerson", "Manager of Testing", 100000);
        department.setDepartmentHead(manager);

        assertEquals("Manager is not equal to the department head.",manager,department.getDepartmentHead());
    }

    @Test
    public void setDepartmentHead_TestDirector() {
        Department department = new Department("Test Department");
        Manager manager = new Manager("Manager", "Managerson", "Director of Testing", 100000);
        department.setDepartmentHead(manager);

        assertEquals("Manager is not equal to the department head.",manager,department.getDepartmentHead());
    }

    @Test
    public void setDepartmentHead_BadTitle() {
        Department department = new Department("Test Department");
        Manager manager = new Manager("Manager", "Managerson", "Head of Testing", 100000);
        department.setDepartmentHead(manager);

        assertNull("Manager title does not start with Manager or Director and therefor should be null.", department.getDepartmentHead());
        assertNotEquals("Manager and department head are the same and they shouldn't be.",manager,department.getDepartmentHead());
    }
}
