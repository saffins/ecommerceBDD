package com.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import static pages.HomePage.*;

public class HomePageStepDefination {







    @Then("user click on Register link")
    public void clickRegister(){
        registerUser();
    }

    @Then("user search for product {string}")
    public void searchProduct(String product){
        searchProduct(product);
    }

    @When("I click on searched Product hyperlink")
    public void clickSearchedProduct(){clickSearchedProduct();
    }




//    @Then("Sign In Link Is displayed and Clickable")
//    public void sign_in_link_is_displayed_and_clickable() {
//        Assert.assertTrue(isSignInDisplayed());
//     }



}
