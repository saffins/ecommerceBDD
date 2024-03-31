/**
 * 
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserDriver;
import static utilities.UtilMethods.*;

/**
 * This is the Page class for Home page of the application
 * this class has two parts 
 * first part contains all the By locators of the Home page WebElements
 * and second part contains all the action methods on page 

 *
 */
public class HomePage extends BrowserDriver {


	private static By logo=By.cssSelector("img[class='TRRBg _R']");
			
	private static By signInLink=By.cssSelector("a[class='rmyCe _G B- z _S c Wc wSSLS w jWkoZ sOtnj']");
		
	private static By signInFrame=By.cssSelector("iframe[class='bFOrV _R B- o']");

	private static By myAccLink = By.xpath("(//div[@class='info']//*[contains(text(),'My account')])[2]");

	private static By logoutBtn = By.xpath("(//div[@class='info']//*[contains(text(),'Logout')])");

	private static By registerBtn = By.xpath("//a[contains(text(),'Register')]");

	private static By searchProductInput = By.name("search");

	private static By searchBtn = By.xpath("//*[@class='search-button']/button");

	private static By searchedItemHyperlink = By.xpath("//*[@data-view_id='grid']//*[@alt='HTC Touch HD']");




	public void searchProduct(String productName){
		waitForElementToBeClickable(searchProductInput);
		getElement(searchProductInput).sendKeys(productName);
		getElement(searchBtn).click();
 	}

	public void clickSearchedProduct(){
		waitForElementToBeClickable(searchedItemHyperlink);
		getElement(searchedItemHyperlink).click();
	}

	public static WebElement getRegisterButton() {
		waitForElementToBeClickable(registerBtn);
		return getElement(registerBtn);
	}
	public WebElement getSignInLink() {
		waitForElementToBeClickable(signInLink);
		return getElement(signInLink);
	}


	public static WebElement getMyAccLink(){
		waitForElementToBeClickable(myAccLink);
		return getElement(myAccLink);
	}
	public WebElement getLogo() {
		waitForElementToBePresent(logo);
		return getElement(logo);
	}
	

	public WebElement getSignInFrame() {
		//waitForFrame(signInFrame);
		return getElement(signInFrame);
	}
	
	public boolean isLogoDisplayed()
	{
		return getLogo().isDisplayed();
	}

	public boolean isSignInDisplayed()
	{
		return getSignInLink().isDisplayed();
	}
	



	public static void clickMyAcc(){
		getMyAccLink().click();

 	}

	public static void logout(){
		hoverOnElement(myAccLink);
		getElement(logoutBtn).click();
	}

	public static void registerUser(){
		getRegisterButton().click();;
	}



	
	
	
}
