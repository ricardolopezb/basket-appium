package org.example;

import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Objects;

public class AppiumClickTest extends BaseIOSTest{
    public static void main(String[] args) throws MalformedURLException {
        IOSDriver driver = BaseIOSTest.desiredCapabilities();
        driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Players\"])[2]").click();

        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");

        driver.executeScript("mobile:scroll", scrollObject);


    }
}
