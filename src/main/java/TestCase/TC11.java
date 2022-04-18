package TestCase;

import Common.Log;
import Common.TestBase;
import Common.WebDriverUtils;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC11 extends TestBase {
    RegisterPage register = new RegisterPage();

    @Test(dataProvider = "dataProvider",description = "User can't create account while password and PID fields are empty")
    public void TC11(Object[] dataCsv) {
        Log.info("Navigate to QA Railway website");
        HomePage homepage = new HomePage();

        Log.info("Click on register tab");
        homepage.moveToRegisterTab();

        Log.info("maximaze and scrolldown browser");
        WebDriverUtils.maximize();
        WebDriverUtils.scrolldown();

        Log.info("Enter only email and other empty");
        register.typeOnlyEmailField(dataCsv[0].toString(),dataCsv[1].toString(),dataCsv[2].toString(),dataCsv[3].toString());

        Log.info("Verify that Error message displays above the form.");
        String expectErrorMessageabove = "There're errors in the form. Please correct the errors and try again.";
        String actualErrorMessageabove = register.isMessageEmailUsedAppears();
        Assert.assertEquals(expectErrorMessageabove,actualErrorMessageabove);

        Log.info("Verify that error message appears beside password field");
        String expectMessagePassField = "Invalid password length";
        String actualMessagePassField = register.isMessageInvalidPassLengthAppears();
        Assert.assertEquals(expectMessagePassField,actualMessagePassField);

        Log.info("Verify that error message appears beside email field");
        String expectMessagePidField = "Invalid ID length";
        String actualMessagePidField = register.isMessageInvalidPIDLengthAppears();
        Assert.assertEquals(expectMessagePidField,actualMessagePidField);

    }
}
