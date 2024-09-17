package mainTests;

import baseTest.BaseTest;
import org.junit.Test;
import pages.PageProvider;

public class SearchBookTest extends BaseTest {


    @Test
    public void TR001_loginWithValidData() {
        pageProvider.getMainPage()
                .openMainPageAndInputTextIntoSearchField("Прислуга")
                .clickOnSearchButton()
                .checkIsRedirectToSearchPage()
                .checkIsSearchPageOpened()
                .checkBookWithTitleIsPresent("Прислуга")
        ;


    }

}