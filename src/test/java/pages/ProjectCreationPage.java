package pages;

import com.codeborne.selenide.Condition;
import models.Project;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectCreationPage extends BasePage {

    private static final String PROJECT_CREATION_PAGE_URL = "https://dev.integrivideo.com/app/projects/new";
    private static final String CREATE_BUTTON_XPATH = "//*[contains(@id, 'project-form')]/descendant::*[contains(text(), 'Create')]";
    private static final String PROJECT_NAME_NAME = "name";
    private static final String DESCRIPTION_NAME = "description";
    private static final String DOMAIN_NAME = "domains[]";

    @Override
    public ProjectCreationPage openPage() {
        open(PROJECT_CREATION_PAGE_URL);
        return this;
    }

    @Override
    public ProjectCreationPage isPageOpened() {
        $(byXpath(CREATE_BUTTON_XPATH)).waitUntil(Condition.visible, 20000);
        return this;
    }

    public Project createNewProject(Project project) {
        $(byName(PROJECT_NAME_NAME)).setValue(project.getProjectName());
        $(byName(DESCRIPTION_NAME)).setValue(project.getDescription());
        $(byName(DOMAIN_NAME)).setValue(project.getDomain());
        $(byXpath(CREATE_BUTTON_XPATH)).click();
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.isPageOpened();
        return project;
    }
}
