package loginTests;

import baseTest.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest {


    @Test
    public void TR001_loginWithValidData() {
        pageProvider.getMainPage()
                .openMainPageAndClickOnEnterButton()
                .checkModalWindowIsOpened()
                .fillFormWithValidCred()
                .clickOnButtonSubmit()
                .checkModalWindowIsClosed()
                .getHeaderElements().checkIsElementVisible()
                ;
    }

}
