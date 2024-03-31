package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UtilMethods extends BrowserDriver{



    public static WebElement getElement(By locator)throws NoSuchElementException {
        WebElement element=null;
        try
        {
            return driver.findElement(locator) ;
        }catch (NoSuchElementException e)
        {
             e.printStackTrace();
            throw e;
        }

    }


    public static void waitForElementToBePresent(By locator)throws TimeoutException {
        try
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (TimeoutException e)
        {
             e.printStackTrace();
        }
    }


    public static void waitForPageTitle(String title) {
        wait.until(ExpectedConditions.titleContains(title));

    }

    public static void waitForFrame(By locator) {
        try
        {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
        }catch (Exception e)
        {
             e.printStackTrace();
        }
    }

    public static void waitForElementToBeClickable(By locator) {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch (Exception e)
        {
             e.printStackTrace();
        }
    }

    public static void hoverOnElement(By locator){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(locator)).build().perform();

        }catch (Exception e){

        }
    }
}
