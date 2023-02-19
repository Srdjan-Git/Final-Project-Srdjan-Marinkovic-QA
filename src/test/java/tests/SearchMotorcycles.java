package tests;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SearchCarPage;
import pages.SearchMotorcyclesPage;

import java.io.IOException;

public class SearchMotorcycles extends BaseTest {
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
    @Description("Search for the desired motorcycles with filters and check the results. Shutting down the filter and re-searching and checking the results.")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("EP001 - Motorcycles")
    @Feature("FE001 - Search used and new motorcycles")
    @Story("US001 - Search for the desired motorcycles with filters")
    @TmsLink("QA1-1")
    @Parameters({"environment"})
    public void test(String environment) throws Exception {
        openApplication(environment, "Application started");
        SearchMotorcyclesPage searchMotorcyclesPage = new SearchMotorcyclesPage(driver);

        searchMotorcyclesPage.clickCookie();
        searchMotorcyclesPage.clickVehicleMotorcycles();

        searchMotorcyclesPage.selectBrand("Honda");
        searchMotorcyclesPage.enterPriceTo("6000");
        searchMotorcyclesPage.selectYearFrom("1995 god.");
        searchMotorcyclesPage.selectYearTo("2010 god.");
        searchMotorcyclesPage.selectTypeMotorcycles("Chopper / Cruiser");
        searchMotorcyclesPage.selectRegion("Beograd");
        searchMotorcyclesPage.selectTypeMotorcycles("Touring");
        searchMotorcyclesPage.selectRegion("Centralna Srbija");
        searchMotorcyclesPage.checkCredit();

        searchMotorcyclesPage.clickSearchVehicle();
        //searchMotorcyclesPage.clickSurvey();

        searchMotorcyclesPage.assertResultSerachMotorcycles("Prikazano");

        searchMotorcyclesPage.selectSort("ceni silazno");
    }
}
