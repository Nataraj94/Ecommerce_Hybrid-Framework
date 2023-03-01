package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reuseable.BaseClass;
import utils.CommonUtils;
import utils.UserAction;

public class LoginPage{

    WebDriver driver;
   private UserAction userAction;

   public LoginPage(WebDriver driver){

       this.driver=driver;
       PageFactory.initElements(driver,this);
       userAction = new UserAction(driver);
   }

   @FindBy(id="input-email")
    private WebElement emailField;

   @FindBy(id="input-password")
    private WebElement passwordField;

    @FindBy(xpath="//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
    private WebElement warningMessage;


    public void enterEmailAddress(String emailText) {

        userAction.typeTextIntoElement(emailField, emailText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

    public void enterPassword(String password){

        userAction.typeTextIntoElement(passwordField,password,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickLogin(){

        userAction.clickOnElement(loginButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

    public String getWarningMessageText(){

        String message = userAction.getTextFromElement(warningMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return message;
    }

}
