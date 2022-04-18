package TestCase;

import Common.*;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15 extends TestBase {
    LoginPage login = new LoginPage();
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketprice = new TicketPricePage();
    RegisterPage register = new RegisterPage();


    @Test(dataProvider = "dataProvider",description = "Ticket price page displays with ticket details after clicking on check price link in Train timetable page")
    public void TC15(Object[] dataCsv) {
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

        Log.info("Click on timetable tab");
        homepage.moveToTimeTablePage();

        Log.info("Maximize and scroll down browser");
        WebDriverUtils.maximize();
        WebDriverUtils.scrolldown();

        Log.info("Click on 'check price' link of the route from 'Đà Nẵng' to 'Sài Gòn'");
        timetablePage.clickLinkCheckPrice();

        Log.info("Verify that after click 'check price' ticket price show correctly");
        Assert.assertEquals(ticketprice.actualPriceList(),ticketprice.expectPriceList());
    }
}

