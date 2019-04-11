package PageObjectsExternalFile;

public class Login extends Base {

    public Login() {
        PageFactory.initElements(new SearchWithFieldDecorator(new FileBasedElementLocatorFactory(getDriver())), this);
    }

    @SearchWith(page = "login", name = "formElement")
    private WebElement formElement;
}