package com.techelevator.hr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ManagerTests {

    @Test
    public void hireEmployee() {
        Manager manager = new Manager("Manager", "Managerson");
        Department department = new Department("Test Department");
        manager.setDepartment(department);
        Employee employee = manager.hireEmployee("Test", "Testerson", "Tester of testing", 50000);

        assertEquals("Employee first name does not equal expected result.","Test", employee.getFirstName());
        assertEquals("Employee last name does not equal expected result.","Testerson", employee.getLastName());
        assertEquals("Employee title does not equal expected result.","Tester of testing", employee.getTitle());
        assertEquals("Employee salary does not equal expected result.",50000, employee.getSalary(), 0.0);
        assertEquals("Employee email does not equal expected result.","ttesterson@petelevator.com", employee.getEmail());
        assertEquals("Employee department does not equal expected result.",department, employee.getDepartment());
        assertTrue("Test Department does not include the new employee",department.getDepartmentEmployees().contains(employee));
    }
}
