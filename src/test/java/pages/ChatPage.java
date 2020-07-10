package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class ChatPage extends BasePage {

    private static final String CHAT_CSS = ".chat";
    private static final String INVITE_USERS_TO_CHAT_BUTTON_ID = "invite-users-to-chat";

    @Override
    public ChatPage openPage() {
        return this;
    }

    @Override
    public ChatPage isPageOpened() {
        $(CHAT_CSS).waitUntil(Condition.visible, 20000);
        return this;
    }

    public ChatPage generateInviteLink() {
        $(byId(INVITE_USERS_TO_CHAT_BUTTON_ID)).click();
        return this;
    }

    public String validateInviteURL() throws IOException, UnsupportedFlavorException {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String chatLink = (String) clipboard.getData(DataFlavor.stringFlavor);
        assertEquals(url(), chatLink, "Incorrect chat link");
        return chatLink;
    }
}
