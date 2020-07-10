package pages;

import com.codeborne.selenide.Condition;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends BasePage {

    private static final String MAIN_PAGE_URL = "https://dev.integrivideo.com/";
    private static final String FREE_SIGN_UP_BUTTON_CSS = ".col-xl-12 .btn.btn-primary";
    private static final String CLOUD_VIDEO_RECORDER_BUTTON_XPATH = "//*[contains(text(),'Cloud video recorder')]/parent::*/*/*[contains(@class,'btn')]";
    private static final String CHAT_BUTTON_XPATH = "//*[contains(text(),'Chat')]/parent::*/*/*[contains(@class,'btn')]";


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

    public ChatPage openChatPage() {
        $(byXpath(CHAT_BUTTON_XPATH)).click();
        ChatPage chatPage = new ChatPage();
        chatPage.isPageOpened();
        return chatPage;
    }
}
