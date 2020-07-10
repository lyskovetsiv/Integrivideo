package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class CloudVideoPage extends BasePage {

    private static final String VIDEO_WINDOW_CSS = ".OT_widget-container";

    @Override
    public CloudVideoPage openPage() {
        return this;
    }

    @Override
    public CloudVideoPage isPageOpened() {
        $(VIDEO_WINDOW_CSS).waitUntil(Condition.visible, 20000);
        return this;
    }
}
