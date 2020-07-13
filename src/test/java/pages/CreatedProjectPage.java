package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertEquals;

public class CreatedProjectPage extends BasePage {

    private static final String ADD_NEW_COMPONENT_CSS = ".component.new";
    private static final String PROJECT_NAME_CSS = ".col-10>h1";
    private static final String ALL_CREATED_COMPONENTS_XPATH = "//*[contains(@class, 'component new')]/parent::*/preceding-sibling::*/*/*";

    @Override
    public CreatedProjectPage openPage() {
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

    public ComponentCreationPage addNewComponent() {
        $(ADD_NEW_COMPONENT_CSS).click();
        ComponentCreationPage componentCreationPage = new ComponentCreationPage();
        componentCreationPage.isPageOpened();
        return componentCreationPage;
    }

    public CreatedProjectPage verifyComponent(String componentUrl) {
        assertEquals($$(byXpath(ALL_CREATED_COMPONENTS_XPATH)).last().getAttribute("href"), componentUrl, "Component has not been created");
        return this;
    }
}
