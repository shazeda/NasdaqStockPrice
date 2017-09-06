package pageobjects;

import framework.CommonScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by shazeda on 9/5/17.
 */
public class StockPage {

    @FindBy(css = ".last-sale.displayIB")
    public WebElement stockPrice;

    @FindBy(xpath = "//span[text()='52 Week High']/../../li[4]/span")
    public WebElement fiftyTwoWeekHigh;

    @FindBy(xpath = "//span[text()='52 Week Low']/../../li[4]/span")
    public WebElement fiftyTwoWeekLow;

    @FindBy(xpath = "//a[text()='Full Site']")
    public WebElement fullSite;

    @FindBy(xpath = "//a[@id='eps']/../../td[2]")
    public WebElement eps;

    public float getCurrentPrice() {
        float current = CommonScript.parsePrice(stockPrice.getText());
        return current;
    }

    public float getFiftyTwoWeekHigh() {
        float high = CommonScript.parsePrice(fiftyTwoWeekHigh.getText());
        return high;
    }

    public float getFiftyTwoWeekLow() {
        float low = CommonScript.parsePrice(fiftyTwoWeekLow.getText());
        return low;
    }

    public float getEps() {
        fullSite.click();
        float epsPrice = CommonScript.parsePrice(eps.getText());
        return epsPrice;
    }
}
