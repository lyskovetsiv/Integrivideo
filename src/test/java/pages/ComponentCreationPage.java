package pages;

import com.codeborne.selenide.Condition;
import models.Component;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ComponentCreationPage extends BasePage {

    private static final String CREATE_BUTTON_XPATH = "//*[contains(text(), 'Create')]";
    private static final String UPDATE_BUTTON_XPATH = "//*[contains(text(), 'Update')]";
    private static final String SELECT_CSS = ".form-control.select2-hidden-accessible";
    private static final String COMPONENT_NAME_NAME = "name";
    private static final String BASE_URL = "https://dev.integrivideo.com/";
    private static final String COMPONENT_CREATION_PAGE_URL = "/components/new";
    private static final String COMPONENT_TYPE_NAME = "type";

    @Override
    public ComponentCreationPage openPage() {
        ProjectsPage projectsPage = new ProjectsPage();
        open(BASE_URL + projectsPage.openPage().getLastProjectUrl() + COMPONENT_CREATION_PAGE_URL);
        return this;
    }

    @Override
    public ComponentCreationPage isPageOpened() {
        $(byName(COMPONENT_NAME_NAME)).waitUntil(Condition.visible, 20000);
        return this;
    }

    public String getComponentType(){
        return $(byName(COMPONENT_TYPE_NAME)).getAttribute("value");
    }

    public String getComponentName(){
        return $(byName(COMPONENT_NAME_NAME)).getValue();
    }

    public String getComponentUrl() {
        return url();
    }

    public Component createNewComponent(Component component) {
        $(SELECT_CSS).selectOption(component.getComponentTypeValue());
        $(byName(COMPONENT_NAME_NAME)).setValue(component.getComponentName());
        $(byXpath(CREATE_BUTTON_XPATH)).click();
        $(byXpath(UPDATE_BUTTON_XPATH)).waitUntil(Condition.visible, 20000);
        $(byXpath(UPDATE_BUTTON_XPATH)).click();
        return component;
    }
}
