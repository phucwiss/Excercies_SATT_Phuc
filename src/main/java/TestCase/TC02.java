package TestCase;

import Common.Constant;
import Common.Log;
import Common.TestBase;
import Common.WebDriverUtils;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends TestBase {
    LoginPage login = new LoginPage();


    @Test(dataProvider = "dataProvider",description = "User can't login with blank Username textbox")
    public void TC02(Object[] dataCsv) {

        Log.info("Navigate to QA Railway website");
        HomePage homepage = new HomePage();

        Log.info("Maximize browser");
        WebDriverUtils.maximize();

        Log.info("Click on login tab");
        homepage.moveToLoginTab();

        Log.info("Login with valid account and empty email");
        login.typeAccountWithEmptyEmail(dataCsv[0].toString(),dataCsv[1].toString());

        Log.info("Verify that ErrorMessage appears");
        String expectErrorMessageLogin = "There was a problem with your login and/or errors exist in your form.";
        String actualErrorMessageLogin = login.isErrorMessageAppears();
        Assert.assertEquals(actualErrorMessageLogin,expectErrorMessageLogin);


    }
}
