package TestCase;

import Common.DataRandom;
import Common.Log;
import Common.TestBase;
import Common.WebDriverUtils;
import PageObjects.ChangePasswordPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.annotations.Test;

public class TC09 extends TestBase {
    LoginPage login = new LoginPage();
    ChangePasswordPage changepassword = new ChangePasswordPage();
    RegisterPage register = new RegisterPage();

    @Test(dataProvider = "dataProvider",description = "User can't change password when New Password and Confirm Password are different.")
    public void TC09(Object[] dataCsv) {
        Log.info("Navigate to QA Railway website");
        HomePage homepage = new HomePage();

        Log.info("Click on register tab"); // precondition
        homepage.moveToRegisterTab();

        Log.info("maximize and scrolldown browser");
        WebDriverUtils.maximize();
        WebDriverUtils.scrolldown();

        Log.info("Enter valid email, password and confirm password and PID");
        String email = DataRandom.generateRandomEmail(dataCsv[0].toString());
        register.typeValidinforIntoAllField(email,dataCsv[1].toString(),dataCsv[2].toString(),dataCsv[3].toString());

        Log.info("Click on Login tab");
        homepage.moveToLoginTab();

        Log.info("Login with valid account");
        login.typeValidAccount(email,dataCsv[1].toString());

        Log.info("Click on Change Password tab");
        homepage.moveToChangePasswordTab();

        Log.info("Enter full fill in change password page");
        changepassword.typeChangePasswordAllfield();

        Log.info("Click on change password button");
        changepassword.clickChangPasswodbutton();

    }
}
