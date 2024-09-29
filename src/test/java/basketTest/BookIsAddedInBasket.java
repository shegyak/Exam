package basketTest;

import baseTest.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class BookIsAddedInBasket extends BaseTest {

    private final String BOOK_TITLE = "Прислуга";

    @Before
    public void loginWithValidDataAndSearchBook() {
        pageProvider.getMainPage()
                .openMainPageAndClickOnEnterButton()
                .checkModalWindowIsOpened()
                .fillFormWithValidCred()
                .clickOnButtonSubmit()
                .checkModalWindowIsClosed()
                .inputTextIntoSearchField(BOOK_TITLE)
                .clickOnSearchButton()
                .checkIsRedirectToSearchPage()
                .checkIsSearchPageOpened()
                .checkBookWithTitleIsPresent(BOOK_TITLE)
        ;
    }

    @Test
    public void TR003_addBookInBasket() {
        pageProvider.getSearchPage()
                .clickOnBookWithTitle(BOOK_TITLE)
                .checkIsRedirectToBookPage()
                .clickOnButtonBuy()
                .checkBasketIsOpened()
                .checkBookWithTitleIsPresentInBasket(BOOK_TITLE)
        ;
    }
}
