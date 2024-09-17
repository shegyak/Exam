package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ParentPage extends CommonActionsWithElements {

    protected Logger logger = Logger.getLogger(getClass());
    String baseURL = "https://balka-book.com/ua/";


    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }
}
