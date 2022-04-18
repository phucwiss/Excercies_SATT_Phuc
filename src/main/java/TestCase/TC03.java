package TestCase;


import Common.Log;
import Common.TestBase;
import Common.WebDriverUtils;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends TestBase {
    LoginPage login = new LoginPage();

    @Test(dataProvider = "dataProvider",description = "User cannot log into Railway with invalid password ")
    public void TC03(Object[] dataCsv){
        Log.info("Navigate to QA Railway website");
        HomePage homepage = new HomePage();

        Log.info("Maximize browser");
        WebDriverUtils.maximize();

        Log.info("Click on login tab");
        homepage.moveToLoginTab();

        Log.info("Enter valid Email and invalid Password");
        login.typeAccountWithInvalidPassword(dataCsv[0].toString(),dataCsv[1].toString());

        Log.info("Verify that ErrorMessage appears");
        String expectErrorMessageLogin = "Invalid username or password. Please try again.";
        String actualErrorMessageLogin = login.isErrorMessageAppears();
        Assert.assertEquals(actualErrorMessageLogin,expectErrorMessageLogin);
    }
}
