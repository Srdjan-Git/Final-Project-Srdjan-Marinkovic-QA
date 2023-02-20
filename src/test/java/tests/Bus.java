package tests;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BusPage;

import java.io.IOException;

public class Bus extends BaseTest {
    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) throws Exception {
        initialization(browser);
        reporterScreenshot("Start-Test_Buses", "Starting browser and starting the test Buses", null);
    }

    @AfterMethod
    @Parameters({"quit"})
    public void tearDown(String quit) throws IOException {
        reporterScreenshot("End-Test_Buses", "The end test Buses", null);
        quitBrowser(quit);
    }

    @Test(description = "Search Buses")
    @Description("Search for the desired bus in more detail and check the results. Clicking on the search button provides additional search filters.")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("EP001 - Buses")
    @Feature("FE001 - Search used and new buses")
    @Story("US001 - More detailed bus search")
    @TmsLink("QA1-1")
    @Parameters({"environment"})
    public void test(String environment) throws Exception {
        openApplication(environment, "Application started");
        BusPage busPage = new BusPage(driver);

        busPage.clickCookie();
        busPage.clickTransportVehicle();
        busPage.clickTransportVehicleBus();

        busPage.clickSearchVehicle();

        busPage.selectBrand("Iveco");
        busPage.enterPriceFrom("5000");
        busPage.enterPriceTo("10000");
        busPage.selectYearFrom("2002 god.");
        busPage.selectYearTo("2010 god.");
        busPage.selectKmFrom("10000 km");
        busPage.selectKmTo("400000 km");
        busPage.selectFuel("Dizel");
        busPage.selectRegion("Vojvodina");
        busPage.selectSeatsFrom("10");
        busPage.selectSeatsTo("60");

        busPage.clickSearchVehicle();
        //searchMotorcyclesPage.clickSurvey();

        busPage.assertResultSerachBus("Prikazano");

        //motorcyclesPage.selectSort("ceni silazno");
    }
}
