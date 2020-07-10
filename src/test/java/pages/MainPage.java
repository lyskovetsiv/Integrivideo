package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends BasePage {

    private String MAIN_PAGE_URL = "https://dev.integrivideo.com/";
    private String FREE_SIGN_UP_BUTTON_CSS = ".col-xl-12 .btn.btn-primary";

    @Override
    public MainPage openPage() {
        open(MAIN_PAGE_URL);
        return this;
    }

    @Override
    public MainPage isPageOpened() {
        $(FREE_SIGN_UP_BUTTON_CSS).waitUntil(Condition.visible, 20000);
        return this;
    }
}
