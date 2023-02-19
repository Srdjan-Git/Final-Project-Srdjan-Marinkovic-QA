package tests;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import selenium.DriverManager;
import selenium.DriverManagerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    DriverManager driverManager;
    public WebDriver driver;
    String path = "results/screenshots/";
    String randomFileName = "";

    //Metoda za inicijalizovanje browser
    public void initialization(String browser) throws Exception {
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getDriver("Driver running - " + BasePage.getCurrentTimeLog(dateFormater.ddMMyyyyHHmmss));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void quitBrowser(String valueQuit){
        valueQuit = valueQuit.toUpperCase();

        if (valueQuit.equals("YES")){
            driverManager.quitDriver();
        }
    }

    public void openApplication(String environment, String log) throws Exception {
        environment = environment.toUpperCase();

        switch (environment){

            case "LOCAL":{
                driver.get("https://www.local.polovniautomobili.com");
            }
            break;
            case "DEV":{
                driver.get("https://www.dev.polovniautomobili.com");
            }
            break;
            case "QA":{
                driver.get("https://www.qa.polovniautomobili.com");
            }
            break;
            case "STG":{
                driver.get("https://www.stg.polovniautomobili.com");
            }
            break;
            case "UAT":{
                driver.get("https://www.uat.polovniautomobili.com");
            }
            break;
            case "PROD":{
                driver.get("https://www.polovniautomobili.com");
            }
            break;
            default: throw new Exception("Environment: " + environment + " not supported!");
        }

        String timeLog = BasePage.getCurrentTimeLog(dateFormater.ddMMyyyyHHmmss);
        System.out.println(log + " - " + timeLog);
    }

    public void takeScreenshot(String fileName, WebDriver webDriver) throws IOException {
        randomFileName = fileName + "_" + BasePage.getCurrentTimeLog(dateFormater.ddMMyyyy).replace("/", "") + "_" + RandomStringUtils.randomAlphanumeric(6);

        File file = null;

        if (webDriver == null){
            file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        }else{
            file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        }

        FileUtils.copyFile(file, new File(path + randomFileName + ".png"));
    }

    public void reporterScreenshot(String fileName, String description, WebDriver webDriver) throws IOException {
        takeScreenshot(fileName, webDriver);

        Path filePath = Paths.get(path + randomFileName + ".png");

        try(InputStream inputStream = Files.newInputStream(filePath)) {
            Allure.addAttachment(description, inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
