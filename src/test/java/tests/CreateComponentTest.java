package tests;

import org.testng.annotations.Test;

public class CreateComponentTest extends BaseTest {

    @Test
    public void createNewComponent() {
        loginPage.openPage()
                .isPageOpened()
                .login("user.test.16@mail.ru", "pass123test")
                .getLastProject()
                .addNewComponent()
                .createNewComponent(component)
                .verifyComponent(component.getComponentTypeValue(), component.getComponentName());
    }
}
