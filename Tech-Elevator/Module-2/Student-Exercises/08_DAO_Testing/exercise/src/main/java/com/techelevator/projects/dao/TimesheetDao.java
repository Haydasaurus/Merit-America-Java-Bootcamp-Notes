package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;

import java.util.List;

public interface TimesheetDao {

    /**
     * Get a timesheet from the datastore that has the given id.
     * If the id is not found, return null.
     *
     * @param timesheetId the id of the timesheet
     * @return a filled out Timesheet object
     */
    Timesheet getTimesheet(Long timesheetId);

    /**
     * Get all timesheets from the datastore for a given employee,
     * ordered by timesheet_id.
     *
     * @param employeeId the id of the employee
     * @return all timesheets as Timesheet objects in a List
     */
    List<Timesheet> getTimesheetsByEmployeeId(Long employeeId);

    /**
     * Get all timesheets from the datastore for a given project,
     * ordered by timesheet_id.
     *
     * @param projectId the id of the project
     * @return all timesheets as Timesheet objects in a List
     */
    List<Timesheet> getTimesheetsByProjectId(Long projectId);

    /**
     * Adds a new timesheet into the datastore.
     *
     * @param newTimesheet the Timesheet object to add
     * @return the Timesheet object with its new id filled in
     */
    Timesheet createTimesheet(Timesheet newTimesheet);

    /**
     * Update a timesheet to the datastore. Only called on timesheets that
     * are already in the datastore.
     *
     * @param updatedTimesheet the Timesheet object to update
     */
    void updateTimesheet(Timesheet updatedTimesheet);

    /**
     * Removes a timesheet from the datastore.
     *
     * @param timesheetId the id of the timesheet to remove
     */
    void deleteTimesheet(Long timesheetId);

    /**
     * Gets the total hours from all timesheets classified as billable for
     * a given combination of employee and project. Non-billable timesheets
     * are ignored.
     *
     * @param employeeId the id of an employee
     * @param projectId the id of a project
     * @return the total billable hours
     */
    double getBillableHours(Long employeeId, Long projectId);

}
