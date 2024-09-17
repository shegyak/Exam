package loginTests;

import baseTest.BaseTest;
import org.junit.Test;
import pages.PageProvider;

public class LoginTest extends BaseTest {


    @Test
    public void TR001_loginWithValidData() {
        pageProvider.getMainPage()
                .openMainPageAndClickOnEnterButton()
                .inputTextIntoSearchField("Прислуга")
                .checkModalWindowIsOpened()
                .fillFormWithValidCred()
                .clickOnButtonSubmit()
                .checkModalWindowIsClosed()
                .getHeaderElements().checkIsElementVisible()
                ;
    }

}
