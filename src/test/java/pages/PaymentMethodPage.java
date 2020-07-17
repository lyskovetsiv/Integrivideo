package pages;

import com.codeborne.selenide.Condition;
import models.CreditCard;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PaymentMethodPage extends BasePage {

    private static final String PAYMENT_METHOD_PAGE_URL = "https://dev.integrivideo.com/app/billing/payment-methods/new";
    private static final String CREDIT_CARD_MODAL_CSS = ".credit-card";
    private static final String CREDIT_CARD_NUMBER_NAME = "number";
    private static final String CREDIT_CARD_MONTH_NAME= "expirationMonth";
    private static final String CREDIT_CARD_YEAR_NAME = "expirationYear";
    private static final String CREDIT_CARD_HOLDER_NAME = "cardholderName";
    private static final String ADD_BUTTON_XPATH = "//*[@class='btn'][contains(text(), 'Add')]";

    @Override
    public PaymentMethodPage openPage() {
        open(PAYMENT_METHOD_PAGE_URL);
        return this;
    }

    @Override
    public PaymentMethodPage isPageOpened() {
        $(CREDIT_CARD_MODAL_CSS).waitUntil(Condition.visible, 20000);
        return this;
    }

    public BillingPage addNewCard(CreditCard creditCard) {
        $(byName(CREDIT_CARD_NUMBER_NAME)).setValue(creditCard.getCardNumber());
        $(byName(CREDIT_CARD_MONTH_NAME)).setValue(creditCard.getCardMonth());
        $(byName(CREDIT_CARD_YEAR_NAME)).setValue(creditCard.getCardYear());
        $(byName(CREDIT_CARD_HOLDER_NAME)).setValue(creditCard.getCardHolderName());
        $(byXpath(ADD_BUTTON_XPATH)).waitUntil(Condition.enabled, 20000).click();
        BillingPage billingPage = new BillingPage();
        billingPage.isPageOpened();
        return billingPage;
    }
}
