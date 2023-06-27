import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.AddtoCart;
import com.juaracoding.pageobject.pages.Login;
import com.juaracoding.pageobject.pages.Search;
import com.juaracoding.pageobject.utils.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAdd {
    public static WebDriver driver;
    private Login login;

    private Search search;

    private AddtoCart addtoCart;

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
        addtoCart = new AddtoCart();
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
//        driver.quit();
        DriverSingleton.closeObjectInstance();
    }

    @Test
    public void testAddProductToCart() {

        delay(Constants.DETIK);
        // PreCondition one
        login.login("sindy","$Sindy1999");
        delay(Constants.DETIK);
        // PreCondition Two
        search.searchItem();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        addtoCart.btnAddtoCart();
     //   Assert.assertEquals(addtoCart.getTxtProductOne(),"DARK BLUE VICE HIGH WAISTED SLASH KNEE SKINNY JEANS");
        //Assert.assertEquals(addtoCart.getTxtProductTwo(),"DARK BLUE SINNER DISTRESS KNEE HIGH WAIST SKINNY JEANS");
        System.out.println("DARK BLUE VICE HIGH WAISTED SLASH KNEE SKINNY JEANS");
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

