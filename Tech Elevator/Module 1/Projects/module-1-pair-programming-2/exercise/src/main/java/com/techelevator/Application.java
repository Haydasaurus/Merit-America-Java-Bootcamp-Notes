package com.techelevator;

import java.util.*;
import java.time.LocalDate;
public class Application {
    private List<Department> departments = new ArrayList<>();
    private  static List<Employee> employees = new ArrayList<>();
    private Map<String,Project> projects = new HashMap<>();


    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {

        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
        PrintStartDateDueDate();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        Department marketing = new Department(1, "Marketing");
        departments.add(marketing);
        Department sales = new Department(2, "Sales");
        departments.add(sales);
        Department engineering = new Department(3, "Engineering");
        departments.add(engineering);
    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (Department department : departments) {
            System.out.println(department.getName());
        }
    }
    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees () {
        Employee dean = new Employee();
        dean.setFirstName("Dean");
        dean.setLastName("Johnson");
        dean.setEmployeeId(1);
        dean.setEmail("djohnson@teams.com");
        dean.setDepartment(departments.get(2));
        dean.setHireDate("08/21/2020");
        employees.add(dean);
        Employee angie = new Employee(2, "Angie", "Smith", "asmith@teams.com", departments.get(2), "08/21/2020");
        employees.add(angie);
        Employee margaret = new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", departments.get(0), "08/21/2020");
        employees.add(margaret);
        double raiseAmount = angie.getSalary() * .1;
        double angieRaise = angie.getSalary() + raiseAmount;
        angie.setSalary(angieRaise);
    }

    /**
     * Print out each employee in the collection.
     */
    private  void printEmployees() {
        System.out.println("\n------------- EMPLOYEES --------------------------------");
        for (Employee employee : employees) {
            System.out.println(employee.getFullName() + " (" + employee.getSalaryString() + ") " + employee.getDepartment().getName());
        }
    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject () {
        LocalDate startDate
                = LocalDate.now();

        Project teams = new Project("TEams", "Project Management", startDate, startDate.plusDays(30));

        for (Employee employee : employees) {
//            if (employee.getDepartment().equals(departments.get(2))) {
            //added the new getDepartmentName()
            if (employee.getDepartment().equals(getDepartmentName("Engineering"))) {
                teams.setTeamMembers(employee);
            }
        }
        projects.put(teams.getName(), teams);
    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject () {
        LocalDate startDate
                = LocalDate.now()  ;
        startDate = startDate.plusDays(31);
        Project landingPage = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing",startDate, startDate.plusDays(31));
        for (Employee employee : employees) {
            //changed this portion  to get department
            if (employee.getDepartment().equals(getDepartmentName("Marketing"))) {
                landingPage.setTeamMembers(employee);
            }
        }
        projects.put(landingPage.getName(), landingPage);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport () {
        System.out.println("\n------------- PROJECTS ---------------------------------");
        for (Map.Entry<String, Project> project : projects.entrySet()) {
            String projectName = project.getKey();
            int memberCount = project.getValue().getTeamMembers().size();
            System.out.println(projectName + ": " + memberCount);
        }

    }
    private void PrintStartDateDueDate() {
        System.out.println("------------- TIMELINES---------------------------------\n");
        for(Map.Entry<String, Project> project : projects.entrySet()){
           String projectName = project.getKey();

            System.out.println("Project: " +projectName );
            System.out.println("Start Date: " +project.getValue().getStartDate());
            System.out.println("Due Date: " +project.getValue().getDueDate());
            System.out.println("\n");

        }
         }
         //added this code after the 4:1
    private Department getDepartmentName(String name){
        for(Department department : departments) {
            if (department.getName().equals(name)){
                return department;
            }
        }
        return null;
    }

}
