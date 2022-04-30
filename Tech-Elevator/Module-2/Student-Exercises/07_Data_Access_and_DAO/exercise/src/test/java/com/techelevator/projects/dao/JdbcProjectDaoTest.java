package com.techelevator.projects.dao;

import com.techelevator.projects.model.Project;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcProjectDaoTest extends BaseDaoTest {

    private static final Project PROJECT_1 =
            new Project(1L, "Project 1", LocalDate.parse("2000-01-02"), LocalDate.parse("2000-12-31"));
    private static final Project PROJECT_2 =
            new Project(2L, "Project 2", null, null);

    private JdbcProjectDao sut;

    private Project testProject;

    @Before
    public void setup() {
        sut = new JdbcProjectDao(dataSource);
        testProject = new Project(99L, "Test Project", LocalDate.now(), LocalDate.now().plusDays(1));
    }

    @Test
    public void getProject_returns_correct_project_for_id() {
        Project project = sut.getProject(1L);
        Assert.assertNotNull("getProject returned null", project);
        assertProjectsMatch("getProject returned wrong or partial data", PROJECT_1, project);

        project = sut.getProject(2L);
        assertProjectsMatch("getProject returned wrong or partial data", PROJECT_2, project);
    }

    @Test
    public void getProject_returns_null_when_id_not_found() {
        Project project = sut.getProject(99L);
        Assert.assertNull("getProject failed to return null for id not in database", project);
    }

    @Test
    public void getAllProjects_returns_list_of_all_projects() {
        List<Project> projects = sut.getAllProjects();

        Assert.assertEquals("getAllProjects failed to return all projects", 2, projects.size());
        assertProjectsMatch("getAllProjects returned wrong or partial data", PROJECT_1, projects.get(0));
        assertProjectsMatch("getAllProjects returned wrong or partial data", PROJECT_2, projects.get(1));
    }

    @Test
    public void createProject_returns_project_with_id_and_expected_values() {
        Project createdProject = sut.createProject(testProject);

        Assert.assertNotNull("createProject returned null", createdProject);

        long newId = createdProject.getId();
        Assert.assertTrue("createProject failed to return a project with an id", newId > 0);

        testProject.setId(newId);
        assertProjectsMatch("createProject returned project with wrong or partial data", testProject, createdProject);
    }

    @Test
    public void created_project_has_expected_values_when_retrieved() {
        Project createdProject = sut.createProject(testProject);

        Assert.assertNotNull("can't test if created project has correct values until createProject is working", createdProject);

        long newId = createdProject.getId();
        Project retrievedProject = sut.getProject(newId);

        assertProjectsMatch("createProject did not save correct data in database", createdProject, retrievedProject);
    }

    @Test
    public void deleted_project_cant_be_retrieved() {
        sut.deleteProject(1L);

        Project project = sut.getProject(1L);
        Assert.assertNull("deleteProject failed to remove project from database", project);

        List<Project> projects = sut.getAllProjects();
        Assert.assertEquals("deleteProject left too many projects in database", 1, projects.size());
        assertProjectsMatch("deleteProject deleted wrong project", PROJECT_2, projects.get(0));
    }


    private void assertProjectsMatch(String message, Project expected, Project actual) {
        Assert.assertEquals(message, expected.getId(), actual.getId());
        Assert.assertEquals(message, expected.getName(), actual.getName());
        Assert.assertEquals(message, expected.getFromDate(), actual.getFromDate());
        Assert.assertEquals(message, expected.getToDate(), actual.getToDate());
    }
}
