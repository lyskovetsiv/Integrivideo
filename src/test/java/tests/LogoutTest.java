package tests;

import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void userLogout() {
        loginPage.openPage()
                .isPageOpened()
                .login("user.test.16@mail.ru", "pass123test")
                .clickLogoutButton();
    }
}
