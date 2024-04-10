package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class BaseFile {

    public static Properties props;

   public void loadConfig() {
   System.out.println("test");
        try {
          //  props = new Properties();
         //   FileInputStream ip = new FileInputStream(
       //             System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\config.properties");
         //    props.load(ip);

            props = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("configs/config.properties");
            props.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void startApp(){

       String browserName = props.getProperty("browser");
        System.out.println(browserName);

        new DriverManager().initDriver(browserName);

        DriverManager.getDriver().get(props.getProperty("BASE_URL"));

       /* WebDriver driver = new ChromeDriver();
        driver.get(props.getProperty("BASE_URL"));*/

    }


    public void cleanup(){
        DriverManager.quit();
    }


    public static WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}
