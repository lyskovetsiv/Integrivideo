package tests;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class ChatTest extends BaseTest{

    @SneakyThrows
    @Test(priority = 1)
    public void chatUrlValidation() {
        chatPage.openPage()
                .validateInviteURL(chatPage.generateInviteLink());
    }

    @Test(priority = 2)
    public void messageValidation() {
                chatPage.verifyMessage(chatPage.sendMessage("Test message 1234!@#$%^&*("));
    }

    @Test(priority = 3)
    public void editMessageValidation() {
        chatPage.verifyEditedMessage(chatPage.editMessage("Edited message"));
    }

    @Test(priority = 4)
    public void deleteMessageValidation() {
        chatPage.deleteMessage()
                .verifyDeletedMessage();
    }
}
