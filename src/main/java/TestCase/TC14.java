package TestCase;

import Common.*;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends TestBase {
    LoginPage login = new LoginPage();
    BookTicketPage bookticket = new BookTicketPage();
    RegisterPage register = new RegisterPage();

    @Test(dataProvider = "dataProvider",description = "User can book many tickets at a time")
    public void TC14(Object[] dataCsv) {
        Log.info("Navigate to QA Railway Website");
        HomePage homepage = new HomePage();

        Log.info("Click on register tab");
        homepage.moveToRegisterTab();

        Log.info("Maximaze and scroll browser");
        WebDriverUtils.maximize();
        WebDriverUtils.scrolldown();

        Log.info("Enter valid all field with email used");
        String email = DataRandom.generateRandomEmail(dataCsv[0].toString());
        register.typeValidinforIntoAllField(email, dataCsv[1].toString(), dataCsv[2].toString(), dataCsv[3].toString());


        Log.info("Click on Login tab");
        homepage.moveToLoginTab();

        Log.info("Login with valid account");
        login.typeValidAccount(email,dataCsv[1].toString());

        Log.info("Click on book ticket tab");
        bookticket.moveToBockTicketTab();

        Log.info("Maximize and scroll down browser");
        WebDriverUtils.maximize();
        WebDriverUtils.scrolldown();

        Log.info("Select all field in dropdow");
        bookticket.selectValidinforfromdropdown(dataCsv[4].toString(),dataCsv[5].toString(),dataCsv[6].toString(),dataCsv[7].toString(),dataCsv[8].toString());

        Log.info("Click on book ticket button");
        bookticket.clickBookTicketButton();

        Log.info("Verify that message book ticket successfully");
        String expectMessageBookSuccess = "Ticket Booked Successfully!";
        String actualMessageBookSuccess = bookticket.verifyBookTicketSuccessfully();
        Assert.assertEquals(expectMessageBookSuccess,actualMessageBookSuccess);

    }
}
