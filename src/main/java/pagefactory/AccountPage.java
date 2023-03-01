package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private static WebDriver driver;

    public AccountPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(linkText="Edit your account information")
    private WebElement accountPage;

    public boolean AccountPageValidation(){

        Boolean value;
        value=accountPage.isDisplayed();
        return value;
    }
}
