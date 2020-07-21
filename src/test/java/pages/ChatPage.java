package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.TimeStamp.getTimeStamp;

public class ChatPage extends BasePage {

    private static final String CHAT_PAGE_URL = "https://dev.integrivideo.com/demo/chat/new";
    private static final String CHAT_CSS = ".chat";
    private static final String INVITE_USERS_TO_CHAT_BUTTON_ID = "invite-users-to-chat";
    private static final String ENTER_MESSAGE_CSS = "div.integri-chat-input>textarea";
    private static final String SEND_MESSAGE_BUTTON_CSS = ".integri-chat-send-message";
    private static final String ALL_MESSAGES_CSS = ".integri-chat-message-text";
    private static final String ALL_EDITED_MESSAGES_CSS = ".integri-chat-message-edited .integri-chat-message ";
    private static final String MESSAGE_DATES_CSS = ".integri-chat-message-date";
    private static final String EDIT_MESSAGES_BUTTON_CSS = ".integri-chat-edit-message";
    private static final String ALL_MESSAGES_TO_EDIT_CSS = "div.integri-chat-message >textarea";
    private static final String DELETE_MESSAGES_BUTTON_CSS = ".integri-chat-remove-message";
    private static final String REMOVED_MESSAGE_CSS = ".integri-chat-message-utility .integri-chat-message-text";

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

    public String sendMessage(String message) {
        $(ENTER_MESSAGE_CSS).waitUntil(Condition.enabled, 20000).setValue(message);
        $(SEND_MESSAGE_BUTTON_CSS).click();
        return message;
    }

    public ChatPage verifyMessage(String message) {
        String timeStamp = getTimeStamp();
        assertEquals($$(ALL_MESSAGES_CSS).last().getText(), message, "Message is incorrect");
        assertEquals($$(MESSAGE_DATES_CSS).last().getText(), timeStamp, "Date is incorrect");
        return this;
    }

    public String editMessage(String editedMessage) {
        $$(EDIT_MESSAGES_BUTTON_CSS).last().hover().click();
        $$(ALL_MESSAGES_TO_EDIT_CSS).last().setValue(editedMessage).pressEnter();
        return editedMessage;
    }

    public ChatPage verifyEditedMessage(String newMessage) {
        assertEquals($$(ALL_EDITED_MESSAGES_CSS).last().getAttribute("innerText"), newMessage, "An edited message is incorrect");
        return this;
    }

    public ChatPage deleteMessage() {
        $$(DELETE_MESSAGES_BUTTON_CSS).last().hover().click();
        Selenide.switchTo().alert().accept();
        return this;
    }

    public ChatPage verifyDeletedMessage() {
        assertTrue($$(REMOVED_MESSAGE_CSS).last().waitUntil(Condition.visible, 20000).isDisplayed(), "There's no remove notification");
        assertEquals($$(REMOVED_MESSAGE_CSS).last().getText(), "removed...", "Removed message text is incorrect");
        return this;
    }
}
