package org.example;

import io.appium.java_client.ios.IOSDriver;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.springframework.util.Assert;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;

public class AppiumClickTest extends BaseIOSTest{
    public static void main(String[] args) throws IOException, JSONException, InterruptedException {
        IOSDriver driver = BaseIOSTest.desiredCapabilities();
        driver.findElementByXPath("//XCUIElementTypeOther[@name=\"match-2c92808388dfcd9e0188dfd3a8300000\"]").click();
        Thread.sleep(300);
        String heatMVP = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Jimmy Butler\"]").getText();
        Assert.isTrue(heatMVP.equals("Jimmy Butler"), "Jimmy Butler is not MVP");
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Back\"]").click();
        Thread.sleep(300);
        driver.findElementByXPath("//XCUIElementTypeOther[@name=\"bottombar-barchart2\"]/XCUIElementTypeOther/XCUIElementTypeOther").click();
        Thread.sleep(300);
        String standingsTitle = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Standings\"]").getText();
        Assert.isTrue(standingsTitle.equals("Standings"), "Title is not Standings");
        Thread.sleep(300);
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Back\"]").click();

    }

}









//        driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Matches\"])[2]").click();
//        driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Players\"])[2]").click();

//String createdMatch = driver.findElementByXPath("(//XCUIElementTypeOther[@name="Los Angeles Lakers:0 - Boston Celtics:0"])[2]").getText();
//        HashMap<String, Object> scrollObject = new HashMap<>();
//        scrollObject.put("direction", "up");
//
//        driver.executeScript("mobile:scroll", scrollObject);


//        WebElement upperPickerWheel = driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Select Team 1 Horizontal scroll bar, 1 page Chicago Bulls Boston Celtics Los Angeles Lakers Select Team 1 Horizontal scroll bar, 1 page Golden State Warriors Miami Heat Chicago Bulls Boston Celtics Los Angeles Lakers Select Team 1 Los Angeles Lakers Select Team 1 Horizontal scroll bar, 1 page\"]/XCUIElementTypePicker/XCUIElementTypePickerWheel");
//        upperPickerWheel.sendKeys("Los Angeles Lakers");
//
//        WebElement lowerPickerWheel = driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Select Team 2 Horizontal scroll bar, 1 page Chicago Bulls Boston Celtics Los Angeles Lakers Select Team 2 Horizontal scroll bar, 1 page Golden State Warriors Miami Heat Chicago Bulls Boston Celtics Los Angeles Lakers Select Team 2 Los Angeles Lakers Select Team 2 Horizontal scroll bar, 1 page\"]/XCUIElementTypePicker/XCUIElementTypePickerWheel");
//        lowerPickerWheel.sendKeys("Boston Celtics");
//
//        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Create Game\"]").click();
//        driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"ActiveGames\"])[2]").click();
//
//        Thread.sleep(300);
//        String createdMatchText = driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Los Angeles Lakers:0 - Boston Celtics:0\"])[2]").getText();
//        System.out.println(createdMatchText);
//        Assert.notNull(createdMatchText, "Match was not created");
//        Assert.isTrue(createdMatchText.equals("Los Angeles Lakers:0 - Boston Celtics:0"), "Match was not created");