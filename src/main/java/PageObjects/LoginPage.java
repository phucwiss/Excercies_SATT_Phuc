package PageObjects;

import Common.Constant;
import Common.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    /**
     * The web elements' locator Loin Page
     **/
    private By inputEmail = By.xpath("//input[@id='username']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By LoginButton = By.xpath("//*[@value='Login']");
    private By errorMessage = By.xpath("//p[@class='message error LoginForm']");

    /**
     * The Web element
     */
    public WebElement getLoginField() { return Constant.DRIVER.findElement(inputEmail);}
    public WebElement getPasswordField() { return Constant.DRIVER.findElement(inputPassword);}
    public WebElement getLoginButton() { return Constant.DRIVER.findElement(LoginButton);}
    public WebElement getErrorMessage() { return Constant.DRIVER.findElement(errorMessage);}

    /**
     * The Function of Login Page
     */
    public void typeEmailField(String email) { getLoginField().sendKeys(email);}
    public void typePasswordField(String password) { getPasswordField().sendKeys(password);}
    public void clickLoginButton() { getLoginButton().click();}
    public String isErrorMessageAppears() { return getErrorMessage().getText();}



    public void repeatTypeInvalidPassword(String password){
        for(int i = 0; i <= 4;i++){
            typePasswordField(password);
            WebDriverUtils.scrolldown();
            clickLoginButton();
        }
    }
    public void typeValidAccount(String username,String password) {
        typeEmailField(username);
        typePasswordField(password);
        clickLoginButton();
    }
    public void typeAccountWithEmptyEmail(String username,String password) {
        typeEmailField(username);
        typePasswordField(password);
        clickLoginButton();
    }
    public void typeAccountWithInvalidPassword(String username,String password) {
        typeEmailField(username);
        typePasswordField(password);
        clickLoginButton();
    }

}

