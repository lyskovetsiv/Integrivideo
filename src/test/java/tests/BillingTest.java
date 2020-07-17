package tests;

import org.testng.annotations.Test;

public class BillingTest extends BaseTest {

    @Test
    public void createAndRemoveCard() {
        loginPage.openPage()
                .isPageOpened()
                .login("user.test.16@mail.ru", "pass123test")
                .clickBillingButton()
                .addNewPaymentMethod()
                .addNewCard(creditCard)
                .verifyCardAdding(creditCard.getCardNumber())
                .verifyCardRemoving(billingPage.removeLastCard());
    }
}
