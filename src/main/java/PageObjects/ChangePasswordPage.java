package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.concurrent.TimeUnit;

public class ChangePasswordPage extends BasePage{
    /**
     * Locators
     */
    private By inputCurrentPasswprd = By.xpath("//input[@id='currentPassword']");
    private By inputNewPassword = By.xpath("//input[@id='newPassword']");
    private By inputConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private By ButtonOfchangePassword = By.xpath("//input[@value='Change Password']");


    /**
     * Elements
     */
    public WebElement getCurrentPasswordField() {return Constant.DRIVER.findElement(inputCurrentPasswprd);}
    public WebElement getNewPasswordField() {return Constant.DRIVER.findElement(inputNewPassword);}
    public WebElement getConfirmPasswordField() {return Constant.DRIVER.findElement(inputConfirmPassword);}
    public WebElement getChangePasswordButton() {return Constant.DRIVER.findElement(ButtonOfchangePassword);}


    /**
     * Methods
     */
    public void typeCurrentPasswodField(String Currentpassword) {getCurrentPasswordField().sendKeys(Currentpassword);}
    public void typeNewPasswordField(String Newpassword) {getNewPasswordField().sendKeys(Newpassword);}
    public void typeConfirmPasswodField(String Confirmpassword) {getConfirmPasswordField().sendKeys(Confirmpassword);}
    public void clickChangPasswodbutton() {getChangePasswordButton().click();}

    public void typeChangePasswordAllfield() {
        typeCurrentPasswodField(Constant.PASSWORD);
        typeNewPasswordField("a123:{}!@$@@");
        typeConfirmPasswodField("a123:{}!@$@@");
    }

}
