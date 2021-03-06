package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class CreatedProjectPage extends BasePage {

    private static final String ADD_NEW_COMPONENT_CSS = ".component.new";
    private static final String PROJECT_NAME_CSS = "h1";
    private static final String ALL_CREATED_COMPONENTS_XPATH = "//*[@Class='component']";
    private static final String DESCRIPTION_CSS = ".description";
    private static final String LAST_COMPONENT_XPATH = "//*[@Class='component']/*";
    private static final String BASE_URL = "https://dev.integrivideo.com/";

    @Override
    public CreatedProjectPage openPage() {
        ProjectsPage projectsPage = new ProjectsPage();
        open(BASE_URL + projectsPage.openPage().getLastProjectUrl());
        return this;
    }

    @Override
    public CreatedProjectPage isPageOpened() {
        $(ADD_NEW_COMPONENT_CSS).waitUntil(Condition.visible, 20000);
        return this;
    }

    public String getProjectName() {
        return $(PROJECT_NAME_CSS).getText();
    }

    public String getProjectDescription() {
        return $(DESCRIPTION_CSS).getText();
    }

    public String getProjectUrl() {
        return url();
    }

    public String getLastComponentUrl() {
        return $$(byXpath(LAST_COMPONENT_XPATH)).last().getAttribute("href");
    }

    public ComponentCreationPage addNewComponent() {
        $(ADD_NEW_COMPONENT_CSS).click();
        ComponentCreationPage componentCreationPage = new ComponentCreationPage();
        componentCreationPage.isPageOpened();
        return componentCreationPage;
    }

    public ComponentCreationPage verifyComponent(String componentType, String componentName) {
        String lastComponentUrl = getLastComponentUrl();
        $$(byXpath(ALL_CREATED_COMPONENTS_XPATH)).last().click();
        ComponentCreationPage componentCreationPage = new ComponentCreationPage();
        componentCreationPage.isPageOpened();
        assertEquals(componentCreationPage.getComponentUrl(), lastComponentUrl, "Component has not been created");
        assertEquals(componentCreationPage.getComponentType(), componentType, "Component type: " + componentType + " is wrong");
        assertEquals(componentCreationPage.getComponentName(), componentName,"Component name: " + componentName + " is wrong");
        return componentCreationPage;
    }
}
