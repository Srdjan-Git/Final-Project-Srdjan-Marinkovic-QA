package tests;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AutomobilePage;

import java.io.IOException;

public class Automobile extends BaseTest {

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) throws Exception {
        initialization(browser);
        reporterScreenshot("Start-Test_Automobile", "Starting browser and starting the test Automobile", null);
    }

    @AfterMethod
    @Parameters({"quit"})
    public void tearDown(String quit) throws IOException {
        reporterScreenshot("End-Test-Automobile", "The end test Automobile", null);
        quitBrowser(quit);
    }

    @Test(description = "Search Automobile")
    @Description("Search for the desired car with filters and check the results. Shutting down the filter and re-searching and checking the results.")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("EP001 - Automobile")
    @Feature("FE001 - Search used and new automobile")
    @Story("US001 - Search for the desired automobile with filters")
    @TmsLink("QA1-1")
    @Parameters({"environment"})
    public void test(String environment) throws Exception {
        openApplication(environment, "Application started");
        AutomobilePage automobilePagePage = new AutomobilePage(driver);
        automobilePagePage.clickCookie();
        automobilePagePage.selectBrand("Mercedes Benz");
        automobilePagePage.selectModel("C 220");
        automobilePagePage.enterPriceTo("10000");
        automobilePagePage.selectYearFrom("2007 god.");
        automobilePagePage.selectYearTo("2015 god.");
        automobilePagePage.selectChassis("Karavan");
        automobilePagePage.selectFuel("Benzin");
        automobilePagePage.selectRegion("Beograd");
        automobilePagePage.selectOldNewVehicles("Samo polovna vozila");
        automobilePagePage.checkWaranty();

        automobilePagePage.clickSearchVehicle();
        automobilePagePage.clickSurvey();

        automobilePagePage.assertResultSerach("Trenutno nema rezultata koji odgovaraju tvom kriterijumu pretraživanja. Savetujemo ti da oglasiš kupovinu vozila kakvo tražiš, a mi ćemo te obavestiti kada se takvo vozilo pojavi na sajtu.");

        automobilePagePage.clickCloseFilterWaranty();
        automobilePagePage.clickCloseFilterChassis();
        automobilePagePage.clickCloseFilterFuel();
        automobilePagePage.clickCloseFilterPriceTo();
        automobilePagePage.clickCloseFilterRegion();

        automobilePagePage.selectChassis("Limuzina");
        automobilePagePage.clickSearchVehicle();

        automobilePagePage.assertResultSerachAfterCloseFilters("Prikazano");
    }
}

