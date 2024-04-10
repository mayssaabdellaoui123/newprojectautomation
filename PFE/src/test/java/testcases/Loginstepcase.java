package testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginScreen;
import pages.Menu;
import testdata.DataFromGoogleSheet;
import utilities.BaseFile;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners({ TestListener.class })
@Epic("Functional tests")
@Feature("Login Tests")
public class Loginstepcase extends BaseFile {

    DataFromGoogleSheet dataFromgoogle = new DataFromGoogleSheet();
    List<List<Object>> data = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.Loginrange);

    LoginScreen loginScreen;
    Menu menu ;

    public Loginstepcase() throws GeneralSecurityException, IOException {
    }


    @BeforeMethod()
    public void start() throws GeneralSecurityException, IOException {
        loadConfig();
        startApp();
    }


    public void login(String login,String password) throws IOException, GeneralSecurityException {
        loginScreen = new LoginScreen();
        loginScreen.enterEmailFeild(login);
        loginScreen.enterpasswordFeild(password);
        loginScreen.clickLoginBtn();
    }





   @Test()
   @Description("Login sucessfully")
   public void LoginTestCase1 () throws IOException, GeneralSecurityException, InterruptedException {

       login(String.valueOf(data.get(0).get(0)),String.valueOf(data.get(0).get(1)));
       System.out.println(data.get(0).get(0) +" "+ data.get(0).get(1));
        getDriver().manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        String TextAlert = loginScreen.checkAlertIsDisplayed();
        Assert.assertEquals(TextAlert,"Success\n" +
                "You have logged in sucessfully");
        Thread.sleep(4000);
        Assert.assertEquals(loginScreen.getPageURL(),"http://auto.alm.vneuron.com/dashboard");
    }

    @Test()
    @Description("Invalid credentials when login ")
    public void LoginTestCase2 () throws IOException, GeneralSecurityException, InterruptedException {

        login(String.valueOf(data.get(1).get(0)),String.valueOf(data.get(1).get(1)));
        System.out.println(data.get(1).get(0) +" "+ data.get(1).get(1));
       String TextAlert = loginScreen.checkAlertIsDisplayed();
       Thread.sleep(1000);
       Assert.assertEquals(TextAlert,"Error\n" +
               "Invalid user credentials");
        Assert.assertEquals( loginScreen.getPageURL(), "http://auto.alm.vneuron.com/login" );

    }

    @Test()
    @Description("Invalid credentials when login ")
    public void LoginTestCase3 () throws IOException, GeneralSecurityException, InterruptedException {
        login(String.valueOf(data.get(2).get(0)),String.valueOf(data.get(2).get(1)));
        System.out.println(data.get(2).get(0) +" "+ data.get(2).get(1));
        Thread.sleep(1000);
        String TextAlert = loginScreen.checkAlertIsDisplayed();
        Assert.assertEquals(TextAlert,"Error\n" +
                "Invalid user credentials");
        Assert.assertEquals( loginScreen.getPageURL(), "http://auto.alm.vneuron.com/login" );

    }

     @Test()
     @Description("Required Active diractory when login  ")
    public void LoginTestCase4 () throws IOException, GeneralSecurityException, InterruptedException {
        login(String.valueOf(data.get(3).get(0)),String.valueOf(data.get(3).get(1)));
         System.out.println(data.get(3).get(0) +" "+ data.get(3).get(1));
        Thread.sleep(1000);
        /* a vérifier */
        String TextAlert = loginScreen.checkErrrorMessageIsDisplayed();
         Assert.assertEquals( loginScreen.getPageURL(), "http://auto.alm.vneuron.com/login" );
         Assert.assertEquals(TextAlert,"Active diractory is Required.");
        //Assert.assertTrue(loginScreen.checkErrrorMessageIsDisplayed());

    }

    @Test()
    @Description("Required Password when login ")
    public void LoginTestCase5 () throws IOException, GeneralSecurityException {
        System.out.println(data);
        login("best","");
        System.out.println(data.get(4).get(0) +" "+ data.get(4).get(1));
        getDriver().manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        String TextAlert = loginScreen.checkErrrorMessageIsDisplayed();
        Assert.assertEquals( loginScreen.getPageURL(), "http://auto.alm.vneuron.com/login" );
        Assert.assertEquals(TextAlert,"Password is Required.");

    }


    @AfterMethod()
    public void clean(){
        cleanup();
    }

}
