package com.techelevator.projects.dao;

import com.techelevator.projects.model.Project;

import java.util.List;

public interface ProjectDao {

	/**
	 * Get a project from the datastore that has the given id.
	 * If the id is not found, return null.
	 *
	 * @param projectId the id of the project to get from the datastore
	 * @return a filled out project object
	 */
	public Project getProject(Long projectId);

	/**
	 * Get a list of all projects.
	 * 
	 * @return all projects as Project objects in a List
	 */
	public List<Project> getAllProjects();

	/**
	 * Inserts a new project into the datastore.
	 *
	 * @param newProject the project object to insert
	 * @return the project object with its new id filled in
	 */
	public Project createProject(Project newProject);

	/**
	 * Removes a project from the datastore, which requires deleting
	 * records from multiple tables.
	 *
	 * @param projectId the id of the project to remove
	 */
	public void deleteProject(Long projectId);


}
