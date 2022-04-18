package PageObjects;

import Common.Constant;
import Common.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends BasePage{
    /**
     * The web elements' locator BookTicket Page
     **/
    private By BookTicketButton = By.xpath("//input[@value='Book ticket']");
    private By DepartFrom = By.xpath("//select[@name='DepartStation']");
    private By ArriveAt = By.xpath("//select[@name='ArriveStation']");
    private By DepartDate = By.xpath("//select[@name='Date']");
    private By Seattype = By.xpath("//select[@name='SeatType']");
    private By Ticketamount = By.xpath("//select[@name='TicketAmount']");
    private By MessageBookSuccess = By.xpath("//h1[@align='center']");




    /**
     * The Web element
     */
    public WebElement getBookTicketButton() {return Constant.DRIVER.findElement(BookTicketButton);}
    public WebElement getDepartFromDropBox() {return Constant.DRIVER.findElement(DepartFrom);}
    public WebElement getArriveAtFromDropBox() { return Constant.DRIVER.findElement(ArriveAt);}
    public WebElement getDepartDateFromDropBox() { return Constant.DRIVER.findElement(DepartDate);}
    public WebElement getSeatTypeFromDropBox() { return Constant.DRIVER.findElement(Seattype);}
    public WebElement getTicketAmountFromDropBox() { return Constant.DRIVER.findElement(Ticketamount);}
    public WebElement getMessageSuccessBookTicket() { return Constant.DRIVER.findElement(MessageBookSuccess);}

    /**
     * The Function of Login Page
     */
    public void textFromDepartDateDropBox(String Date) {
        Select DateDropDown = new Select(getDepartDateFromDropBox());
        DateDropDown.selectByVisibleText(Date);
    }
    public void textFromSeatTypeDropBox(String Seat) {
        Select SeatTypeDropDown = new Select(getSeatTypeFromDropBox());
        SeatTypeDropDown.selectByVisibleText(Seat);
    }
    public void textFromTicketAmountDropBox(String TAmount) {
        Select TicketAmountDropDown = new Select(getTicketAmountFromDropBox());
        TicketAmountDropDown.selectByVisibleText(TAmount);
    }
    public void textFromDepartFromDropBox(String Depart) {
        Select DepartDropDown = new Select(getDepartFromDropBox());
        DepartDropDown.selectByVisibleText(Depart);
        }
    public void textFromArriveAtFromDropBox(String Arrive) {
        Select ArriveDropDown = new Select(getArriveAtFromDropBox());
        ArriveDropDown.selectByVisibleText(Arrive);
    }

    public void clickBookTicketButton() { getBookTicketButton().click();}
    public String verifyBookTicketSuccessfully() {return getMessageSuccessBookTicket().getText();}

    public void selectValidinforfromdropdown(String date,String departfrom,String arriveat,String seattype,String ticketamount){
        textFromDepartDateDropBox(date);
        textFromDepartFromDropBox(departfrom);
        WebDriverUtils.wait(5000);
        textFromArriveAtFromDropBox(arriveat);
        textFromSeatTypeDropBox(seattype);
        textFromTicketAmountDropBox(ticketamount);
    }

}
