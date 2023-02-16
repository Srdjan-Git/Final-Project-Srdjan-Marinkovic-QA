package selenium;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(String browser) throws Exception {
        DriverManager driverManager;
        browser = browser.toUpperCase();

        switch (browser){
            case "CHROME":{
                driverManager = new ChromeDriverManager();
            }
            break;
            case "CHROME_H":{
                driverManager = new ChromeDriverManagerHeadles();
            }
            break;
            case "FIREFOX":{
                driverManager = new FirefoxDriverManager();
            }
            break;
            case "FIREFOX_H":{
                driverManager = new FirefoxDriverManagerHeadles();
            }
            break;
            default: throw  new Exception("Browser: " + browser + " is not supported!");
        }

        return driverManager;
    }
}
