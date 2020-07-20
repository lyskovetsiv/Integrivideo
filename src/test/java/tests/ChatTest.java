package tests;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class ChatTest extends BaseTest{

    @SneakyThrows
    @Test
    public void messageValidation() {
        chatPage.openPage()
                .validateInviteURL(chatPage.generateInviteLink())
                .verifyMessage(chatPage.sendMessage("Test message 1234!@#$%^&*("));
    }
}
