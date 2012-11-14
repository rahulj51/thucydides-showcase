package com.helene.app.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

/**
 * Created with IntelliJ IDEA.
 * User: rahuljai
 * Date: 11/11/12
 * Time: 10:17 PM
 * To change this template use File | Settings | File Templates.
 */
@DefaultUrl("http://www.imdb.com")
public class HomePage extends PageObject {

    @FindBy(id="navbar-query")
    private WebElement searchTerms;

    @FindBy(id="navbar-submit-button")
    private WebElement lookupButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enter_keywords(String keyword) {
        element(searchTerms).type(keyword);
    }

    public void lookup_terms() {
        element(lookupButton).click();
    }

    public List<String> getExactMatches() {
        WebElement definitionList = getDriver().findElement(By.xpath("//b[text()='Titles (Exact Matches)']//parent::p//following-sibling::table"));
        List<WebElement> results = definitionList.findElements(By.tagName("td"));
        return convert(results, toStrings());
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }

}
