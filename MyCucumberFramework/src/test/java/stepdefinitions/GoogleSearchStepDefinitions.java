package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import utilities.Driver;

import java.security.Key;

public class GoogleSearchStepDefinitions
{
    GooglePage googlePage = new GooglePage();

    @Given("user is in the google page")
    public void user_is_in_the_google_page() {
        Driver.getDriver().get("https://www.google.com");
    }

    @Given("user searches iphone")
    public void user_searches_iphone() {//testcase1
        googlePage.searchBox.sendKeys("iphone");//step
        googlePage.searchBox.submit();
    }

    @Then("verify result has iphone")
    public void verify_result_has_iphone() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("iphone"));
    }



    @Given("user searches nokia")
    public void user_searches_nokia() {
        googlePage.searchBox.sendKeys("nokia"+Keys.ENTER);
    }

    @Then("verify result has nokia")
    public void verify_result_has_nokia() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("nokia"));
    }





    @Given("user searches {string}")      //@datatable1 tag ına ait
    public void user_searches(String string)
    {
       googlePage.searchBox.sendKeys(string+ Keys.ENTER);
       //googlePage.searchBox.submit();// + Keys.ENTER work as this line
    }

    @Then("verify result has {string}")   //@datatable1 tag ine ait
    public void verify_result_has(String string)
    {
        String title=Driver.getDriver().getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains(string));
    }

}