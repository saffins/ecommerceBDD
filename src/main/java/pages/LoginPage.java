package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserDriver;
import utilities.ExcelUtils;

import java.util.List;

import static utilities.UtilMethods.*;

public class LoginPage extends BrowserDriver {

    private static By header=By.xpath("//*[@id='overlayHeader']/div");
    private static By continueWithGoogle=By.cssSelector("button[id='googleBtn']");
    private static By continueWithFacebook=By.cssSelector("button[id='facebookBtn']");
    private static By continueWithEmail=By.cssSelector("button[class='ui_button w100p regEmailContinue newRegFormButtonStyles roundedRegFormButton emailButtonMargin']>span[class='textContainer']");
    private static By EmailHeader=By.xpath("//div[@id='regSignIn']/div[2]/div");
    private static By emailAddress=By.cssSelector("input[id='regSignIn.email']");
    private static By errorMessageOnInvalideCredentials=By.xpath("//*[contains(@class,'alert-dismissible')]");
    private static By errorMessageOnBlankEmailAddress=By.cssSelector("div[class='body_text']");

    private static By email = By.name("email");
    private static By pass = By.name("password");
    private static By signInButton=By.xpath("//*[@value='Login']");

    private static By blankAreaMsg = By.xpath("//*[contains(text(),'%s')]");

    static ExcelUtils excelUtils = new ExcelUtils("src/main/resources/testData/credentials.xlsx");

    private static List<String> username;

    private static List<String> password;

    public WebElement getContinueWithEmail() {
        //waitForElementToBePresent(continueWithEmail);
        return getElement(continueWithEmail);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		WebElement element=(WebElement)js.executeScript("return document.querySelector(\"button[class='ui_button w100p regEmailContinue newRegFormButtonStyles roundedRegFormButton emailButtonMargin']>span[class='textContainer']\")");
//		return element;
    }

    public static WebElement getEmailAddress() {
        waitForElementToBePresent(email);
        return getElement(email);
    }

    public static WebElement getPassword() {
        waitForElementToBePresent(pass);
        return getElement(pass);
    }

    public static WebElement getSignInButton() {
        waitForElementToBePresent(signInButton);
        return getElement(signInButton);
    }

    public static WebElement getErrorMessageOnInvalideCredentials()
    {
        waitForElementToBePresent(errorMessageOnInvalideCredentials);
        return getElement(errorMessageOnInvalideCredentials);
    }

    public static WebElement getErrorMessageOnBlankEmailAddress()
    {
        waitForElementToBePresent(errorMessageOnBlankEmailAddress);
        return getElement(errorMessageOnBlankEmailAddress);
    }






    public static WebElement blankAreaMsg(String msg){
        By b = By.xpath(String.format("//*[contains(text(),'%s')]",msg));
        waitForElementToBeClickable(b);
        return getElement(b);
    }

    public static String signInWithCredentials(String type,String expectedMsg) {
        getCredentials(type);
        getEmailAddress().sendKeys(username.get(1));
        getPassword().sendKeys(password.get(3));
        username.clear();
        password.clear();
        getSignInButton().click();
        return blankAreaMsg(expectedMsg).getText();
    }

    public static void getCredentials(String type){
        if(type.equalsIgnoreCase("invalid")) {
            username = excelUtils.readExcelData("invalid", "username");
            password = excelUtils.readExcelData("invalid", "password");
        }else{
            username= excelUtils.readExcelData("valid", "username");
            password = excelUtils.readExcelData("valid", "password");
        }

    }








    public static String getTheErrorMessageOnInvalidCredetials() {

        return getErrorMessageOnInvalideCredentials().getText();
    }







    public static String getTheErrorMessageOnBlankEmailAddress() {
        return getErrorMessageOnBlankEmailAddress().getText();
    }



    public static String getTheErrorMessageOnBlankPassword() {
        return getErrorMessageOnBlankEmailAddress().getText();
    }

}
