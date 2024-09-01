package com.stt.steps;

import com.stt.automation.WebDriverFactory;
import com.stt.pages.LoginPage;
import com.stt.pages.ProductsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginStep extends WebDriverFactory {
    LoginPage loginPage;
    ProductsPage productsPage;

    @Given("User on login screen")
    public void user_on_login_screen() {
        loginPage = new LoginPage(driver);
    }

    @When("User enter credentials and submit login form")
    public void user_enter_credentials_and_submit_login_form() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @When("User on products screen")
    public void user_on_products_screen() {
        productsPage = new ProductsPage(driver);
    }

    @Then("User verify products list")
    public void user_verify_products_list() throws InterruptedException {
        Assert.assertEquals(productsPage.getNumberOfProducts(), 6);
        Thread.sleep(5000);
    }

    @When("User enter credentials username {string} and password {string}")
    public void userEnterCredentialsUsernameAndPassword(String un, String pwd) {
        loginPage.login(un, pwd);
    }

    @When("User enter credentials")
    public void userEnterCredentials(DataTable dataTable) {
        List<String> rowData = dataTable.row(0);
        System.out.println(rowData);
        String userName = rowData.get(0);
        String password = rowData.get(1);

        loginPage.login(userName, password);
    }

    @When("User enter login credentials")
    public void userEnterLoginCredentials(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String un = null;
        String pwd = null;
        for(Map<String, String> dataMap : data){

            un= dataMap.get("username");
            pwd = dataMap.get("password");
        }

        loginPage.login(un, pwd);
    }

    @And("User Logout")
    public void userLogout() {
        productsPage.logout();
    }
}
