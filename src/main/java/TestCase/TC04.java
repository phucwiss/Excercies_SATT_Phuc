package TestCase;

import Common.Constant;
import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase {
    LoginPage login = new LoginPage();

    @Test(dataProvider = "dataProvider",description = "User is redirected to Book ticket page after logging in")
    public void TC04(Object[] dataCsv){
        Log.info("Navigate to QA Railway website");
        HomePage homepage = new HomePage();

        Log.info(" Click on book ticket tab and user is directed to login page");
        homepage.moveToBockTicketTab();

        Log.info("Login With valid account ");
        login.typeValidAccount(dataCsv[0].toString(),dataCsv[1].toString());

        Log.info("Compare URL book ticket page displays with book ticket form opens");
        String expectBookTicketurl = "http://www.raillog.somee.com/Page/BookTicketPage.cshtml";
        String actualexpectBookTicketurl = Constant.DRIVER.getCurrentUrl();
        Assert.assertEquals(actualexpectBookTicketurl,expectBookTicketurl);
    }
}
