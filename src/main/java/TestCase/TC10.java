package TestCase;

import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase {
    RegisterPage register = new RegisterPage();

    @Test(dataProvider = "dataProvider",description = "User can't create account with an already in-use email")
    public void TC10(Object[] dataCsv) {
        Log.info("Navigate to QA Railway website");
        HomePage homepage = new HomePage();

        Log.info("Click on register tab");
        homepage.moveToRegisterTab();

        Log.info("Enter information of the created account in Pre-condition and click register button");
        register.typeEmailUsed(dataCsv);

        Log.info("Verify that Error message displays above the form.");
        String expectErrorMessageEmailUsed = "This email address is already in use.";
        String actualErrorMessageEmailUsed = register.isMessageEmailUsedAppears();
        Assert.assertEquals(expectErrorMessageEmailUsed,actualErrorMessageEmailUsed);

    }
}
