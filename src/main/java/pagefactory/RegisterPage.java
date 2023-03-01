package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.UserAction;

public class RegisterPage {

    WebDriver driver;
    private UserAction userAction;


    public RegisterPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
        userAction = new UserAction(driver);

    }

    @FindBy(id="input-firstname")
    private WebElement firstNameField;

    @FindBy(id="input-lastname")
    private WebElement lastNameField;

    @FindBy(id="input-email")
    private WebElement emailField;

    @FindBy(id="input-telephone")
    private WebElement telephoneField;

    @FindBy(id="input-password")
    private WebElement passwordField;

    @FindBy(id="input-confirm")
    private WebElement passwordConfirmField;

    @FindBy(name="agree")
    private WebElement privacyPolicyOption;

    @FindBy(xpath="//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath="//input[@name='newsletter'][@value='1']")
    private WebElement yesNewsletterOption;

    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
    private WebElement warningMessage;

    @FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
    private WebElement firstNameWarning;

    @FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
    private WebElement lastNameWaring;

    @FindBy(xpath="//input[@id='input-email']/following-sibling::div")
    private WebElement emailWarning;

    @FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
    private WebElement telephoneWarning;

    @FindBy(xpath="//input[@id='input-password']/following-sibling::div")
    private WebElement passwordWarning;


    public void enterFirstName(String firstNameText){

        userAction.typeTextIntoElement(firstNameField,firstNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterLastName(String lastNameText){

        userAction.typeTextIntoElement(lastNameField,lastNameText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

    public  void enterEmail(String emailText){

        userAction.typeTextIntoElement(emailField,emailText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterTelephoneNo(String telephoneText){

        userAction.typeTextIntoElement(telephoneField,telephoneText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void enterPassword(String passwordText){

        userAction.typeTextIntoElement(passwordField,passwordText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterConfirmPassword(String confirmPass){

        userAction.typeTextIntoElement(passwordConfirmField,confirmPass,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickPrivacyPolicy(){

        privacyPolicyOption.click();
    }

    public void clickContinueButton(){

        continueButton.click();
    }

    public void selectNewsLetter(){

        yesNewsletterOption.click();

    }

    public String getWarningMessage(){

        String warrenMessage = warningMessage.getText();
        return warrenMessage;
    }
    public String getFirstNameWarningMessage(){

        String firstNameMessage = firstNameWarning.getText();
        return firstNameMessage;
    }
    public  String getLastNameWarningMessage(){

        String lastNameMessage = lastNameWaring.getText();
        return lastNameMessage;
    }
    public  String getEmailWarningMessage(){

        String emailMessage = emailWarning.getText();
        return emailMessage;
    }
    public  String getPasswordWarningMessage(){

        String passwordMessage = passwordWarning.getText();
        return passwordMessage;
    }
    public  String getTelephoneWarningMessage(){

        String telephoneMessage = telephoneWarning.getText();
        return telephoneMessage;
    }

}

