package page.GoogleSearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import page.Base;
import searchwith.FileBasedElementLocatorFactory;
import searchwith.SearchWith;
import searchwith.SearchWithFieldDecorator;


public class GoogleResultsPage extends Base {
    private final static String GOOGLE_RESULTS_PAGE = "GoogleResultsPage";
    private WebDriver driver;

    @SearchWith(page="first", name="searchButton")
    private WebElement searchButton;

    public GoogleResultsPage() {
        PageFactory.initElements(new SearchWithFieldDecorator(new FileBasedElementLocatorFactory(getDriver())), this);
    }

}
