package com.stt.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SeleniumActions {
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    public SeleniumActions(WebDriver driver) {
        this.driver = driver;
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void jsClick(WebElement element) {

        String click = "return arguments[0].click()";
        javascriptExecutor.executeScript(click, element);
    }


    public void typeValue(By by, String data) {
        driver.findElement(by).sendKeys(data);
    }

    public void typeValue(WebElement element, String data) {
        element.sendKeys(data);
    }

    public int getNumberOfElements(By by) {
        return driver.findElements(by).size();
    }

    public int getNumberOfElements(List<WebElement> elements) {
        return elements.size();
    }

    public String getTextMessage(WebElement element) {
        return element.getText();
    }

    public void getScreenshot(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        System.out.println(System.getProperty("user.dir"));
        File dest = new File(System.getProperty("user.dir")+"/screenshots/test.png");
        try {
            FileUtils.copyFile(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
