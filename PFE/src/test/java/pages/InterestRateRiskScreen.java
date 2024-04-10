package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.AbstractPageObject;

public class InterestRateRiskScreen extends AbstractPageObject {

    public static final String ANALYSIS_DATE_PICKER = "//*[@id=\"analysisDate\"]";
    public static final String REFERENECE_DATE_PICKER = "//*[@id=\"date\"]";
    public static final String PORTFOLIO_SELECT_INPUT = "/html/body/app-root/app-main/div/div[1]/div/app-interest-rate-risk/app-interest-rate-filter/div/div/div[1]/div[3]/div/p-multiselect";
    public static final String INSTRUMENT_SELECT_INPUT = "/html/body/app-root/app-main/div/div[1]/div/app-interest-rate-risk/app-interest-rate-filter/div/div/div[1]/div[4]/div/p-multiselect";
    public static final String RATETYPE_SELECT_INPUT = "/html/body/app-root/app-main/div/div[1]/div/app-interest-rate-risk/app-interest-rate-filter/div/div/div[1]/div[5]/div/p-multiselect/div";

    @FindBy(how = How.XPATH ,using = ANALYSIS_DATE_PICKER)
    public WebElement AnalysisDatePicker;

    @FindBy(how = How.XPATH , using = REFERENECE_DATE_PICKER)
    public WebElement ReferenceDatePicker;

    @FindBy(how = How.XPATH , using = PORTFOLIO_SELECT_INPUT)
    public WebElement PortfolioSelectInput;

    @FindBy(how = How.XPATH , using = INSTRUMENT_SELECT_INPUT)
    public WebElement InstrumentSelectInput;

    @FindBy(how = How.XPATH , using = RATETYPE_SELECT_INPUT)
    public WebElement RateTypeSelectInput;

    @Step("Choose Analysis Date")
    public void enteranalysisdate(String date) throws InterruptedException {
        Thread.sleep(1000);
        AnalysisDatePicker.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        //Thread.sleep(3000);
        AnalysisDatePicker.sendKeys(date);
        AnalysisDatePicker.click();
    }
    @Step("Choose Reference Date")
    public void enterreferencedate(String date) throws InterruptedException {
        Thread.sleep(1000);
        ReferenceDatePicker.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        //Thread.sleep(3000);
        ReferenceDatePicker.sendKeys(date);
        ReferenceDatePicker.click();
    }


  


}
