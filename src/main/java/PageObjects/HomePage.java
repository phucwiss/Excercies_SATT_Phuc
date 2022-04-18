package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    /**
     * Locators
     */
//    private By WelcomeText = By.xpath("//div[@class='account']/descendant::strong");
    private By WelcomeText = By.xpath("//div[@class='account']/strong");



    /**
     * Elements
     */
    public WebElement getTextWelcome() { return Constant.DRIVER.findElement(WelcomeText);}

    /**
     * Methods
     */
    public String displayedWelcomeUser() { return getTextWelcome().getText();}


}
