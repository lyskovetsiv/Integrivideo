package pages;

import com.codeborne.selenide.Condition;
import models.Component;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class ComponentCreationPage extends BasePage {

    private static final String CREATE_BUTTON_XPATH = "//*[contains(@id, 'project-form')]/descendant::*[contains(text(), 'Create')]";
    private static final String COMPONENT_TYPE_ID = "select2-type-sh-container";
    private static final String COMPONENT_NAME_NAME = "name";

    @Override
    public ComponentCreationPage openPage() {
        return this;
    }

    @Override
    public ComponentCreationPage isPageOpened() {
        $(CREATE_BUTTON_XPATH).waitUntil(Condition.visible, 20000);
        return this;
    }

    public CreatedProjectPage createNewComponent(Component component) {
        $(COMPONENT_TYPE_ID).selectOptionByValue(component.getComponentTypeValue());
        $(byName(COMPONENT_NAME_NAME)).setValue(component.getComponentName());
        $(CREATE_BUTTON_XPATH).click();
        CreatedProjectPage createdProjectPage = new CreatedProjectPage();
        createdProjectPage.isPageOpened();
        return createdProjectPage;
    }
}
