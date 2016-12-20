package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Alya on 12/20/2016.
 */
public class ReportsViewReport {
    private WebDriver driver;

    public ReportsViewReport(WebDriver driver) {

        this.driver = driver;
    }

    public static WebElement downloadAsPDFButton(WebDriver driver) {
        return driver.findElement(By.xpath("//button[text()='Download as PDF']"));
    }

    public static WebElement useAsTemplateButton(WebDriver driver) {
        return driver.findElement(By.xpath("//button[text()='Use as template']"));
    }
}