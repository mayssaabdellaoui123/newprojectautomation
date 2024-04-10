package testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginScreen;
import pages.Menu;
import utilities.BaseFile;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Listeners({ TestListener.class })
@Epic("Functional tests")
@Feature("Menu Tests")
public class MenuTestCases extends BaseFile {


    Menu menu ;
    Loginstepcase loginstepcase = new Loginstepcase();
    LoginScreen loginScreen;

    public MenuTestCases() throws GeneralSecurityException, IOException {
    }

    @BeforeSuite()
    public void start() throws GeneralSecurityException, IOException {
        loadConfig();
        startApp();
        loginScreen = new LoginScreen();
        loginScreen.loginForTest();
    }

    @Test
    @Description("Concentration Risk Menu ")
    public void MenuTestCase1 () throws InterruptedException {

     menu = new Menu();
     menu.clickRiskManagementMenu();
     menu.clickConcentrationRiskSubMenu();

     Thread.sleep(1000);
     Assert.assertEquals(menu.getPageURL(),"http://staging.alm.vneuron.com/riskManagement/concentrationRisk");
       }



    @AfterSuite()
    public void clean(){
        cleanup();
    }
}
