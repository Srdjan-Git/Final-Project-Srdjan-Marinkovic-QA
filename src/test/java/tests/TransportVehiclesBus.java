package tests;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.TransportVehiclesBusPage;

import java.io.IOException;

public class TransportVehiclesBus extends BaseTest {
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
        TransportVehiclesBusPage transportVehiclesBusPage = new TransportVehiclesBusPage(driver);

        transportVehiclesBusPage.clickCookie();
        transportVehiclesBusPage.clickTransportVehicle();
        transportVehiclesBusPage.clickTransportVehicleBus();

        transportVehiclesBusPage.clickSearchVehicle();

        transportVehiclesBusPage.selectBrand("Iveco");
        transportVehiclesBusPage.enterPriceFrom("5000");
        transportVehiclesBusPage.enterPriceTo("10000");
        transportVehiclesBusPage.selectYearFrom("2002 god.");
        transportVehiclesBusPage.selectYearTo("2010 god.");
        transportVehiclesBusPage.selectKmFrom("10000 km");
        transportVehiclesBusPage.selectKmTo("400000 km");
        transportVehiclesBusPage.selectFuel("Dizel");
        transportVehiclesBusPage.selectRegion("Vojvodina");
        transportVehiclesBusPage.selectSeatsFrom("10");
        transportVehiclesBusPage.selectSeatsTo("60");

        transportVehiclesBusPage.clickSearchVehicle();
        //searchMotorcyclesPage.clickSurvey();

        transportVehiclesBusPage.assertResultSerachBus("Prikazano");

        //motorcyclesPage.selectSort("ceni silazno");
    }
}
