package com.techelevator.projects.dao;

import com.techelevator.projects.model.Employee;

import java.util.List;

public interface EmployeeDao {

	/**
	 * Gets all employees from the datastore and returns them in a List
	 * 
	 * @return all the employees as Employee objects in a List
	 */	
	public List<Employee> getAllEmployees();

	/**
	 * Find all employees whose names contain the search strings. Returned employees should
	 * match both first and last name search strings. If a search string is blank,
	 * ignore it. If both strings are blank, return all employees.
	 * Be sure to use ILIKE for case-insensitive search matching!
	 * 
	 * @param firstNameSearch the string to search for in the first_name, ignore if blank
	 * @param lastNameSearch the string to search for in the last_name, ignore if blank
	 * @return all employees whose name matches as Employee objects in a List
	 */
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch);

	/**
	 * Get all of the employees that are on the project with the given id.
	 *
	 * @param projectId the project id to get the employees from
	 * @return all the employees assigned to that project as Employee objects in a List
	 */
	public List<Employee> getEmployeesByProjectId(Long projectId);

	/**
	 * Assign an employee to a project
	 *
	 * @param projectId the project to put the employee on
	 * @param employeeId the employee to assign
	 */
	public void addEmployeeToProject(Long projectId, Long employeeId);

	/**
	 * Unassign the employee from a project.
	 *
	 * @param projectId the project to remove the employee from
	 * @param employeeId the employee to remove
	 */
	public void removeEmployeeFromProject(Long projectId, Long employeeId);

	/**
	 * Get all of the employees that aren't assigned to any project.
	 *
	 * @return all the employees not on a project as Employee objects in a List
	 */
	public List<Employee> getEmployeesWithoutProjects();

}
