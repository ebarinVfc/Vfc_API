package com.vf.step_defi;

import com.vf.pages.HomePage;
import com.vf.pages.PlanetPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class PlanetStepDefs {
    HomePage homePage = new HomePage();
    PlanetPage planetPage = new PlanetPage();
    @Given("the user is on homepage")
    public void the_user_is_on_homepage() {
        homePage.navigateToHomePage();
    }

    @When("the user hovers over the {string} dropdown menu")
    public void theUserHoversOverTheDropdownMenu(String menu) {
        homePage.hoverOverResponsibilityMenu();
    }

    @And("clicks on the {string} option")
    public void clicksOnTheOption(String option) {
        homePage.clickOnPlanetOption();
    }

    @Then("the user should be able to view the information")
    public void theUserShouldBeAbleToViewTheInformation() {
        planetPage.printHeaders();

    }
}