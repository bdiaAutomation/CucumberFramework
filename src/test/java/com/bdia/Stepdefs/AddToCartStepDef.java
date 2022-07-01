package com.bdia.Stepdefs;

import com.bdia.Objects.Product;
import com.bdia.Pages.OnboardingLoginPage;
import com.bdia.Pages.SelectCountryPage;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class AddToCartStepDef {
    @ParameterType(".*")
    public Product product(String name){
        return new Product(name);
    }
    @Given("I'm on store page")
    public void iMOnStorePage() {
        new SelectCountryPage().validateCountry();

    }

    @When("I add one {product} to cart")
    public void iAddOneProductToCart(Product product) {

        System.out.println("PRODUCT NAME  :  "  + product.getName());

    }

    @Then("I see one {product} in the cart")
    public void iSeeOneProductInTheCart(Product product) {
        System.out.println("PRODUCT NAME  :  "  + product.getName());

    }

}
