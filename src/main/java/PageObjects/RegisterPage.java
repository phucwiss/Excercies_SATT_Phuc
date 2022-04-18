package PageObjects;

import Common.Constant;
import Common.DataRandom;
import Common.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage{
    /**
     * The web elements' locator Loin Page
     **/
    private By InputEmailRes = By.xpath("//input[@id='email']");
    private By InputPasswordlRes = By.xpath("//input[@id='password']");
    private By InputConfirmPasswordlRes = By.xpath("//input[@id='confirmPassword']");
    private By InputPIDRes = By.xpath("//input[@id='pid']");
    private By buttonRegister = By.xpath("//input[@value='Register']");
    private By verifyMessageRes = By.xpath("//div[@id='content']/p[text()]");
    private By verifyMessageEmailUsed = By.xpath("//p[@class='message error']");
    private By verifyMessageInvalidPassLength = By.xpath("//label[@class='validation-error' and @for='password']");
    private By verifyMessageInvalidPIDLength = By.xpath("//label[@class='validation-error' and @for='pid']");



    /**
     * The Web element
     */
    public WebElement getEmailField() {return Constant.DRIVER.findElement(InputEmailRes);}
    public WebElement getPasswordlResField() {return Constant.DRIVER.findElement(InputPasswordlRes);}
    public WebElement getConfirmPasswordlResField() {return Constant.DRIVER.findElement(InputConfirmPasswordlRes);}
    public WebElement getPIDResField() {return Constant.DRIVER.findElement(InputPIDRes);}
    public WebElement getRegisterButton() {return Constant.DRIVER.findElement(buttonRegister);}
    public WebElement getMessageResSuccess() {return Constant.DRIVER.findElement(verifyMessageRes);}
    public WebElement getMessageEmailUsed() {return Constant.DRIVER.findElement(verifyMessageEmailUsed);}
    public WebElement getMessageInvalidPassLength() {return Constant.DRIVER.findElement(verifyMessageInvalidPassLength);}
    public WebElement getMessageInvalidPIDLength() {return Constant.DRIVER.findElement(verifyMessageInvalidPIDLength);}


    /**
     * The Function of Register Page
     */
    public void typeEmailResField(String email) { getEmailField().sendKeys(email);}
    public void typePasswordResField(String password) { getPasswordlResField().sendKeys(password);}
    public void typeConfirmPasswordlResField(String cPassword) { getConfirmPasswordlResField().sendKeys(cPassword);}
    public void typePIDResField(String pid) { getPIDResField().sendKeys(pid);}
    public void clickRegisterButton() { getRegisterButton().click();}
    public String isSuccessMessageAppears() { return getMessageResSuccess().getText();}
    public String isMessageEmailUsedAppears() {return getMessageEmailUsed().getText();}
    public String isMessageInvalidPassLengthAppears() {return getMessageInvalidPassLength().getText();}
    public String isMessageInvalidPIDLengthAppears() {return getMessageInvalidPIDLength().getText();}

    public void typeValidinforIntoAllField(String username,String password,String confpassword,String pid) {
        typeEmailResField(username);
        typePasswordResField(password);
        typeConfirmPasswordlResField(confpassword);
        typePIDResField(pid);
        clickRegisterButton();
    }
    public void typeOnlyEmailField(String username,String password,String confpassword,String pid) {
        typeEmailResField(username);
        typePasswordResField(password);
        typeConfirmPasswordlResField(confpassword);
        typePIDResField(pid);
        clickRegisterButton();
    }

    public void typeEmailUsed(Object[] dataCsv){
        HomePage homepage = new HomePage();
        RegisterPage register = new RegisterPage();
        String email = DataRandom.generateRandomEmail(dataCsv[0].toString());
        for(int i=0;i<2;i++) {
            //Click on register tab
            homepage.moveToRegisterTab();

            //Maximaze and scroll browser
            WebDriverUtils.maximize();
            WebDriverUtils.scrolldown();

            //Enter valid all field with email used
            register.typeValidinforIntoAllField(email, dataCsv[1].toString(), dataCsv[2].toString(), dataCsv[3].toString());
        }
    }


}
