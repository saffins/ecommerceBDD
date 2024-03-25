/**
 * 
 */
package com.ecommerce.WebApp.StepDefinationFiles;

import org.apache.log4j.Logger;
import org.junit.Assert;


import com.ecommerce.WebApp.Factory.WebDriverFactory;
import com.ecommerce.WebApp.Pages.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**

 *
 */
public class HomePageStepDefination {
	public Logger logger=Logger.getLogger( HomePageStepDefination.class.getName());
	private HomePage objHomePage=new HomePage(WebDriverFactory.getDriver());
	
	@When("User is on the Home Page")
	public void user_is_on_the_home_page() {
	  System.out.println("User is on home pagge");
	}

	@Then("He gets The Home Page Title as {string}")
	public void he_gets_the_home_page_title_as(String pageTitle) {
	  String actualTitle=objHomePage.getPageTitle();
	  Assert.assertEquals(actualTitle, pageTitle);
	  logger.info("TripAdvisor Home Page opened");	
	  //Assert.assertTrue(false);
	}


	@Then("user click on Register link")
	public void clickRegister(){
		objHomePage.registerButton();
	}

    @Then("user search for product {string}")
    public void searchProduct(String product){
		objHomePage.searchProduct(product);
    }

	@When("I click on searched Product hyperlink")
	public void clickSearchedProduct(){
		objHomePage.clickSearchedProduct();
	}




	@Then("Sign In Link Is displayed and Clickable")
	public void sign_in_link_is_displayed_and_clickable() {
		Assert.assertTrue(objHomePage.isSignInDisplayed());
		 logger.info("Sign In Link Is displayed and Clickable");	
	}




}
