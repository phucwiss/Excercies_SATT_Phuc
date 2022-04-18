package TestCase;

import Common.*;
import PageObjects.*;
import org.testng.annotations.Test;


public class TC16 extends TestBase {
    LoginPage login = new LoginPage();
    MyTicketPage myTicket = new MyTicketPage();
    RegisterPage register = new RegisterPage();
    BookTicketPage bookticket = new BookTicketPage();

    @Test(dataProvider = "dataProvider",description = "User can cancel a ticket")
    public void TC16(Object[] dataCsv) {
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
        WebDriverUtils.scrolldown();

        Log.info("Select all field in dropdow");
        bookticket.selectValidinforfromdropdown(dataCsv[4].toString(),dataCsv[5].toString(),dataCsv[6].toString(),dataCsv[7].toString(),dataCsv[8].toString());

        Log.info("Click on book ticket button");
        bookticket.clickBookTicketButton();

        Log.info("Click on My Ticket tab");
        homepage.moveToMyTicketTab();

        Log.info("Click on cancel button");
        myTicket.clickCancelTicketButton();

        Log.info(" Click on 'OK' button on Confirmation message 'Are you sure?' ");
        myTicket.clickConfirmCancel();

    }
}
