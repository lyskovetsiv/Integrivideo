package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    private String LOGIN_PAGE_URL = "https://dev.integrivideo.com/login";
    private String LOG_IN_BUTTON_CSS = ".btn.btn-primary";
    private String EMAIL_FIELD = "email";
    private String PASSWORD_FIELD = "password";

    @Override
    public LoginPage openPage() {
        open(LOGIN_PAGE_URL);
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        $(LOG_IN_BUTTON_CSS).waitUntil(Condition.visible, 20000);
        return this;
    }

    public MainPage login(String email, String password) {
        $(byName(EMAIL_FIELD)).setValue(email);
        $(byName(PASSWORD_FIELD)).setValue(password);
        $(LOG_IN_BUTTON_CSS).click();
        MainPage mainPage = new MainPage();
        mainPage.isPageOpened();
        return mainPage;
    }
}
