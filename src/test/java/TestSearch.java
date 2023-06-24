import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.utils.Constants;
import com.juaracoding.pageobject.pages.Login;
import com.juaracoding.pageobject.pages.Search;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestSearch {
    public static WebDriver driver;
    private Login login;

    private Search search;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.LOGIN_URL);
    }

    @BeforeMethod
    public void pageObject() {
        login = new Login();
        search = new Search();
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
//        driver.quit();
        DriverSingleton.closeObjectInstance();
    }

    @Test
    public void testSearch() {
        delay(Constants.DETIK);
        //PreCondition
        login.login("sindy","$Sindy");
        delay(Constants.DETIK);
        search.searchItem();
        Assert.assertTrue(search.getTxtJeans().contains("Jeans"));
        System.out.println("Test case Search");
    }

    static void delay(int detik) {
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
