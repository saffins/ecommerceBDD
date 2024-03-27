/**
 *
 */
package com.ecommerce.WebApp.StepDefinationFiles;

import com.ecommerce.WebApp.Pages.MyAccountLogin;
import com.ecommerce.WebApp.Factory.WebDriverFactory;
import com.ecommerce.WebApp.Pages.HomePage;
import com.ecommerce.WebApp.Pages.SignInPage;
import com.ecommerce.WebApp.Pages.UserHomePage;
import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


/**
 * @author Vrushali
 *
 */
public class LoginPageStepDefination {
    public Logger logger = Logger.getLogger(HomePageStepDefination.class.getName());
    private HomePage objHomePage = new HomePage(WebDriverFactory.getDriver());
    private SignInPage objSignInPage;
    private MyAccountLogin myAccountLogin;
    private UserHomePage objUserHomePage;

    @When("clicked on my account link")
    public void click_my_acc_link() {
        myAccountLogin = objHomePage.clickMyAcc();
    }



    @Then("I login with credentials , username {string} and password {string} expecting message {string}")
    public void login_with_creds(String username, String pass, String expectedMsg) {
        String actual = myAccountLogin.signInWithCredentials(username, pass, expectedMsg);
        Assert.assertEquals(expectedMsg, actual);
    }

    @Then("user logs out of the application")
    public void logout() {
        objHomePage.logout();
    }

    @Then("error message gets displayed")
    public void error_message_gets_displayed() {
        String actual = objSignInPage.getTheErrorMessageOnInvalidCredetials();
        String expected = "Warning";
        Assert.assertTrue(actual.contains(expected));
        logger.info("User cannot login to the application with invalid credentials");
    }


}
