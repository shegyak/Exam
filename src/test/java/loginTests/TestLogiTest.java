package loginTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import junitparams.Parameters;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestLogiTest {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Browser was opened");
    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
    }

    @Test
    public void validLogin() {
    webDriver.get("https://balka-book.com/ua/");
    logger.info("Site was opened");

    WebElement enterButton = webDriver.findElement(By.xpath("//div[@class='client sign-in']"));

    enterButton.click();
    Assert.assertTrue("Modal window is not displayed", isModalWindowDisplayed());

    WebElement inputLogin = webDriver.findElement(By.xpath("//input[@placeholder='Введіть електронну пошту']"));

    inputLogin.clear();
    inputLogin.sendKeys ("test.g10.2024@gmail.com");
    logger.info("test.g10.2024@gmail.com was inputted into input Login");

    WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder='Введіть пароль'] "));

    inputPassword.clear();
    inputPassword.sendKeys("123qwe#");
    logger.info("Password was inputted into input Password");

    WebElement buttonSubmit = webDriver.findElement(By.xpath("//button[@class='butt2']"));
    buttonSubmit.click();
    logger.info("Button Sign in was clicked");

    Assert.assertFalse("Modal window is displayed", isModalWindowDisplayed());
    Assert.assertTrue("Button My cabinet is not visible", isButtonMyProfileVisible());

    }

    private boolean isButtonMyProfileVisible() {
        try {
            return webDriver.findElement(By.xpath("//*[@id='header']//div[@class='client account']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    private boolean isModalWindowDisplayed() {
        try {
            return webDriver.findElement(By.xpath("//div[@id='enter-layer']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
