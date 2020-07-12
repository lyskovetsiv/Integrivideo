package tests;

import com.codeborne.selenide.Configuration;
import models.Project;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import pages.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    LoginPage loginPage;
    MainPage mainPage;
    ChatPage chatPage;
    ProjectsPage projectsPage;
    ProjectCreationPage projectCreationPage;
    CreatedProjectPage createdProjectPage;
    Project project;

    @BeforeTest
    public void setupBrowser() {
        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.timeout = 20000;
        Configuration.browser = "Chrome";
        Configuration.clickViaJs = false;
        project = new Project("TestProject", "my project", "testdomain.su");
        loginPage = new LoginPage();
        mainPage = new MainPage();
        chatPage = new ChatPage();
        projectsPage = new ProjectsPage();
        projectCreationPage = new ProjectCreationPage();
        createdProjectPage = new CreatedProjectPage();

    }

    @AfterTest(alwaysRun = true)
        public void closeBrowser() {
        getWebDriver().quit();
    }
}
