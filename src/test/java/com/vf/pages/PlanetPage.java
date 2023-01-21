package com.vf.pages;

import com.vf.utilities.Driver;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PlanetPage {
    public PlanetPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//h2[.='Planet']")
    public WebElement header;
    @FindBy(xpath = "//h3[@data-mh='teaser-heading']")
    public List<WebElement> headers;
    @FindBy(tagName = "a")
    public List<WebElement> links;

    public void printHeaders() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(headers));

        for (WebElement ele : headers) {
            System.out.println("Header text: " + ele.getText());

        }
    }

    public void brokenLinks() {
        List<String> linkUrls = new ArrayList<String>();
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            linkUrls.add(url);
        }
        List<String> subsetOfLinks = linkUrls.subList(0, 10);
        for (String url : subsetOfLinks) {
            Response response = given().when().get(url);
            if (response.getStatusCode() != 200) {
                System.out.println(url + " is a broken link");
            }
        }
    }
}




