package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.UserAction;

public class HomePage {

    private static WebDriver driver;
    private UserAction userAction;

    public HomePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
        userAction = new UserAction(driver);
    }

    @FindBy(xpath="//span[text()='My Account']")
    private WebElement myAccountDropMenu;

    @FindBy(linkText="Login")
    private WebElement loginOption;

    @FindBy(linkText="Register")
    private WebElement registerOption;

    @FindBy(name="search")
    private WebElement searchBoxField;

    @FindBy(xpath="//button[contains(@class,'btn-default')]")
    private WebElement searchButton;


    public void clickMyAccount(){

        userAction.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

    public void selectLoginOption(){

        userAction.clickOnElement(loginOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

    public void selectRegisterOption(){

        userAction.clickOnElement(registerOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterSearchBox(String productText){

        userAction.typeTextIntoElement(searchBoxField,productText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnSearchButton(){

        userAction.clickOnElement(searchButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
