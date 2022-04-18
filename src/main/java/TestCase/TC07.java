package TestCase;

import Common.DataRandom;
import Common.Log;
import Common.TestBase;
import Common.WebDriverUtils;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    RegisterPage register = new RegisterPage();

    @Test(dataProvider = "dataProvider",description = "User can create new account")
    public void TC07(Object[] dataCsv){
        Log.info("Navigate to QA Railway website");
        HomePage homepage = new HomePage();

        Log.info("Click on register tab");
        homepage.moveToRegisterTab();

        Log.info("maximaze and scrolldown browser");
        WebDriverUtils.maximize();
        WebDriverUtils.scrolldown();

        Log.info("Enter valid email, password and confirm password and PID");
        String email = DataRandom.generateRandomEmail(dataCsv[0].toString());
        register.typeValidinforIntoAllField(email,dataCsv[1].toString(),dataCsv[2].toString(),dataCsv[3].toString());

        Log.info("verify that message register successful correctly");
        String expectRegisterSuccess = "You're here";
        String actualRegisterSuccess = register.isSuccessMessageAppears();
        Assert.assertEquals(actualRegisterSuccess,expectRegisterSuccess);





    }
}
