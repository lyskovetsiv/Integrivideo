package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage extends BasePage {

    private static final String PROJECTS_PAGE_URL = "https://dev.integrivideo.com/app/projects";
    private static final String MENU_ID = "navbarMenu";

    @Override
    public ProjectsPage openPage() {
        open(PROJECTS_PAGE_URL);
        return this;
    }

    @Override
    public ProjectsPage isPageOpened() {
        $(byId(MENU_ID)).waitUntil(Condition.visible, 20000);
        return this;
    }

}
