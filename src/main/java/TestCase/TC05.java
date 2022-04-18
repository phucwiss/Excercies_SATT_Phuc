package TestCase;

import Common.Constant;
import Common.Log;
import Common.TestBase;
import Common.WebDriverUtils;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 extends TestBase {
    LoginPage login = new LoginPage();


    @Test(dataProvider = "dataProvider",description = "System shows message when user enters wrong password several times")
    public void TC05(Object[] dataCsv) {
        Log.info("Navigate to QA Railway Website");
        HomePage homepage = new HomePage();

        Log.info("Maximize browser");
        WebDriverUtils.maximize();

        Log.info("Click on login tab");
        homepage.moveToLoginTab();

        Log.info("Enter valid email ");
        login.typeEmailField(dataCsv[0].toString());

        Log.info("Repeat the login fail password 4 times");
        login.repeatTypeInvalidPassword(dataCsv[1].toString());

        Log.info("Verify that ErrorMessage appears after login fail 3 times");
        String expectErrorMessageLogin = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        String actualErrorMessageLogin = login.isErrorMessageAppears();
        Assert.assertEquals(actualErrorMessageLogin,expectErrorMessageLogin);
    }
}
