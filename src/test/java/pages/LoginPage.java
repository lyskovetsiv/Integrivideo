package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    private static final String LOGIN_PAGE_URL = "https://dev.integrivideo.com/login";
    private static final String LOG_IN_BUTTON_CSS = ".btn.btn-primary";
    private static final String EMAIL_FIELD = "email";
    private static final String PASSWORD_FIELD = "password";

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

    public ProjectsPage login(String email, String password) {
        $(byName(EMAIL_FIELD)).setValue(email);
        $(byName(PASSWORD_FIELD)).setValue(password);
        $(LOG_IN_BUTTON_CSS).click();
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.isPageOpened();
        return projectsPage;
    }
}
