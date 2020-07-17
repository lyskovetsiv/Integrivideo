package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class ProjectsPage extends BasePage {

    private static final String PROJECTS_PAGE_URL = "https://dev.integrivideo.com/app/projects";
    private static final String MENU_ID = "navbarMenu";
    private static final String ADD_PROJECT_CSS = ".project.new";
    private static final String ALL_CREATED_PROJECTS_XPATH = "//*[contains(@class, 'project new')]/parent::*/preceding-sibling::*";
    private static final String LAST_CREATED_PROJECT_URL_XPATH = "//*[contains(@class, 'project new')]/parent::*/preceding-sibling::*/*/*";

    @Override
    public ProjectsPage openPage() {
        open(PROJECTS_PAGE_URL);
        return this;
    }

    @Override
    public ProjectsPage isPageOpened() {
        $(byId(MENU_ID)).waitUntil(Condition.visible, 20000);
        return this;
    }

    public ProjectCreationPage addNewProject() {
        $(ADD_PROJECT_CSS).click();
        ProjectCreationPage projectCreationPage = new ProjectCreationPage();
        projectCreationPage.isPageOpened();
        return projectCreationPage;
    }

    public CreatedProjectPage getLastProject() {
        $$(byXpath(ALL_CREATED_PROJECTS_XPATH)).last().click();
        CreatedProjectPage createdProjectPage = new CreatedProjectPage();
        createdProjectPage.isPageOpened();
        return createdProjectPage;
    }

    public String getLastProjectUrl() {
        return $$(byXpath(LAST_CREATED_PROJECT_URL_XPATH)).last().getAttribute("href");
    }

    public CreatedProjectPage verifyCreationOfNewProject(String projectName, String description) {
        String projectUrl = getLastProjectUrl();
        $$(byXpath(ALL_CREATED_PROJECTS_XPATH)).last().click();
        CreatedProjectPage createdProjectPage = new CreatedProjectPage();
        createdProjectPage.isPageOpened();
        assertEquals(createdProjectPage.getProjectUrl(), projectUrl,"Project URL is wrong");
        assertEquals(createdProjectPage.getProjectName(), projectName,"Project name: " + projectName + " is wrong");
        assertEquals(createdProjectPage.getProjectDescription(), description,"Project description: " + description + " is wrong");
        return createdProjectPage;
    }
}
