package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Logout extends BasePage {
    /**
     * The web elements' locator
     **/
    private By visibleLogoutTab = By.xpath("//div[@id='menu']/descendant::span[text()='Log out']");


    /**
     * This is  Web elements
     *
     */
    public WebElement verifyLogoutTab() {
        return Constant.DRIVER.findElement(visibleLogoutTab);
    }


    /**
     * The Method of Logout
     */
    public String getTextTabBeforeLogout() {
        return verifyLogoutTab().getText();
    }

    /**
     * The function of Logout
     */
    public String getTextTabafterLogout() {
        List<WebElement> listElement = Constant.DRIVER.findElements(By.xpath("//div[@id='menu']/descendant::a"));
        for (int i = 0; i < listElement.size(); i++) {
            String elementText = listElement.get(i).getText();
            System.out.println(elementText);
        }
        return "";
    }


}