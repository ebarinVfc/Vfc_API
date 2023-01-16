package com.vf.pages;

import com.vf.utilities.ConfigurationReader;
import com.vf.utilities.Driver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "//a[.='Responsibility']")
    public WebElement responsibility;
    @FindBy(xpath = "//a[.='Planet']")
    public WebElement planet;

    public void navigateToHomePage(){
        Driver.get().get(ConfigurationReader.getProperty("url"));
    }
    public void hoverOverResponsibilityMenu(){
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(responsibility));

        Actions actions = new Actions(Driver.get());
        actions.moveToElement(responsibility).perform();
    }
    public void clickOnPlanetOption(){
        planet.click();
    }


}
