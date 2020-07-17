package tests;

import org.testng.annotations.Test;

public class CreateProjectTest extends BaseTest {

    @Test
    public void createNewProject() {
        loginPage.openPage()
                .isPageOpened()
                .login("user.test.16@mail.ru", "pass123test")
                .addNewProject()
                .createNewProject(project);
        projectsPage.verifyCreationOfNewProject(project.getProjectName(), project.getDescription());
    }
}
