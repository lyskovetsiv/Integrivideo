package tests;

import org.testng.annotations.Test;

public class BillingTest extends BaseTest {

    @Test
    public void addNewCard() {
        loginPage.openPage()
                .isPageOpened()
                .login("user.test.16@mail.ru", "pass123test")
                .clickBillingButton()
                .addNewPaymentMethod()
                .addNewCard(creditCard)
                .verifyCardAdding(creditCard.getCardNumber());
    }

    @Test
    public void deleteCard() {
        loginPage.openPage()
                .isPageOpened()
                .login("user.test.16@mail.ru", "pass123test")
                .clickBillingButton()
                .verifyCardRemoving(billingPage.removeLastCard());
    }
}
