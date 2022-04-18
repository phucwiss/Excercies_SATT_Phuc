package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TicketPricePage extends BasePage{

    /**
     * The function of Logout Page
     */
    public String actualPriceList() {
        List<WebElement> actualResult = Constant.DRIVER.findElements(By.xpath("//th[contains(text(),'Price (VND)')]/following-sibling::td"));
        for(int i =0;i<actualResult.toArray().length;i++) {
            String elementText = actualResult.get(i).getText();
            System.out.println(elementText);
        }
        return null;
    }

    public String expectPriceList() {
        String[] expectResult = {"90000", "115000", "140000", "190000", "240000", "290000"};
        for (int i = 0; i < expectResult.length; i++) {
            System.out.println(expectResult[i]);
        }
        return null;
    }

}
