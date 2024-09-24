package orderTest;

import baseTest.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class MakeOrderTest extends BaseTest {

    private final String BOOK_TITLE = "Прислуга";

    @Before
    public void TR001_loginWithValidData() {
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
    public void TR005_makeOrder() {
        pageProvider.getBookPage()
                .clickOnButtonProceedToCheckout()
                .checkIsRedirectToOrderPage()
                .checkIsOrderPageOpened()
                .clickOnMakeOrderButton()
                .checkNotitficationFieldSurnameIsEmpty()
        ;
    }
}
