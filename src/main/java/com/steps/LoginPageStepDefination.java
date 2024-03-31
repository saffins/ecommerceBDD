/**
 *
 */
package com.steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 import org.junit.Assert;
import static pages.LoginPage.*;
import static pages.HomePage.*;

public class LoginPageStepDefination {


    @When("clicked on my account link")
    public void click_my_acc_link() {
        clickMyAcc();
    }



    @Then("I login with {string} credentials and expecting message {string}")
    public void login_with_creds(String type, String expectedMsg) {
        String actual=signInWithCredentials(type, expectedMsg);
        Assert.assertEquals(expectedMsg, actual);
    }

    @Then("user logs out of the application")
    public void logoutApp() {
       logout();
    }

    @Then("error message gets displayed")
    public void error_message_gets_displayed() {
        String actual = getTheErrorMessageOnInvalidCredetials();
        String expected = "Warning";
        Assert.assertTrue(actual.contains(expected));
    }


}
