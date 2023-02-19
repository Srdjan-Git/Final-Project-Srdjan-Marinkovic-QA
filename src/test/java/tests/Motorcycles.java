package tests;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.MotorcyclesPage;

import java.io.IOException;

public class Motorcycles extends BaseTest {
    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) throws Exception {
        initialization(browser);
        reporterScreenshot("Start-Test_Motorcycles", "Starting browser and starting the test Motorcycles", null);
    }

    @AfterMethod
    @Parameters({"quit"})
    public void tearDown(String quit) throws IOException {
        reporterScreenshot("End-Test_Motorcycles", "The end test Motorcycles", null);
        quitBrowser(quit);
    }

    @Test(description = "Search Motorcycles")
    @Description("Search for the desired motorcycles with filters and check the results. Sort the obtained results by descending price.")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("EP001 - Motorcycles")
    @Feature("FE001 - Search used and new motorcycles")
    @Story("US001 - Search for the desired motorcycles with filters")
    @TmsLink("QA1-1")
    @Parameters({"environment"})
    public void test(String environment) throws Exception {
        openApplication(environment, "Application started");
        MotorcyclesPage motorcyclesPage = new MotorcyclesPage(driver);

        motorcyclesPage.clickCookie();
        motorcyclesPage.clickVehicleMotorcycles();

        motorcyclesPage.selectBrand("Honda");
        motorcyclesPage.enterPriceTo("6000");
        motorcyclesPage.selectYearFrom("1995 god.");
        motorcyclesPage.selectYearTo("2010 god.");
        motorcyclesPage.selectTypeMotorcycles("Chopper / Cruiser");
        motorcyclesPage.selectRegion("Beograd");
        motorcyclesPage.selectTypeMotorcycles("Touring");
        motorcyclesPage.selectRegion("Centralna Srbija");
        motorcyclesPage.checkCredit();

        motorcyclesPage.clickSearchVehicle();
        //searchMotorcyclesPage.clickSurvey();

        motorcyclesPage.assertResultSerachMotorcycles("Prikazano");

        motorcyclesPage.selectSort("ceni silazno");
    }
}
