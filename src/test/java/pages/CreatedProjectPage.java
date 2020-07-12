package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class CreatedProjectPage extends BasePage {

    private static final String ADD_NEW_COMPONENT_CSS = ".component.new";
    private static final String PROJECT_NAME_CSS = ".col-10>h1";

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
}
