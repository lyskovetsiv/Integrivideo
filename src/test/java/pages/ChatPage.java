package pages;

import com.codeborne.selenide.Condition;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class ChatPage extends BasePage {

    private static final String CHAT_PAGE_URL = "https://dev.integrivideo.com/demo/chat/new";
    private static final String CHAT_CSS = ".chat";
    private static final String INVITE_USERS_TO_CHAT_BUTTON_ID = "invite-users-to-chat";

    @Override
    public ChatPage openPage() {
        open(CHAT_PAGE_URL);
        return this;
    }

    @Override
    public ChatPage isPageOpened() {
        $(CHAT_CSS).waitUntil(Condition.visible, 20000);
        return this;
    }

    public String generateInviteLink() throws IOException, UnsupportedFlavorException {
        $(byId(INVITE_USERS_TO_CHAT_BUTTON_ID)).click();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        return (String) clipboard.getData(DataFlavor.stringFlavor);
    }

    public ChatPage validateInviteURL(String link) {
        assertEquals(url(), link, "Incorrect chat link");
        return new ChatPage();
    }
}
