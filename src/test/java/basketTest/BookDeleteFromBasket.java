package basketTest;

import baseTest.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class BookDeleteFromBasket extends BaseTest {

    private final String BOOK_TITLE = "Прислуга";

    @Before
    public void loginSearchAndAddBookInBasket() {
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
                .clickOnBookWithTitle(BOOK_TITLE)
                .checkIsRedirectToBookPage()
                .clickOnButtonBuy()
                .checkBasketIsOpened()
                .checkBookWithTitleIsPresentInBasket(BOOK_TITLE)
        ;
    }

    @Test
    public void TR004_deleteBookFromBasket() {
        pageProvider.getBookPage()
                .clickOnButtonDeleteInBasket()
                .checkYesNoModalWindowIsOpened()
                .clickOnButtonYesInModalWindow()
                .checkBasketIsEmpty(BOOK_TITLE)

        ;
    }
}
