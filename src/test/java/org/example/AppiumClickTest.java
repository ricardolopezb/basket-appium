package org.example;

import io.appium.java_client.ios.IOSDriver;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;

public class AppiumClickTest extends BaseIOSTest{
    public static void main(String[] args) throws IOException {
        IOSDriver driver = BaseIOSTest.desiredCapabilities();
        driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Players\"])[2]").click();
        driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Matches\"])[2]").click();
        driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Players\"])[2]").click();

        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");

        driver.executeScript("mobile:scroll", scrollObject);

        actualizarScore();



    }

    private static void actualizarScore() throws IOException {
        String endpoint = "https://f6a2-181-29-89-79.ngrok-free.app/api/match/"; // Reemplazar con el endpoint real
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");

        String body = "{\"matchId\": \"" + "fdecd8f0-24e6-4241-becf-dd98c70f47bb" + "\","
                + "\"playerId\": \"" + "5605aa6e-2531-4018-9dc3-9193fd441286" + "\","
                + "\"points\": " + 1 + ",}";
        connection.setDoOutput(true);

//        try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
//            outputStream.writeBytes(body);
//            outputStream.flush();
//        }
        try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
            byte[] requestBody = body.getBytes(StandardCharsets.UTF_8);
            outputStream.write(requestBody, 0, requestBody.length);
        }

        int responseCode = connection.getResponseCode();
        System.out.println("Respuesta del endpoint: " + responseCode);

        // Leer la respuesta del endpoint si es necesario

        connection.disconnect();
    }

//    public static void main(String[] args) throws MalformedURLException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nombre_del_dispositivo");
//        desiredCapabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "nombre_del_paquete_de_la_aplicacion");
//        desiredCapabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "nombre_de_la_actividad_principal");
//
//        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        // Carga de la pantalla en una lista de scores de partidos de basket
//        AndroidElement scoresList = driver.findElement(By.id("id_de_la_lista"));
//
//        // Obtener el número de score antes de la actualización
//        String scoreAnterior = scoresList.findElement(By.xpath("//android.widget.TextView[1]")).getText();
//
//        // Triggeear el endpoint para actualizar el score
//
//        // Desplazarse hacia abajo para refreshar la pantalla (pull scroll)
//        int startX = scoresList.getLocation().getX() + scoresList.getSize().getWidth() / 2;
//        int startY = scoresList.getLocation().getY() + scoresList.getSize().getHeight() / 2;
//        int endX = startX;
//        int endY = startY - 500;
//
//        TouchAction touchAction = new TouchAction(driver);
//        touchAction.press(startX, startY).waitAction(Duration.ofMillis(500)).moveTo(endX, endY).release().perform();
//
//        // Esperar a que se cargue el loader o elemento de carga
//
//        // Obtener el número de score después de la actualización
//        String scoreActual = scoresList.findElement(By.xpath("//android.widget.TextView[1]")).getText();
//
//        // Verificar que el número de score haya cambiado efectivamente
//        if (!scoreActual.equals(scoreAnterior)) {
//            System.out.println("El score se actualizó correctamente");
//        } else {
//            System.out.println("El score no se actualizó");
//        }
//
//        driver.quit();
//    }
}
