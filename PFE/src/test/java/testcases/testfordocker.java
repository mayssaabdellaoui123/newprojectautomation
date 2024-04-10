package testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Menu;
import pages.testfordockerscreen;
import utilities.BaseFile;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Listeners({ TestListener.class })
@Epic("testfordocker tests")
@Feature("testfordocker Tests")
public class testfordocker extends BaseFile {



  /*  @BeforeMethod()
    public void start() throws GeneralSecurityException, IOException {
        loadConfig();
        startApp();
    } */

    @Test
    @Description("Docker Test Case 1")
    public void dockerTestCase1 () throws InterruptedException {


        Thread.sleep(1000);
        Assert.assertEquals("https://www.google.com/","https://www.google.com/");
    }

    @Test
    @Description("Docker Test Case 2")
    public void dockerTestCase2 () throws InterruptedException {


        Thread.sleep(1000);
        Assert.assertEquals("https://www.google.com/","https://www.google.com/");
    }

    @Test
    @Description("Docker Test Case 3")
    public void dockerTestCase3 () throws InterruptedException {


        Thread.sleep(1000);
        Assert.assertEquals("https://www.google.com/","https://www.google.com/");
    }

    @Test
    @Description("Docker Test Case 4")
    public void dockerTestCase4 () throws InterruptedException {


        Thread.sleep(1000);
        Assert.assertEquals("https://www.google.com//","https://www.google.com/");
    }

    @Test
    @Description("Docker Test Case 5")
    public void dockerTestCase5 () throws InterruptedException {


        Thread.sleep(1000);
        Assert.assertEquals("https://www.googgle.com//","https://www.google.com/");
    }



  /*  @AfterSuite()
    public void clean(){
        cleanup();
    } */

}
