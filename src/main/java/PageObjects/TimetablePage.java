package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends BasePage {
    /**
     * The web elements' locator Timetable Page
     **/
    private By TitleTrainTimeTable = By.xpath("//h1[text()='Train Timetable']");
    private By verifycheckprice = By.xpath("//tr/td[count(//*[text()='Depart Station']/preceding-sibling::*)+1][text()='Đà Nẵng']/../td[count(//*[text()='Arrive Station']/preceding-sibling::*)+1][text()='Sài Gòn']/../td/a[text()='check price']");


    /**
     * The Web element
     */
    public WebElement getTitleTrainTimeTable() {
        return Constant.DRIVER.findElement(TitleTrainTimeTable);
    }
    public WebElement getLinkCheckPrice() { return Constant.DRIVER.findElement(verifycheckprice);}


    /**
     * The methods of Timetable Page
     */
    public String getTitleTrainTimeTableText() {
        return getTitleTrainTimeTable().getText();
    }
    public void clickLinkCheckPrice() {getLinkCheckPrice().click();}


}
