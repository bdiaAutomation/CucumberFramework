package com.bdia.Stepdefs;

import com.bdia.Objects.Customer;
import com.bdia.Pages.SelectCountryPage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class CouponsStepDef {
    @DataTableType
    public Customer customer(Map<String, String> entry) {
        return new Customer(entry.get("username"), entry.get("password"));
    }

    @Then("I see the discount reduction in the cart")
    public void iSeeTheDiscounReductionInTheCart() {
    }

    @When("I add a discount coupon")
    public void iAddADiscountCoupon() {

    }

    @Given("I'm on coupons list page")
    public void iMOnCouponsListPage(List<Customer> customer) {
        new SelectCountryPage().validateCountry();
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() {
    }
}
