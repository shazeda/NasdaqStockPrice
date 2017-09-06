package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomePage;
import pageobjects.StockPage;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by shazeda on 9/5/17.
 */
public class CommonScript {

    protected WebDriver driver;
    protected HomePage homePage;
    protected StockPage stockPage;

    private static final String browserstackUser = "USER";
    private static final String browserstackKey = "KEY";
    private static final String browserstackUrl  = "https://" + browserstackUser + ":" + browserstackKey + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeMethod
    public void setup() throws Exception {

        DesiredCapabilities capabilities = DesiredCapabilities.android();
        driver = new RemoteWebDriver(new URL(browserstackUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        visitHome();
        homePage = PageFactory.initElements(driver, HomePage.class);
        stockPage = PageFactory.initElements(driver, StockPage.class);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

    public void visitHome() {
        driver.get("http://m.nasdaq.com");
    }

    public static void print(Object obj){
        System.out.println(obj);
    }

    public static float parsePrice(String text) {
        return Float.parseFloat(text.replace("$", "").trim());
    }

    public void executeJavascript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    public void removeAds() {
        executeJavascript("document.querySelector('.footer .makeAd').innerHTML = ''");
    }
}
