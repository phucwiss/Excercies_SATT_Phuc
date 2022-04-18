package Common;

import com.opencsv.CSVReader;
import org.testng.annotations.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestBase extends Log {
    @BeforeSuite
    @Parameters("browser")
    public void beforeSuite(String BrowserName) {
        Constant.BROWSER = BrowserName;
        WebDriverUtils.initDriver();
        WebDriverUtils.navigate(Constant.RAILWAY_URL);
        Constant.DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterSuite(description = "end")
    public static void shutdoww() {
        WebDriverUtils.quitBrowser();
    }

    @DataProvider
    public Iterator<Object[]> dataProvider() throws IOException {
        String path = "src\\main\\java\\DataObjects\\" + this.getClass().getSimpleName() + ".csv";

        Reader reader = new FileReader(path);
        CSVReader csvreader = new CSVReader(reader);
        List<Object[]> list = new ArrayList<>();
        String[] nextLine = csvreader.readNext();

        while (nextLine != null) {
            Object[] objLine = nextLine;
            list.add(objLine);
            nextLine = csvreader.readNext();
        }
        Iterator<Object[]> dataCsv = list.iterator();
        return dataCsv;
    }
}
