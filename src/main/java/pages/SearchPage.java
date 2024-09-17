package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends ParentPage {

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//h1[@class='main-title']")
    private WebElement headerSearchPage;

    @FindBy(xpath = "//a[@title= 'Прислуга']")
    private WebElement linkBook;

    private String bookNameLocator = "//a[@title= '%s']";


    public SearchPage checkIsSearchPageOpened() {
        isElementVisible(headerSearchPage);
        return this;
    }

    private List<WebElement> getBooksList(String bookTitle) {
        return webDriver.findElements(By.xpath(String.format(bookNameLocator, bookTitle)));
    }

    public SearchPage checkBookWithTitleIsPresent(String bookTitle) {
        Assert.assertTrue("Book with title " + bookTitle + " is not present", getBooksList(bookTitle).size() > 0);
        return this;
    }
}
