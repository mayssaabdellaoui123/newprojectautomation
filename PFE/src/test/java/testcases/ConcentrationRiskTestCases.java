package testcases;

import io.qameta.allure.*;
import listeners.TestListener;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.ConcentrationRiskScreen;
import pages.LoginScreen;
import pages.Menu;
import testdata.DataFromGoogleSheet;
import utilities.BaseFile;
import utilities.Utility;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.stream.Collectors;

@Listeners({ TestListener.class })
@Epic("Functional tests")
@Feature("Concentration Risk Tests")
public class ConcentrationRiskTestCases extends BaseFile {




    Menu menu ;
    LoginScreen loginScreen;
    ConcentrationRiskScreen concentrationRiskScreen;
    DataFromGoogleSheet dataFromgoogle = new DataFromGoogleSheet();
    Utility utility;


    public ConcentrationRiskTestCases() throws GeneralSecurityException, IOException {
    }


    @BeforeMethod()
    public void start() throws GeneralSecurityException, IOException, InterruptedException {
        loadConfig();
        startApp();
        loginScreen = new LoginScreen();
        loginScreen.loginForTest();
        menu = new Menu();
        menu.enterConcentrationRiskScreen();

    }

    @Test(priority = 1)
    @Description("First Scenario Concentration Risk")
    @Severity(SeverityLevel.CRITICAL)
    public void FirstScenario () throws InterruptedException, GeneralSecurityException, IOException {
        concentrationRiskScreen = new ConcentrationRiskScreen();
        utility = new Utility();
        SoftAssert s_assert = new SoftAssert();

        Thread.sleep(2000);
        concentrationRiskScreen.enteranalysisdate(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B4").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.enterreferencedate(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B5").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.chooseInstrument(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B8:D8").get(0).get(0)),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B8:D8").get(0).get(1))
        ,String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B8:D8").get(0).get(2)));
        Thread.sleep(2000);
        concentrationRiskScreen.chooseSector(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B7:D7").get(0).get(0)),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B7:D7").get(0).get(1)),
                String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B7:D7").get(0).get(2)));
        Thread.sleep(2000);
        concentrationRiskScreen.choosePortfolio(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B6").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.chooseEmetteur(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B9").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.clickSearchButton();
        Thread.sleep(5000);

        /* Concentration Par Action */
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ActionConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B11").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ActionConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!D11").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.ActionConcentrationVariationValue),"#ffc102");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationActionConcentration)).contains("variation-stable"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineActionConcentration));
        /* Concentration Par Action */
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ObligationConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B12").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ObligationConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!D12").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.ObligationConcentrationVariationValue),"#ffc102");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationObligationConcentration)).contains("variation-stable"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineObligationConcentration));
        /* Concentration Marché Monitaire */
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.MonitaireConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B13").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.MonitaireConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!D13").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.MonitaireConcentrationVariationValue),"#ffc102");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationMonitaireConcentration)).contains("variation-stable"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineMonitaireConcentration));
        /* Concentration Des Depôts */
        Assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.DepotsConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B14").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.DepotsConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!D14").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.DepotsConcentrationVariationValue),"#ffc102");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationDepotsConcentration)).contains("variation-stable"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineDepotsConcentration));
        /*HHI Index*/
        s_assert.assertEquals(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B15").get(0).get(0)),concentrationRiskScreen.verify_HHI_Index());
        /*Concentration on Assets Contrepartie*/
        s_assert.assertEquals(utility.sortData(concentrationRiskScreen.verifyTableActifConcentrationValues()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!A17:D19"));
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForActifTable).replace(" Counterparts","")), dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!A17:D19").size());
        concentrationRiskScreen.chooseGroupOrCounterpartyActif("Group");
        System.out.println(concentrationRiskScreen.verifyTableActifConcentrationValues());
        List<String> vide = new ArrayList<>();
        s_assert.assertEquals( concentrationRiskScreen.verifyTableActifConcentrationValues(), vide );
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForActifTable).replace(" Counterparts","")),0);
        s_assert.assertEquals( concentrationRiskScreen.verifyTablePassifConcentrationValues(), vide );
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForPassifTable).replace(" Counterparts","")),0);
        concentrationRiskScreen.chooseGroupOrCounterpartyPassif("Group");
        s_assert.assertEquals( concentrationRiskScreen.verifyTablePassifConcentrationValues(), vide );
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForPassifTable).replace(" Counterparts","")),0);
        /* Charte des secteur */
        s_assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyIndustriesDistributionChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!A28:B30"));
        s_assert.assertEquals(utility.ModifyDataComingFromChartForFilterComparison(),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!B7:D7"));
        s_assert.assertEquals(utility.ValuesFromChart, utility.sortData(concentrationRiskScreen.VerifyIndustriesDistributionChartlegend()));
        /* Rate Weight Chart */
        s_assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyRateWeightChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!C28:D30"));
        Thread.sleep(1000);
        concentrationRiskScreen.chooseAssetOrLiabilityFromsectorChart("Liability");
        Thread.sleep(2000);
        /* Charte des secteur */
        s_assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyIndustriesDistributionChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!C28:D30"));
        s_assert.assertEquals(utility.ModifyDataComingFromChartForFilterComparison(),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!B7:D7"));
        s_assert.assertEquals(utility.ValuesFromChart, utility.sortData(concentrationRiskScreen.VerifyIndustriesDistributionChartlegend()));
        /* Rate Weight Chart */
        s_assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyRateWeightChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!C33:D33"));
        s_assert.assertAll();


    }

    @Test(priority = 4)
    @Description("Fourth Scenario Concentration Risk")
    @Severity(SeverityLevel.CRITICAL)
    public void FourthScenario () throws InterruptedException, GeneralSecurityException, IOException {
        concentrationRiskScreen = new ConcentrationRiskScreen();
        utility = new Utility();
        SoftAssert s_assert = new SoftAssert();

        Thread.sleep(2000);
        concentrationRiskScreen.enteranalysisdate(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F47").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.enterreferencedate(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F48").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.chooseInstrument(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F51").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.chooseSector(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F50:H50").get(0).get(0)),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F50:H50").get(0).get(1)),
                String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F50:H50").get(0).get(2)));
        Thread.sleep(2000);
        concentrationRiskScreen.choosePortfolio(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F49").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.chooseEmetteur(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F52").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.clickSearchButton();
        Thread.sleep(5000);

        /* Concentration Par Action */
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ActionConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F54").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ActionConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!H54").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.ActionConcentrationVariationValue),"#ffc102");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationActionConcentration)).contains("variation-stable"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineActionConcentration));
        /* Concentration Par Action */
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ObligationConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F55").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ObligationConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!H55").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.ObligationConcentrationVariationValue),"#ffc102");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationObligationConcentration)).contains("variation-stable"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineObligationConcentration));
        /* Concentration Marché Monitaire */
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.MonitaireConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F56").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.MonitaireConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!H56").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.MonitaireConcentrationVariationValue),"#ffc102");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationMonitaireConcentration)).contains("variation-stable"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineMonitaireConcentration));
        /* Concentration Des Depôts */
        Assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.DepotsConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F57").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.DepotsConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!H57").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.DepotsConcentrationVariationValue),"#ffc102");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationDepotsConcentration)).contains("variation-stable"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineDepotsConcentration));
        /*HHI Index*/
        s_assert.assertEquals(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F58").get(0).get(0)),concentrationRiskScreen.verify_HHI_Index());
        /*Concentration on Assets Contrepartie*/
        s_assert.assertEquals(utility.sortData(concentrationRiskScreen.verifyTableActifConcentrationValues()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!E60:H64"));
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForActifTable).replace(" Counterparts","")), dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!E60:H64").size());
        concentrationRiskScreen.chooseGroupOrCounterpartyActif("Group");
        System.out.println(concentrationRiskScreen.verifyTableActifConcentrationValues());
        List<String> vide = new ArrayList<>();
        s_assert.assertEquals( concentrationRiskScreen.verifyTableActifConcentrationValues(), vide );
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForActifTable).replace(" Counterparts","")),0);
        s_assert.assertEquals( utility.sortData(concentrationRiskScreen.verifyTablePassifConcentrationValues()), utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!E68:H72") );
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForPassifTable).replace(" Counterparts","")), dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!E68:H72").size());
        concentrationRiskScreen.chooseGroupOrCounterpartyPassif("Group");
        s_assert.assertEquals( concentrationRiskScreen.verifyTablePassifConcentrationValues(), vide );
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForPassifTable).replace(" Counterparts","")),0);
        /* Charte des secteur */
        s_assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyIndustriesDistributionChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!E77:F77"));
         /* Rate Weight Chart */
        s_assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyRateWeightChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!E80:F80"));
        Thread.sleep(1000);
        concentrationRiskScreen.chooseAssetOrLiabilityFromsectorChart("Liability");
        Thread.sleep(2000);
        /* Charte des secteur */
        s_assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyIndustriesDistributionChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!G77:H77"));
         /* Rate Weight Chart */
        Assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyRateWeightChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!G80:H80"));
        s_assert.assertAll();


    }

    @Test(priority = 2)
    @Description("Second Scenario Concentration Risk")
    @Severity(SeverityLevel.CRITICAL)
    public void SecondScenario () throws InterruptedException, GeneralSecurityException, IOException {
        concentrationRiskScreen = new ConcentrationRiskScreen();
        utility = new Utility();
        SoftAssert s_assert = new SoftAssert();

        Thread.sleep(2000);
        concentrationRiskScreen.enteranalysisdate(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F4").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.enterreferencedate(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F5").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.choosePortfolio(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F6").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.clickSearchButton();
        Thread.sleep(5000);

        /* Concentration Par Action */
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ActionConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F11").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ActionConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!H11").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.ActionConcentrationVariationValue),"#e74c3c");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationActionConcentration)).contains("variation-down"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineActionConcentration));
        /* Concentration Par Action */
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ObligationConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F12").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ObligationConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!H12").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.ObligationConcentrationVariationValue),"#e74c3c");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationObligationConcentration)).contains("variation-down"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineObligationConcentration));
        /* Concentration Marché Monitaire */
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.MonitaireConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F13").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.MonitaireConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!H13").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.MonitaireConcentrationVariationValue),"#2ecc71");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationMonitaireConcentration)).contains("variation-up"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineMonitaireConcentration));
        /* Concentration Des Depôts */
        Assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.DepotsConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F14").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.DepotsConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!H14").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.DepotsConcentrationVariationValue),"#ffc102");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationDepotsConcentration)).contains("variation-stable"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineDepotsConcentration));
        /*HHI Index*/
        s_assert.assertEquals(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!F15").get(0).get(0)),concentrationRiskScreen.verify_HHI_Index());
        /*Concentration on Assets Contrepartie*/
        s_assert.assertEquals(utility.sortData(concentrationRiskScreen.verifyTableActifConcentrationValues()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!E17:H21"));
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForActifTable).replace(" Counterparts","")), dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!A17:D19").size());
        concentrationRiskScreen.chooseGroupOrCounterpartyActif("Group");
        List<String> vide = new ArrayList<>();
        s_assert.assertEquals( concentrationRiskScreen.verifyTableActifConcentrationValues(), vide );
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForActifTable).replace(" Counterparts","")),0);
        s_assert.assertEquals( concentrationRiskScreen.verifyTablePassifConcentrationValues(), utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!E25:H29") );
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForPassifTable).replace(" Counterparts","")),0);
        concentrationRiskScreen.chooseGroupOrCounterpartyPassif("Group");
        s_assert.assertEquals( concentrationRiskScreen.verifyTablePassifConcentrationValues(), vide );
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForPassifTable).replace(" Counterparts","")),0);
        /* Charte des secteur */
        s_assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyIndustriesDistributionChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!E35:F40"));
        s_assert.assertEquals(utility.ValuesFromChart, utility.sortData(concentrationRiskScreen.VerifyIndustriesDistributionChartlegend()));
        /* Rate Weight Chart */
        s_assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyRateWeightChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!E43:F44"));
        Thread.sleep(1000);
        concentrationRiskScreen.chooseAssetOrLiabilityFromsectorChart("Liability");
        Thread.sleep(2000);
        /* Charte des secteur */
        s_assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyIndustriesDistributionChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!G35:H39"));
        //s_assert.assertEquals(utility.ModifyDataComingFromChartForFilterComparison(),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!B7:D7"));
        s_assert.assertEquals(utility.ValuesFromChart, utility.sortData(concentrationRiskScreen.VerifyIndustriesDistributionChartlegend()));
        /* Rate Weight Chart */
        s_assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyRateWeightChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!G43:H433"));
        s_assert.assertAll();


    }

    @Test(priority = 3)
    @Description("Third Scenario Concentration Risk")
    @Severity(SeverityLevel.CRITICAL)
    public void ThirdScenario () throws InterruptedException, GeneralSecurityException, IOException {
        concentrationRiskScreen = new ConcentrationRiskScreen();
        utility = new Utility();
        SoftAssert s_assert = new SoftAssert();

        Thread.sleep(2000);
        concentrationRiskScreen.enteranalysisdate(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B47").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.enterreferencedate(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B48").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.choosePortfolio(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B49:D49").get(0).get(0)),
                String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B49:D49").get(0).get(1)),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B49:D49").get(0).get(2)));
        Thread.sleep(2000);
        concentrationRiskScreen.chooseEmetteur(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B52").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.chooseInstrument(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B51").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.chooseSector(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B50").get(0).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.clickSearchButton();
        Thread.sleep(5000);

        /* Concentration Par Action */
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ActionConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B54").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ActionConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!D54").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.ActionConcentrationVariationValue),"#2ecc71");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationActionConcentration)).contains("variation-up"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineActionConcentration));
        /* Concentration Par Action */
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ObligationConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B55").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ObligationConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!D55").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.ObligationConcentrationVariationValue),"#2ecc71");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationObligationConcentration)).contains("variation-up"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineObligationConcentration));
        /* Concentration Marché Monitaire */
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.MonitaireConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B56").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.MonitaireConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!D56").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.MonitaireConcentrationVariationValue),"#e74c3c");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationMonitaireConcentration)).contains("variation-down"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineMonitaireConcentration));
        /* Concentration Des Depôts */
        Assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.DepotsConcentrationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B57").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.DepotsConcentrationVariationValue),String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!D57").get(0).get(0)));
        s_assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.DepotsConcentrationVariationValue),"#ffc102");
        s_assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationDepotsConcentration)).contains("variation-stable"));
        s_assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineDepotsConcentration));
        /*HHI Index*/
        s_assert.assertEquals(String.valueOf(dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!B58").get(0).get(0)),concentrationRiskScreen.verify_HHI_Index());
        /*Concentration on Assets Contrepartie*/
        s_assert.assertEquals(utility.sortData(concentrationRiskScreen.verifyTableActifConcentrationValues()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!A60:D64"));
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForActifTable).replace(" Counterparts","")), dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!A60:D64").size());
        concentrationRiskScreen.chooseGroupOrCounterpartyActif("Group");
        System.out.println(concentrationRiskScreen.verifyTableActifConcentrationValues());
        List<String> vide = new ArrayList<>();
        s_assert.assertEquals( concentrationRiskScreen.verifyTableActifConcentrationValues(), vide );
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForActifTable).replace(" Counterparts","")),0);
        s_assert.assertEquals( concentrationRiskScreen.verifyTablePassifConcentrationValues(), utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!A68:D72") );
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForPassifTable).replace(" Counterparts","")),dataFromgoogle.DataFromGoogleSheet("Concentration Risk Scenarions!A68:D72").size());
        concentrationRiskScreen.chooseGroupOrCounterpartyPassif("Group");
        s_assert.assertEquals( concentrationRiskScreen.verifyTablePassifConcentrationValues(), vide );
        s_assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForPassifTable).replace(" Counterparts","")),0);
        /* Charte des secteur */
        s_assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyIndustriesDistributionChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!A77:B82"));
         /* Rate Weight Chart */
        s_assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyRateWeightChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!A85:B86"));
        Thread.sleep(1000);
        concentrationRiskScreen.chooseAssetOrLiabilityFromsectorChart("Liability");
        Thread.sleep(2000);
        /* Charte des secteur */
        s_assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyIndustriesDistributionChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!C77:D81"));
          /* Rate Weight Chart */
        s_assert.assertEquals(utility.ModifyDataComingFromChart(concentrationRiskScreen.VerifyRateWeightChartElements()),utility.SortDataComesFromGoogleSheet("Concentration Risk Scenarions!C85:D85"));
        s_assert.assertAll();


    }




    @AfterMethod()
    public void clean() {

        cleanup();
    }


}
