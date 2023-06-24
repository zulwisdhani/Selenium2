
import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.utils.Constants;
import com.juaracoding.pageobject.pages.Login;
import com.juaracoding.pageobject.pages.Search;
import com.juaracoding.pageobject.pages.Wishlist;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestWishList {
    public static WebDriver driver;
    private Login login;

    private Search search;

    private Wishlist wishlist;

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
        wishlist = new Wishlist();
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
//        driver.quit();
        DriverSingleton.closeObjectInstance();
    }

    @Test
    public void testAddProductToWishlist() {

        delay(Constants.DETIK);
        // PreCondition one
        login.login("sindy","$Sindy1999");
        delay(Constants.DETIK);
        // PreCondition Two
        search.searchItem();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        wishlist.btnWishlist();
  //      Assert.assertEquals(wishlist.getTxtProductOne(),"BLUE SINNER RIPPED KNEE HIGH WAIST SKINNY JEANS");
        Assert.assertEquals(wishlist.getTxtProductTwo(),"DARK BLUE SINNER DISTRESS KNEE HIGH WAIST SKINNY JEANS");
        System.out.println("Test case add 2 product to wishlist");
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

