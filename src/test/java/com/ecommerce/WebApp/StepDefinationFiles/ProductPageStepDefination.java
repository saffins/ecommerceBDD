package com.ecommerce.WebApp.StepDefinationFiles;

import com.ecommerce.WebApp.Factory.WebDriverFactory;
import com.ecommerce.WebApp.Pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductPageStepDefination {

    private ProductPage productPage = new ProductPage(WebDriverFactory.getDriver());

    @When("user click on Add to Cart button")
    public void clickAddToCart(){
        productPage.clickAddToCart();
    }

    @Then("verify success msg on item added to cart")
    public void verifySuccessOnAdd(){
        String msg = productPage.getItemAddedToastMsg();
        Assert.assertTrue(msg.contains("Success: You have added"));
    }

    @Then("click view cart button")
    public void viewCart(){
        productPage.viewCart();
    }

    @When("I click remove item button")
    public void removeItem(){
        productPage.removeItem();
    }

    @Then("I see message as {string} on screen")
    public void verifyScreenMsg(String msg){
        String ms = productPage.blankAreaMsg(msg);
        Assert.assertTrue(ms.contains(msg));

    }
}
