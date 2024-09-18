package mainTests;

import baseTest.BaseTest;
import org.junit.Before;
import org.junit.Test;


public class SearchBookTest extends BaseTest {

    private final String BOOK_TITLE = "Прислуга";

    @Before
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

    @Test
    public void TR002_searchBook() {
        pageProvider.getMainPage()
                .openMainPageAndInputTextIntoSearchField(BOOK_TITLE)
                .clickOnSearchButton()
                .checkIsRedirectToSearchPage()
                .checkIsSearchPageOpened()
                .checkBookWithTitleIsPresent(BOOK_TITLE)
        ;


    }

}