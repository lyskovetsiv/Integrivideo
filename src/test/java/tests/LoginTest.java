package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validUserLogin() {
        loginPage.openPage()
                .isPageOpened()
                .login("user.test.16@mail.ru", "pass123test");
    }
}
