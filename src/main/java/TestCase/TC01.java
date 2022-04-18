package TestCase;



import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC01 extends TestBase {
    LoginPage login = new LoginPage();

    @Test(dataProvider = "dataProvider",description = "User can log into Railway with valid username and password")
    public void TC01(Object[] dataCsv) {
        Log.info("Navigate to QA Railway Website");
        HomePage homepage = new HomePage();

        Log.info("Click on login tab");
        homepage.moveToLoginTab();

        Log.info("Login with valid account");
        login.typeValidAccount(dataCsv[0].toString(),dataCsv[1].toString());

        Log.info("Verify that welcome user display correctly");
        String expectedWelcome = "Welcome "+ dataCsv[0].toString();
        String actualWelcome = homepage.displayedWelcomeUser();
        Assert.assertEquals(actualWelcome,expectedWelcome);


    }
}
