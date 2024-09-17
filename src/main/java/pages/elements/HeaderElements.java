package pages.elements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;

public class HeaderElements extends CommonActionsWithElements {

    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@class='client account']")
    private WebElement myProfileButton;

    @FindBy(xpath = "//input[@placeholder='Знайти книгу']")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(text(), 'Пошук')]")
    private WebElement searchButton;

    public HeaderElements checkIsElementVisible() {
        Assert.assertTrue("My profile button is not displayed", isElementVisible(myProfileButton));
        return this;
    }

}
