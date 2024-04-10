package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.AbstractPageObject;
import utilities.BaseFile;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class LoginScreen extends AbstractPageObject {

    public static final String LOGIN_ID = "//*[@id=\"float-input\"]" ;
    public static final String PASSWORD_ID = "/html/body/app-root/app-auth/div/div/div[1]/span[2]/input" ;
    public static final String LOGIN_BUTTON_ID = "/html/body/app-root/app-auth/div/div/div[1]/button/span" ;
    public static final String ERROR_ALERT = "/html/body/app-root/app-auth/p-toast/div/p-toastitem/div/div" ;
    public static final String ERROR_MESSAGE_WHENUSERNAMEISREQUIRED = "//*[@id=\"username2-help\"]";
    //public static final String ERROR_MESSAGE_WHENPASSWORDISREQUIRED = "/html/body/app-root/app-auth/div/div/div[1]/div[1]/a";
    public static final String LOGIN_PHOTO = "/html/body/app-root/app-auth/div/div/div[1]/a/img";
    public static final String CONTACTSUPPORT_MESSAGE = "/html/body/app-root/app-auth/div/div/div[1]/p";

    public static final String LOGOUT_MENU = "//div[@class='layout-topbar-right']/ul/li[@class='topbar-item user-profile active-topmenuitem fadeInDown']/a[@class='user-item']/span";
    @FindBy(how = How.XPATH , using = LOGIN_ID)
    WebElement loginFeild ;

    @FindBy(how = How.XPATH , using = PASSWORD_ID)
    WebElement passwordFeild;

    @FindBy(how = How.XPATH , using = LOGIN_BUTTON_ID)
    WebElement LoginBtn;

    @FindBy(how = How.XPATH , using = ERROR_ALERT)
    WebElement ErrorAlert;

    @FindBy(how = How.ID , using = ERROR_MESSAGE_WHENUSERNAMEISREQUIRED)
    WebElement ErrorMessageWhenUsernameIsRequired;

   /* @FindBy(how = How.XPATH , using = ERROR_MESSAGE_WHENPASSWORDISREQUIRED)
    WebElement ErrorMessageWhenPasswordIsRequired;*/

    @FindBy(how = How.XPATH , using = LOGIN_PHOTO)
    WebElement LoginPhoto;

    @FindBy(how = How.XPATH , using = CONTACTSUPPORT_MESSAGE)
    WebElement ContactSupportMessage;

    @FindBy(how = How.XPATH , using = LOGOUT_MENU)
    WebElement logoutMenu;

    public LoginScreen() {

    }

    //used methods
    @Step("Enter Email {email}")
    public void enterEmailFeild(String email) {
       // loginFeild.isDisplayed();
        loginFeild.sendKeys(email);
    }

    @Step("Enter Password {password}")
    public void enterpasswordFeild(String password) {

       // passwordFeild.isDisplayed();
        passwordFeild.sendKeys(password);
    }

    @Step("Click on Login Button")
    public void clickLoginBtn() {

      //  LoginBtn.isDisplayed();
        LoginBtn.click();
    }

    @Step("Check if the Alert Is Displayed")
    public String checkAlertIsDisplayed(){
         return ErrorAlert.getText();
    }

    @Step("Check if  the Errror Message Is Displayed")
    public String checkErrrorMessageIsDisplayed(){

        return ErrorMessageWhenUsernameIsRequired.getText();
    }

   /*  public String checkForgetPasswordMessageIsDisplayed(){

        return ErrorMessageWhenPasswordIsRequired.getText();
    } */

    public boolean checkLoginPhotoIsDisplayed(){

        return LoginPhoto.isDisplayed();
    }

    public boolean checkContactSupportMessageIsDisplayed(){

        return ContactSupportMessage.isDisplayed();
    }

    public void loginForTest() {
        enterEmailFeild("best");
        enterpasswordFeild("best");
        clickLoginBtn();
    }

    public void logout(String option) throws InterruptedException {
        Thread.sleep(5000);
        WebElement button = getDriver().findElement(By.xpath("//app-main//div[@class='layout-topbar-right']/ul/li[@class='topbar-item user-profile active-topmenuitem fadeInDown']/a[@class='user-item']/span"));
        //logoutMenu.click();
        button.click();
        List<WebElement> options = getDriver().findElements(By.xpath("//div[@class='layout-topbar-right']/ul/li[@class='topbar-item user-profile active-topmenuitem fadeInDown']/ul/li/a"));
        for (WebElement op : options) {
            WebElement categSpan = op.findElement(By.tagName("span"));
            String categText = categSpan.getText().trim();
            if (option.equalsIgnoreCase(categText)) {
                op.click();
                Thread.sleep(5000);
            }
        }


    }





}
