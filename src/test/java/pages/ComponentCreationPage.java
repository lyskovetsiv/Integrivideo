package pages;

import com.codeborne.selenide.Condition;
import models.Component;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ComponentCreationPage extends BasePage {

    private static final String CREATE_BUTTON_XPATH = "//*[contains(@id, 'component-form')]/descendant::*[contains(text(), 'Create')]";
    private static final String UPDATE_BUTTON_XPATH = "//*[contains(@id, 'component-form')]/descendant::*[contains(text(), 'Update')]";
    private static final String COMPONENT_TYPE_CSS = ".select2-selection.select2-selection--single";
    private static final String SELECT_CSS = ".form-control.select2-hidden-accessible";
    private static final String COMPONENT_NAME_NAME = "name";

    @Override
    public ComponentCreationPage openPage() {
        return this;
    }

    @Override
    public ComponentCreationPage isPageOpened() {
        $(byXpath(CREATE_BUTTON_XPATH)).waitUntil(Condition.visible, 20000);
        return this;
    }

    public String createNewComponent(Component component) {
        $(SELECT_CSS).selectOptionByValue(component.getComponentTypeValue());
        $(byName(COMPONENT_NAME_NAME)).setValue(component.getComponentName());
        $(byXpath(CREATE_BUTTON_XPATH)).click();
        $(byXpath(UPDATE_BUTTON_XPATH)).waitUntil(Condition.visible, 20000);
        String componentUrl = url();
        $(byXpath(UPDATE_BUTTON_XPATH)).click();
        return componentUrl;
    }
}
