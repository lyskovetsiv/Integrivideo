package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.ChatPage;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    LoginPage loginPage;
    MainPage mainPage;
    ChatPage chatPage;

    @BeforeTest
    public void setupBrowser() {
        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.timeout = 20000;
        Configuration.browser = "Chrome";
        Configuration.clickViaJs = false;
        loginPage = new LoginPage();
        mainPage = new MainPage();
        chatPage = new ChatPage();
    }

    @AfterTest(alwaysRun = true)
        public void closeBrowser() {
        getWebDriver().quit();
    }
}
