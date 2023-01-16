package com.vf.pages;

import com.vf.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PlanetPage {
    public PlanetPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//h2[.='Planet']")
    public WebElement header;
    @FindBy(xpath = "//h3[@data-mh='teaser-heading']")
    public List<WebElement> headers;

    public void printHeaders() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(headers));

        for (WebElement ele : headers) {
            System.out.println("Header text: " + ele.getText());

        }
    }
}



