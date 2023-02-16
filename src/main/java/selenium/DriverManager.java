package selenium;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    WebDriver driver;

    public abstract void createDriver();

    public void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver(String log){
        if (driver == null){
            createDriver();
        }
        System.out.println(log);
        return driver;
    }
}

