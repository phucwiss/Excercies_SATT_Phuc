package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {


    /**
     * The web elements' locator
     **/
    private By TrainTimeTableTab = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
    private By TicketPriceTab = By.xpath("//a[@href='/Page/TrainPriceListPage.cshtml']");
    private By LoginTab = By.xpath("//a[@href='/Account/Login.cshtml']");
    private By BookTicketTab = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    private By ContractTab = By.xpath("//a[@href='/Page/Contact.cshtml']");
    private By LogoutTab = By.xpath("//a[@href='/Account/Logout']");
    private By RegisterTab = By.xpath("//a[@href='/Account/Register.cshtml']");
    private By ChangPasswordTab = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
    private By MyticketdTab = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");



    /**
     * This is  Web elements
     */
    public WebElement getLinkTimeTableTab() {   return Constant.DRIVER.findElement(TrainTimeTableTab);}
    public WebElement getLinkTicketPriceTab() {
        return Constant.DRIVER.findElement(TicketPriceTab);
    }
    public WebElement getLinkLoginTab() {       return Constant.DRIVER.findElement(LoginTab);}
    public WebElement getLinkBookTicketTab() {  return Constant.DRIVER.findElement(BookTicketTab);}
    public WebElement getLinkContractTab() {    return Constant.DRIVER.findElement(ContractTab);}
    public WebElement getLinkLogoutTab() {      return Constant.DRIVER.findElement(LogoutTab);}
    public WebElement getlinkRegisterTab() {    return Constant.DRIVER.findElement(RegisterTab);}
    public WebElement getlinkChPasswordTab(){   return Constant.DRIVER.findElement(ChangPasswordTab);}
    public WebElement getlinkMyTicketTab(){     return Constant.DRIVER.findElement(MyticketdTab);}

    /**
     * Create function
     */
    public void moveToTimeTablePage() {
        getLinkTimeTableTab().click();
    }
    public void moveToTicketPriceTab() {
        getLinkTicketPriceTab().click();
    }
    public void moveToLoginTab(){getLinkLoginTab().click();}
    public void moveToBockTicketTab() {getLinkBookTicketTab().click();}
    public void moveToContractTab() {getLinkContractTab().click();}
    public void moveToLogoutTab() {getLinkLogoutTab().click();}
    public void moveToRegisterTab() {getlinkRegisterTab().click();}
    public void moveToChangePasswordTab(){getlinkChPasswordTab().click();}
    public void moveToMyTicketTab(){getlinkMyTicketTab().click();}


}
