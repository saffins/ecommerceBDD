package com.ecommerce.WebApp.StepDefinationFiles;

import com.ecommerce.WebApp.Factory.WebDriverFactory;
import com.ecommerce.WebApp.Pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class RegisterPageStepDefination {

    public Logger logger = Logger.getLogger(RegisterPageStepDefination.class.getName());

    private RegisterPage registerPage = new RegisterPage(WebDriverFactory.getDriver());

    @And("I pass registration information inputs by passing firstname as {string} last name as {string} email as {string} telephone as {string} password as {string}")
    public void registerUser(String fname, String lname, String email, String telephone, String pass) {
        registerPage.registerUser(fname,lname,email,telephone,pass);
    }

    @Then("I click agree policy checkbox")
    public void agreePolicy(){
        registerPage.agreePolicyCheck();
    }

    @When("I click on continue button to register")
    public void registerBtn(){
        registerPage.clickContinue();
        logger.info("clicked continue button on registration page");
    }

    @Then("I see warning message on registration screen")
    public void warningMsgVerify(){
        String msg = registerPage.getWarning();
        Assert.assertTrue(msg.contains("Warning: E-Mail Address is already registered!"));
        logger.info("warning msg displayed as expecting");

    }

    @Then("I see message {string} on the screen")
    public void verifyMsgOnScreen(String msg){
        String m = registerPage.blankAreaMsg(msg);
        Assert.assertTrue(m.contains(msg));
    }


}
