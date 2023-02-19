package pages;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.BaseTest;
import tests.dateFormater;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BasePage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    int waitTime = 30;
    int maxRetries = 3;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[title='Naslovna']")
    WebElement homePage;

    public static String getCurrentTimeLog(dateFormater df){
        DateTimeFormatter dtf = null;

        switch (df){
            case ddMMyyyyHHmmss:
                dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                break;
            case ddMMyyyy:
                dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                break;
            case HHmmss:
                dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
                break;
            default:
                dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                break;
        }
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public void assertEqual(String actual, String expected, String log) throws IOException {
        Assert.assertEquals(actual, expected);
        new BaseTest().reporterScreenshot("Result-" + log, "Result - " + log, driver);
        System.out.println("Verified: " + log + " - " + getCurrentTimeLog(dateFormater.ddMMyyyyHHmmss));
    }

    public void goToHomePage() throws Exception {
        click(homePage, "Clicked Home Page");
    }

    public void click(WebElement element, String log) throws Exception {
        webDriverWait = new WebDriverWait(driver, waitTime);
        Actions actions = new Actions(driver);

        int retryCount = 0;

        new BaseTest().reporterScreenshot("Before_Clicking-" + log, "Before clicking on element - " + log,  driver);

        while (retryCount <= maxRetries){

            try {
                webDriverWait.until(ExpectedConditions.visibilityOf(element));
                webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

                actions.moveToElement(element).build().perform();

                element.click();

                System.out.println("Clicked: " + log + " - " + getCurrentTimeLog(dateFormater.ddMMyyyyHHmmss));
                break;
            }catch (Exception e){
                retryCount++;

                System.out.println(retryCount + ".attempt >>>>> " + "Click failed: " + log + " - " + getCurrentTimeLog(dateFormater.ddMMyyyyHHmmss));

                if (retryCount == maxRetries){
                    new BaseTest().reporterScreenshot("Failed_Click-" + log, "Failed click - " + log, driver);
                    throw new Exception("Failed to click element: " + log + " - " + getCurrentTimeLog(dateFormater.ddMMyyyyHHmmss));
                }
            }
        }
        new BaseTest().reporterScreenshot("After_Clicking-" + log, "After clicking on element - " + log, driver);
    }

    public void sendValue(String value, WebElement element, String log) throws Exception {
        webDriverWait = new WebDriverWait(driver, waitTime);
        Actions actions = new Actions(driver);

        int retryCount = 0;

        new BaseTest().reporterScreenshot("Before_Send-" + log, "Before send value on element - " + log,  driver);

        while (retryCount <= maxRetries){

            try {
                webDriverWait.until(ExpectedConditions.visibilityOf(element));

                actions.moveToElement(element).build().perform();

                element.clear();
                element.click();
                element.sendKeys(value);

                System.out.println("Send value: " + log + " - " + getCurrentTimeLog(dateFormater.ddMMyyyyHHmmss));
                break;
            }catch (Exception e){
                retryCount++;

                System.out.println(retryCount + ".attempt >>>>> " + "Send failed: " + log + " - " + getCurrentTimeLog(dateFormater.ddMMyyyyHHmmss));

                if (retryCount == maxRetries){
                    new BaseTest().reporterScreenshot("Failed_Send_Value-" + log, "Failed click - " + log, driver);
                    throw new Exception("Failed to click element: " + log + " - " + getCurrentTimeLog(dateFormater.ddMMyyyyHHmmss));
                }
            }
        }
        new BaseTest().reporterScreenshot("After_Send-" + log, "After send value on element - " + log, driver);
    }

    public void selectValue(String value, WebElement elementClickOnControl, WebElement elementSelectOption, String log) throws Exception {
        webDriverWait = new WebDriverWait(driver, waitTime);
        Actions actions = new Actions(driver);

        int retryCount = 0;

        new BaseTest().reporterScreenshot("Before_Select-" + log, "Before select value on element - " + log,  driver);

        while (retryCount <= maxRetries){

            try {
                webDriverWait.until(ExpectedConditions.visibilityOf(elementClickOnControl));
                webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnControl));

                actions.moveToElement(elementClickOnControl).build().perform();

                elementClickOnControl.click();

                boolean isClicked = false;

                List<WebElement> listElement = elementSelectOption.findElements(By.tagName("li"));

                if (!listElement.isEmpty()){

                    webDriverWait.until(ExpectedConditions.visibilityOf(elementSelectOption));
                    webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectOption));

                    for(WebElement option:listElement){
                        if (option.getText().equals(value)){
                            option.click();
                            isClicked = true;
                            System.out.println("Select value: " + log + " - " + getCurrentTimeLog(dateFormater.ddMMyyyyHHmmss));
                            break;
                        }
                    }
                }
                else{
                    isClicked = true;
                    System.out.println("The List is empty: " + log);
                    break;
                }

                if (!isClicked ){
                    System.out.println("Selected value: " + value + " does not exist: ");
                }

                break;
            }catch (Exception e){
                retryCount++;

                System.out.println(retryCount + ".attempt >>>>> " + "Select failed: " + log + " - " + getCurrentTimeLog(dateFormater.ddMMyyyyHHmmss));

                if (retryCount == maxRetries){
                    System.out.println("Selected ERROR MESSAGE: " + e.getMessage());
                    new BaseTest().reporterScreenshot("Failed_Select_Value-" + log, "Failed select - " + log, driver);
                    throw new Exception("Failed to select element: " + log + " - " + getCurrentTimeLog(dateFormater.ddMMyyyyHHmmss));
                }
            }
        }
        new BaseTest().reporterScreenshot("After_Select-" + log, "After select value on element - " + log, driver);
    }

    public void selectValueWithChecked(String value, WebElement elementClickOnControl, WebElement elementSelectOption, String log) throws Exception {
        webDriverWait = new WebDriverWait(driver, waitTime);
        Actions actions = new Actions(driver);

        int retryCount = 0;

        new BaseTest().reporterScreenshot("Before_Select-" + log, "Before select value on element - " + log,  driver);

        while (retryCount <= maxRetries){

            try {
                webDriverWait.until(ExpectedConditions.visibilityOf(elementClickOnControl));
                webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnControl));

                actions.moveToElement(elementClickOnControl).build().perform();

                elementClickOnControl.click();

                webDriverWait.until(ExpectedConditions.visibilityOf(elementSelectOption));
                webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectOption));

                if (!value.equals("Limuzina")){
                    String oldXpath = "//label[text() = 'Limuzina']/..";
                    String newXpath = oldXpath.replace("Limuzina", value);
                    elementSelectOption = driver.findElement(By.xpath(newXpath));
                }

                elementSelectOption.click();
                System.out.println("Select value: " + log + " - " + getCurrentTimeLog(dateFormater.ddMMyyyyHHmmss));

                break;
            }catch (Exception e){
                retryCount++;

                System.out.println(retryCount + ".attempt >>>>> " + "Select failed: " + log + " - " + getCurrentTimeLog(dateFormater.ddMMyyyyHHmmss));

                if (retryCount == maxRetries){
                    System.out.println("Selected ERROR MESSAGE: " + e.getMessage());
                    new BaseTest().reporterScreenshot("Failed_Select_Value-" + log, "Failed select - " + log, driver);
                    throw new Exception("Failed to select element: " + log + " - " + getCurrentTimeLog(dateFormater.ddMMyyyyHHmmss));
                }
            }
        }
        new BaseTest().reporterScreenshot("After_Select-" + log, "After select value on element - " + log, driver);
    }
}

