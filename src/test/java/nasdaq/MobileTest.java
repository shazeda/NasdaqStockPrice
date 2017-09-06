package nasdaq;

import framework.CommonScript;
import org.testng.annotations.Test;

/**
 * Created by shazeda on 9/5/17.
 */
public class MobileTest extends CommonScript{

    static final String companyA = "aapl";
    static final String companyB = "goog";

    @Test
    public void compareHighAndLow(){

        homePage.search(companyA);
        float current = stockPage.getCurrentPrice();
        print("Current Stock Price for " + companyA + " is " + current);

        float high = stockPage.getFiftyTwoWeekHigh();
        float low = stockPage.getFiftyTwoWeekLow();

        float highPercentage = (high - current) / high * 100;
        float lowPercentage = (current - low) / low * 100;

        print(String.format("Price is %.2f%% lower than 52 week high %f", highPercentage, high));
        print(String.format("Price is %.2f%% higher than 52 week low %f", lowPercentage, low));
    }

    @Test
    public void compareEPS() {

        homePage.search(companyA);
        removeAds();
        float epsPriceA = stockPage.getEps();
        print("EPS for " + companyA + " is " + epsPriceA);

        visitHome();
        homePage.search(companyB);
        removeAds();
        float epsPriceB = stockPage.getEps();
        print("EPS for " + companyB + " is " + epsPriceB);

        if (epsPriceA > epsPriceB) {
            print(companyA + " has higher EPS than " + companyB);
        } else if (epsPriceB > epsPriceA) {
            print(companyB + " has higher EPS than " + companyA);
        } else {
            print("both of the companies have same EPS.");
        }
    }
}


