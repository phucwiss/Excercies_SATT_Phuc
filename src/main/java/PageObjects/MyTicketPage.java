package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends BasePage{
    /**
     * The web elements' locator Loin Page
     **/
    private By CancleButton = By.xpath("//input[@value='Cancel']");


    /**
     * The Web element
     */
    public WebElement getCancelButton() {return Constant.DRIVER.findElement(CancleButton);}

    /**
     * The Method of Login Page
     */
    public void clickCancelTicketButton() {getCancelButton().click();}
    public void clickConfirmCancel() {Constant.DRIVER.switchTo().alert().accept();}

}
