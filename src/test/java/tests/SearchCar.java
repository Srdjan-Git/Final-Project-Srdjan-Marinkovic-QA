package tests;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SearchCarPage;

import java.io.IOException;

public class SearchCar extends BaseTest {

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
        SearchCarPage searchCarPagePage = new SearchCarPage(driver);
        searchCarPagePage.clickCookie();
        searchCarPagePage.selectBrand("Mercedes Benz");
        searchCarPagePage.selectModel("C 220");
        searchCarPagePage.enterPriceTo("10000");
        searchCarPagePage.selectYearFrom("2007 god.");
        searchCarPagePage.selectYearTo("2015 god.");
        searchCarPagePage.selectChassis("Karavan");
        searchCarPagePage.selectFuel("Benzin");
        searchCarPagePage.selectRegion("Beograd");
        searchCarPagePage.selectOldNewVehicles("Samo polovna vozila");
        searchCarPagePage.checkWaranty();

        searchCarPagePage.clickSearchVehicle();
        searchCarPagePage.clickSurvey();

        searchCarPagePage.assertResultSerach("Trenutno nema rezultata koji odgovaraju tvom kriterijumu pretraživanja. Savetujemo ti da oglasiš kupovinu vozila kakvo tražiš, a mi ćemo te obavestiti kada se takvo vozilo pojavi na sajtu.");

        searchCarPagePage.clickCloseFilterWaranty();
        searchCarPagePage.clickCloseFilterChassis();
        searchCarPagePage.clickCloseFilterFuel();
        searchCarPagePage.clickCloseFilterPriceTo();
        searchCarPagePage.clickCloseFilterRegion();

        searchCarPagePage.selectChassis("Limuzina");
        searchCarPagePage.clickSearchVehicle();

        searchCarPagePage.assertResultSerachAfterCloseFilters("Prikazano");
    }
}

