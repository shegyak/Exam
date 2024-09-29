package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BookPage extends ParentPage {

    public BookPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//h2[@class='secondary-title']")
    private WebElement headerAllAboutBook;

    @FindBy(xpath = "//div[@class='offer']//span[text()='Купити']")
    private WebElement buttonBuy;

    @FindBy(xpath = "//div[@id='basket-layer']//div[@class='holder']")
    private WebElement basketWindow;

    @FindBy(xpath = "//div[@class='active']//div[@class='name']")
    private WebElement bookTitle;

    @FindBy(xpath = "//div[@class='total-amount']//span")
    private WebElement bookDeleteButton;

    @FindBy(xpath = "//span[@class='confirm-layer clear-all opened']")
    private WebElement yesNoModalWindow;

    @FindBy(xpath = "//span[@class='confirm-layer clear-all opened']//button[text() = 'Так']")
    private WebElement buttonYes;

    @FindBy(xpath = "//a[@class='butt2']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//div[@class='empty']")
    private WebElement emptyBasket;

    private String bookNameLocator = "//a[text() = '%s']";

    WebDriverWait webDriverWait10;

    public BookPage checkIsRedirectToBookPage() {
        isElementVisible(headerAllAboutBook);
        return this;
    }

    public BookPage clickOnButtonBuy() {
        clickOnElement(buttonBuy);
        return this;
    }

    public BookPage checkBasketIsOpened() {
        isElementVisible(basketWindow);
        return this;
    }

    private List<WebElement> getBooksList(String bookTitle) {
        return webDriver.findElements(By.xpath(String.format(bookNameLocator, bookTitle)));
    }

    public BookPage checkBookWithTitleIsPresentInBasket(String bookTitle) {
        Assert.assertTrue("Book with title " + bookTitle + " is not present", getBooksList(bookTitle).size() > 0);
        return this;
    }

    public BookPage clickOnButtonDeleteInBasket() {
        clickOnElement(bookDeleteButton);
        return this;
    }

    public BookPage checkYesNoModalWindowIsOpened() {
        Assert.assertTrue("Modal window is not opened", isElementVisible(yesNoModalWindow));
        return this;
    }

    public BookPage clickOnButtonYesInModalWindow() {
        clickOnElement(buttonYes);
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return this;
    }


    public BookPage checkBasketIsEmpty(String bookTitle) {
        webDriverWait10.until(ExpectedConditions.numberOfElementsToBe(By.xpath(String.format(bookNameLocator, bookTitle)), 0));
        Assert.assertTrue("Book is visible", getBooksList(bookTitle).size() == 0);
        Assert.assertFalse("Button is visible", isElementVisible(bookDeleteButton));
        return this;
    }

    public OrderPage clickOnButtonProceedToCheckout() {
        clickOnElement(proceedToCheckoutButton);
        return new OrderPage(webDriver);
    }
}
