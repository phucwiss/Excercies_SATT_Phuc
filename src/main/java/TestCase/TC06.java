package TestCase;

import Common.Constant;
import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.Logout;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {
    LoginPage login = new LoginPage();
    Logout logout = new Logout();

    @Test(dataProvider = "dataProvider",description = "User is redirected to Home page after logging out")
    public void TC06(Object[] dataCsv){
        Log.info("Navigate to QA Railway website");
        HomePage homepage = new HomePage();

        Log.info("Click on login tab");
        homepage.moveToLoginTab();

        Log.info("Login With valid account ");
        login.typeValidAccount(dataCsv[0].toString(),dataCsv[1].toString());

        Log.info("Click on contact tab");
        homepage.moveToContractTab();

        Log.info("get button logout text after log out");
        String expectLogout = logout.getTextTabBeforeLogout();
        System.out.println(expectLogout);

        Log.info("Click on logout tab");
        homepage.moveToLogoutTab();

        Log.info("Home page displays.");
        String expectBookTicketurl = "http://www.raillog.somee.com/Page/HomePage.cshtml";
        String actualexpectBookTicketurl = Constant.DRIVER.getCurrentUrl();
        Assert.assertEquals(actualexpectBookTicketurl,expectBookTicketurl);

        Log.info("Verify that Log out tab is disappeared.");
        String actualLogout = logout.getTextTabafterLogout();
        System.out.println(actualLogout);
        Assert.assertNotEquals(expectLogout,actualLogout);


    }
}
