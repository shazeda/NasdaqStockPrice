package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by shazeda on 9/5/17.
 */
public class HomePage {

    @FindBy(id = "stock-symbol")
    public WebElement searchBox;

    @FindBy(id = "stock-submit")
    public WebElement searchSubmit;

    public void search(String text) {
        searchBox.sendKeys(text);
        searchSubmit.click();
    }
}
