package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage {


    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@class='client sign-in']")
    private WebElement enterButton;

    @FindBy(xpath = "//div[@id='enter-layer']")
    private WebElement modalWindow;

    @FindBy(xpath = "//input[@placeholder='Введіть електронну пошту']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@placeholder='Введіть пароль']")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id='enter-layer']/button")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//input[@placeholder='Що Ви шукаєте?']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id='header']//button[@class='butt1']")
    private WebElement searchButton;


    public MainPage openMainPageAndClickOnEnterButton() {
        openMainPage();
        clickOnElement(enterButton); // click on the button "Увійти"
        return this;
    }

    public void openMainPage() {
        webDriver.get(baseURL);
        logger.info("Main page was opened");
    }

    public MainPage checkModalWindowIsOpened() {
        isElementVisible(modalWindow);
        return this;
    }

    public MainPage fillFormWithValidCred() {
        enterTextIntoInputLogin("test.g10.2024@gmail.com");
        enterTextIntoInputPassword("123qwe#");
        return this;
    }

    public MainPage enterTextIntoInputLogin(String login) {
        clearAndEnterTextIntoElement(inputLogin, login);
        return this;
    }

    public MainPage enterTextIntoInputPassword(String password) {
        clearAndEnterTextIntoElement(inputPassword, password);
        return this;
    }

    public MainPage clickOnButtonSubmit() {
        clickOnElement(buttonSubmit);
        return this;
    }

    public pages.elements.HeaderElements getHeaderElements() {
        return new pages.elements.HeaderElements(webDriver);
    }

    public MainPage checkModalWindowIsClosed() {
        checkIsElementInVisible(modalWindow);
        return this;
    }

    public MainPage inputTextIntoSearchField(String bookName) {
        clearAndEnterTextIntoElement(searchField, bookName);
        return this;
    }

    public MainPage clickOnSearchButton() {
        clickOnElement(searchButton);
        return new MainPage(webDriver);
    }

    public SearchPage checkIsRedirectToSearchPage() {
        return new SearchPage(webDriver);
    }

    public MainPage openMainPageAndInputTextIntoSearchField(String text) {
        openMainPage();
        inputTextIntoSearchField(text);
        return this;
    }
}
