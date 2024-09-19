package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    private String bookNameLocator = "//a[text() = '%s']";

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
}
