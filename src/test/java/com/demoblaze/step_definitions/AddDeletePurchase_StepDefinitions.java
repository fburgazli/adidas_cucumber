package com.demoblaze.step_definitions;

import com.demoblaze.pages.Homepage;
import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class AddDeletePurchase_StepDefinitions {

    Homepage homepage = new Homepage();
    String totalPrice;
    String purchaseDetailsMessage;

    @Given("Customer is on home page")
    public void customer_is_on_home_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("Customer navigates to Laptop category")
    public void customer_navigates_to_laptop_category() {
        BrowserUtils.sleep(1);

        homepage.laptopsCategory.click();
    }
    @When("Customer clicks on Sony vaio i5")
    public void customer_clicks_on_sony_vaio_i5() {
        BrowserUtils.sleep(1);
        homepage.sonyVaioI5.click();

    }
    @Then("Customer clicks on Add to cart and accepts pop up confirmation")
    public void customer_clicks_on_add_to_cart_and_accepts_pop_up_confirmation() {
        BrowserUtils.sleep(1);
        homepage.addToCartButton.click();
        BrowserUtils.sleep(1);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @When("Customer clicks on Dell i7 8gb")
    public void customer_clicks_on_dell_i7_8gb() {
        BrowserUtils.sleep(1);
        homepage.dellI78gb.click();
    }

    @Then("Customer navigates to Cart")
    public void customer_navigates_to_cart() {
        BrowserUtils.sleep(2);
        homepage.goToCart.click();

    }
    @And("Customer deletes Dell i7 8gb")
    public void customer_deletes_dell_i7_8gb() {
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//td[.='Dell i7 8gb']/following-sibling::td/a")).click();
    }
    @When("Customer clicks on Place order")
    public void customer_clicks_on_place_order() {
        BrowserUtils.sleep(1);
        homepage.placeOrderButton.click();
        totalPrice = homepage.totalPrice.getText();
    }
    @When("Customer fills in all web forms")
    public void customer_fills_in_all_web_forms() {
        BrowserUtils.sleep(3);
        Faker faker = new Faker();
        Driver.getDriver().findElement(By.id("name")).sendKeys(faker.name().fullName());
        Driver.getDriver().findElement(By.id("country")).sendKeys(faker.address().country());
        Driver.getDriver().findElement(By.id("city")).sendKeys(faker.address().city());
        Driver.getDriver().findElement(By.id("card")).sendKeys(faker.finance().creditCard());
        Driver.getDriver().findElement(By.id("month")).sendKeys(faker.number().digits(1));
        Driver.getDriver().findElement(By.id("year")).sendKeys("2020");
    }
    @When("Customer clicks on Purchase")
    public void customer_clicks_on_purchase() {
        BrowserUtils.sleep(2);
        homepage.purchaseButton.click();
        purchaseDetailsMessage = Driver.getDriver().findElement(By.xpath("//h2[.='Thank you for your purchase!']/following-sibling::p")).getText();


    }
    @Then("Verify the purchase amount equals expected total price.")
    public void verify_the_purchase_amount_equals_expected_total_price() {
        BrowserUtils.sleep(3);
        String[] confirmationArray = purchaseDetailsMessage.split("\n");
        System.out.println(totalPrice);
        System.out.println(purchaseDetailsMessage);
        System.out.println(Arrays.toString(confirmationArray));
        String amount = confirmationArray[1];
        Assert.assertTrue(amount.contains(totalPrice));
    }



}
