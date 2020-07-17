package pages;

import com.codeborne.selenide.Condition;
import org.apache.commons.lang3.StringUtils;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;

public class BillingPage extends BasePage {

    private static final String BILLING_PAGE_URL = "https://dev.integrivideo.com/app/billing";
    private static final String ADD_NEW_BUTTON_XPATH = "//*[contains(text(), 'Add new')]";
    private static final String ALL_CARDS_CSS = ".cards .row";
    private static final String ALL_CARD_NUMBERS_CSS = ALL_CARDS_CSS + " .col-md-7";
    private static final String ALL_CARD_REMOVE_BUTTON_CSS = ALL_CARDS_CSS + " .col-md-2";

    @Override
    public BillingPage openPage() {
        open(BILLING_PAGE_URL);
        return this;
    }

    @Override
    public BillingPage isPageOpened() {
        $(byXpath(ADD_NEW_BUTTON_XPATH)).waitUntil(Condition.visible, 20000);
        return this;
    }

    public int getNumberOfCardsAdded() {
        return $$(ALL_CARDS_CSS).size();
    }

    public PaymentMethodPage addNewPaymentMethod() {
        $(byXpath(ADD_NEW_BUTTON_XPATH)).click();
        PaymentMethodPage paymentMethodPage = new PaymentMethodPage();
        paymentMethodPage.isPageOpened();
        return paymentMethodPage;
    }

    public int removeLastCard() {
        int initialCardQuantity = getNumberOfCardsAdded();
            $$(ALL_CARD_REMOVE_BUTTON_CSS).last().click();
        return initialCardQuantity;
    }

    public BillingPage verifyCardAdding(String cardNumber) {
            assertTrue(cardNumber.contains(StringUtils.substringBefore($$(ALL_CARD_NUMBERS_CSS).last().getText(), "*")), "Card has not been added");
        return this;
    }

    public BillingPage verifyCardRemoving(int initialCardQuantity) {
        assertEquals(initialCardQuantity - getNumberOfCardsAdded(), 1, "Card has not been deleted");
        return this;
    }
}
