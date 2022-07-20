package com.techelevator.projects.dao;

import com.techelevator.projects.model.Department;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JdbcDepartmentDaoTest extends BaseDaoTest {

    private static final Department DEPARTMENT_1 = new Department(1L, "Department 1");
    private static final Department DEPARTMENT_2 = new Department(2L, "Department 2");

    private JdbcDepartmentDao sut;

    @Before
    public void setup() {
        sut = new JdbcDepartmentDao(dataSource);
    }

    @Test
    public void getDepartment_returns_correct_department_for_id() {
        Department department = sut.getDepartment(1L);
        Assert.assertNotNull("getDepartment returned null", department);
        assertDepartmentsMatch("getDepartment returned wrong or partial data", DEPARTMENT_1, department);

        department = sut.getDepartment(2L);
        Assert.assertNotNull("getDepartment returned null", department);
        assertDepartmentsMatch("getDepartment returned wrong or partial data", DEPARTMENT_2, department);
    }

    @Test
    public void getDepartment_returns_null_when_id_not_found() {
        Department department = sut.getDepartment(99L);
        Assert.assertNull("getDepartment failed to return null for id not in database", department);
    }

    @Test
    public void getAllDepartments_returns_list_of_all_departments() {
        List<Department> departments = sut.getAllDepartments();

        Assert.assertEquals("getAllDepartments failed to return all departments", 2, departments.size());
        assertDepartmentsMatch("getAllDepartments returned wrong or partial data", DEPARTMENT_1, departments.get(0));
        assertDepartmentsMatch("getAllDepartments returned wrong or partial data", DEPARTMENT_2, departments.get(1));
    }

    @Test
    public void updated_department_has_expected_name_when_retrieved() {
        Department department = sut.getDepartment(1L);
        Assert.assertNotNull("can't test updateDepartment until getDepartment is working", department);
        department.setName("Test");

        sut.updateDepartment(department);

        Department updatedDept = sut.getDepartment(1L);
        Assert.assertEquals("updateDepartment failed to change department name in database", "Test", updatedDept.getName());
    }

    private void assertDepartmentsMatch(String message, Department expected, Department actual) {
        Assert.assertEquals(message, expected.getId(), actual.getId());
        Assert.assertEquals(message, expected.getName(), actual.getName());
    }

}
