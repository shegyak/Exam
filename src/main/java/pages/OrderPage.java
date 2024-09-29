package pages;

import com.beust.ah.A;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends ParentPage {

    public OrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//button[@class = 'butt2']")
    private WebElement makeOrderButton;

    @FindBy(xpath = "//div[@class='notification-container bottom']")
    private WebElement notificationFieldSurnameIsEmpty;

    @FindBy(xpath = "//input[@name= 'secondname']")
    private WebElement inputSurname;

    @FindBy(xpath = "//input[@name= 'firstname']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@name= 'phone']")
    private WebElement inputPhone;


    public OrderPage checkIsRedirectToOrderPage() {
        return new OrderPage(webDriver);
    }

    public OrderPage checkIsOrderPageOpened() {
        Assert.assertTrue("Input surname is invisible", isElementVisible(inputSurname));
        Assert.assertTrue("Input name is invisible", isElementVisible(inputName));
        Assert.assertTrue("Input phone is invisible", isElementVisible(inputPhone));
        return this;
    }

    public OrderPage clickOnMakeOrderButton() {
        clickOnElement(makeOrderButton);
        return this;
    }

    public OrderPage checkNotitficationFieldSurnameIsEmpty() {
        Assert.assertTrue("Notification field is invisible", isElementVisible(notificationFieldSurnameIsEmpty));
        return this;
    }
}
